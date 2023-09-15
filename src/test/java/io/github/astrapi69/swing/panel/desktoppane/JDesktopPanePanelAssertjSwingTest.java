/**
 * The MIT License
 *
 * Copyright (C) 2021 Asterios Raptis
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
package io.github.astrapi69.swing.panel.desktoppane;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.awt.Frame;

import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JPanelFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.github.astrapi69.awt.window.adapter.CloseWindow;
import io.github.astrapi69.junit.jupiter.callback.before.test.IgnoreHeadlessExceptionExtension;
import io.github.astrapi69.test.object.ApplicationTestModel;

public class JDesktopPanePanelAssertjSwingTest
{
	private FrameFixture underTest;

	private JDesktopPanePanel<ApplicationTestModel<String>> desktopPanePanel;

	@ExtendWith(IgnoreHeadlessExceptionExtension.class)
	@Test
	public void test()
	{
		final Frame frame = new Frame("JDesktopPanePanel");

		desktopPanePanel = new JDesktopPanePanel<>();
		frame.add(desktopPanePanel);
		frame.addWindowListener(new CloseWindow());
		frame.setSize(300, 200);
		frame.setVisible(true);
		underTest = new FrameFixture(frame);
		JPanelFixture focus = underTest.panel().click();
		// check target is set
		assertNotNull(focus.target());
		frame.setVisible(false);
		frame.dispose();
		underTest = null;
	}
}
