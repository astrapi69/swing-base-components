package io.github.astrapi69.swing.dialog;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;

import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link DialogExtensions} class, specifically the showOptionDialog method
 */
public class DialogExtensionsTest
{

	/**
	 * Tests the showOptionDialog method with default options. Verifies that the method does not
	 * throw exceptions and returns a valid selection value.
	 */
	@Test
	@Disabled("run with Headless")
	void testShowOptionDialogDefaultOptions()
	{
		assertDoesNotThrow(() -> {
			int result = DialogExtensions.showOptionDialog(null, "Default options test",
				"Test Dialog", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null,
				null);
			assertTrue(result == JOptionPane.YES_OPTION || result == JOptionPane.NO_OPTION
				|| result == JOptionPane.CLOSED_OPTION);
			// example from stackoverflow.com
			Object[] options = { "Yes, please", "No way!" };
			int n = DialogExtensions.showOptionDialog(null, "Would you like green eggs and ham?",
				"A Silly Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, // do
																									// not
																									// use
																									// a
																									// custom
																									// Icon
				options, // the titles of buttons
				options[0]); // default button title
		});
	}

	/**
	 * Tests the showOptionDialog method with custom options. Verifies that the method does not
	 * throw exceptions and returns a valid index for the selected option.
	 */
	@Test
	@Disabled("run with Headless")
	void testShowOptionDialogWithCustomOptions()
	{
		assertDoesNotThrow(() -> {
			Object[] options = { "Option 1", "Option 2", "Option 3" };
			int result = DialogExtensions.showOptionDialog(null, "Custom options test",
				"Custom Dialog", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
				options, "Option 2");
			assertTrue(result >= 0 || result == JOptionPane.CLOSED_OPTION);
		});
	}

	/**
	 * Tests the showOptionDialog method with an icon. Verifies that the method does not throw
	 * exceptions and returns a valid selection value.
	 */
	@Test
	@Disabled("run with Headless")
	void testShowOptionDialogWithIcon()
	{
		assertDoesNotThrow(() -> {
			Icon icon = UIManager.getIcon("OptionPane.informationIcon");
			int result = DialogExtensions.showOptionDialog(null, "Dialog with Icon", "Icon Test",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, icon,
				new Object[] { "OK", "Cancel" }, "OK");
			assertTrue(result == JOptionPane.OK_OPTION || result == JOptionPane.CANCEL_OPTION
				|| result == JOptionPane.CLOSED_OPTION);
		});
	}

	/**
	 * Tests the showOptionDialog method in a headless environment. Verifies that a
	 * HeadlessException is thrown when running in a headless mode.
	 */
	@Test
	@Disabled("run with Headless")
	void testShowOptionDialogHeadlessException()
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
	 * Tests the showOptionDialog method with a null message. Verifies that the method does not
	 * throw exceptions and returns CLOSED_OPTION.
	 */
	@Test
	@Disabled("run with Headless")
	void testShowOptionDialogNullMessage()
	{
		assertDoesNotThrow(() -> {
			int result = DialogExtensions.showOptionDialog(null, null, "Null Message Test",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
			assertEquals(JOptionPane.CLOSED_OPTION, result);
		});
	}
}
