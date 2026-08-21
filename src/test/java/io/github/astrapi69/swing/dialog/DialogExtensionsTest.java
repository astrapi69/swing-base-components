/**
 * The MIT License
 *
 * Copyright (C) 2026 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.swing.dialog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntSupplier;

import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.finder.JOptionPaneFinder;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JOptionPaneFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

/**
 * Unit tests for the {@link DialogExtensions} class, specifically the showOptionDialog method. The
 * modal dialogs are driven by an assertj-swing robot, so a display (real or virtual like Xvfb) is
 * required; in headless environments the tests are skipped
 */
@DisabledIfSystemProperty(named = "java.awt.headless", matches = "true")
public class DialogExtensionsTest
{

	private Robot robot;

	/**
	 * Creates the robot before each test
	 */
	@BeforeEach
	public void setUp()
	{
		robot = BasicRobot.robotWithCurrentAwtHierarchy();
	}

	/**
	 * Releases the robot and all remaining windows after each test
	 */
	@AfterEach
	public void tearDown()
	{
		robot.cleanUp();
	}

	/**
	 * Shows the modal option dialog on a separate daemon thread, resolves the option pane fixture
	 * and returns it together with the result holder
	 *
	 * @param dialogCall
	 *            the call that shows the modal dialog and returns the selected option
	 * @param result
	 *            the holder for the selected option
	 * @return the fixture for the shown option pane
	 */
	private JOptionPaneFixture showOptionDialog(IntSupplier dialogCall, AtomicInteger result)
	{
		Thread thread = new Thread(() -> result.set(dialogCall.getAsInt()));
		thread.setDaemon(true);
		thread.start();
		return JOptionPaneFinder.findOptionPane().using(robot);
	}

	/**
	 * Clicks the given button until the dialog thread has delivered the selected option. Without a
	 * window manager (like on a plain Xvfb display) a single robot click can get lost while the
	 * dialog is still positioning, so the click is retried until the modal call returns
	 *
	 * @param button
	 *            the button to click
	 * @param result
	 *            the holder for the selected option
	 * @return the selected option
	 */
	private int clickAndAwait(JButtonFixture button, AtomicInteger result)
		throws InterruptedException
	{
		for (int attempt = 0; attempt < 6 && result.get() == Integer.MIN_VALUE; attempt++)
		{
			try
			{
				if (attempt < 3)
				{
					button.click();
				}
				else
				{
					// fall back to a programmatic click on the EDT, a robot mouse click can get
					// lost on a display without a window manager
					GuiActionRunner.execute(() -> button.target().doClick());
				}
			}
			catch (RuntimeException ignore)
			{
				// the dialog is already closed and the button is not showing anymore
			}
			for (int i = 0; i < 20 && result.get() == Integer.MIN_VALUE; i++)
			{
				Thread.sleep(50);
			}
		}
		return result.get();
	}

	/**
	 * Tests the showOptionDialog method with default options. The robot clicks the yes button and
	 * the method has to return the yes option
	 */
	@Test
	public void testShowOptionDialogDefaultOptions() throws InterruptedException
	{
		AtomicInteger result = new AtomicInteger(Integer.MIN_VALUE);

		JOptionPaneFixture optionPane = showOptionDialog(
			() -> DialogExtensions.showOptionDialog(null, "Default options test", "Test Dialog",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null),
			result);
		assertEquals(JOptionPane.YES_OPTION, clickAndAwait(optionPane.yesButton(), result));
	}

	/**
	 * Tests the showOptionDialog method with custom options. The robot clicks the second option and
	 * the method has to return its index
	 */
	@Test
	public void testShowOptionDialogWithCustomOptions() throws InterruptedException
	{
		AtomicInteger result = new AtomicInteger(Integer.MIN_VALUE);
		Object[] options = { "Option 1", "Option 2", "Option 3" };

		JOptionPaneFixture optionPane = showOptionDialog(() -> DialogExtensions.showOptionDialog(
			null, "Custom options test", "Custom Dialog", JOptionPane.DEFAULT_OPTION,
			JOptionPane.INFORMATION_MESSAGE, null, options, "Option 2"), result);
		assertEquals(1, clickAndAwait(optionPane.buttonWithText("Option 2"), result));
	}

	/**
	 * Tests the showOptionDialog method with an icon. The robot clicks the OK button and the method
	 * has to return the index of the OK option
	 */
	@Test
	public void testShowOptionDialogWithIcon() throws InterruptedException
	{
		AtomicInteger result = new AtomicInteger(Integer.MIN_VALUE);
		Icon icon = UIManager.getIcon("OptionPane.informationIcon");

		JOptionPaneFixture optionPane = showOptionDialog(() -> DialogExtensions.showOptionDialog(
			null, "Dialog with Icon", "Icon Test", JOptionPane.OK_CANCEL_OPTION,
			JOptionPane.WARNING_MESSAGE, icon, new Object[] { "OK", "Cancel" }, "OK"), result);
		assertEquals(JOptionPane.OK_OPTION, clickAndAwait(optionPane.buttonWithText("OK"), result));
	}

	/**
	 * Tests the showOptionDialog method in a headless environment. Verifies that a
	 * HeadlessException is thrown when running in a headless mode
	 */
	@Test
	public void testShowOptionDialogHeadlessException()
	{
		if (GraphicsEnvironment.isHeadless())
		{
			assertThrows(HeadlessException.class, () -> {
				DialogExtensions.showOptionDialog(null, "Headless test", "Headless Dialog",
					JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
			});
		}
	}

	/**
	 * Tests the showOptionDialog method with a null message. The robot clicks the cancel button and
	 * the method has to return the cancel option
	 */
	@Test
	public void testShowOptionDialogNullMessage() throws InterruptedException
	{
		AtomicInteger result = new AtomicInteger(Integer.MIN_VALUE);

		JOptionPaneFixture optionPane = showOptionDialog(
			() -> DialogExtensions.showOptionDialog(null, null, "Null Message Test",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null),
			result);
		assertEquals(JOptionPane.CANCEL_OPTION, clickAndAwait(optionPane.cancelButton(), result));
	}
}
