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
package io.github.astrapi69.swing.util;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import io.github.astrapi69.swing.base.ApplicationPanelFrame;
import io.github.astrapi69.swing.base.BasePanel;
import io.github.astrapi69.swing.panel.desktoppane.JDesktopPanePanel;
import lombok.experimental.UtilityClass;

/**
 * The class {@link JInternalFrameExtensions} provides mentods for add components to
 * {@link JInternalFrame} objects
 */
@UtilityClass
public class JInternalFrameExtensions
{

	/**
	 * Adds the given {@link Component} object to the given {@link JInternalFrame} object
	 *
	 * @param internalFrame
	 *            the {@link JInternalFrame} object
	 * @param component
	 *            the {@link Component} object to add
	 */
	public static void addComponentToFrame(final JInternalFrame internalFrame,
		final Component component)
	{
		internalFrame.add(component, BorderLayout.CENTER);
		internalFrame.pack();
	}

	/**
	 * Adds the given {@link JInternalFrame} object to the given {@link JDesktopPane} object and
	 * bring it to the front.
	 *
	 * @param desktopPane
	 *            the {@link JDesktopPane} object
	 * @param internalFrame
	 *            the {@link JInternalFrame} object
	 */
	public static void addJInternalFrame(final JDesktopPane desktopPane,
		final JInternalFrame internalFrame)
	{
		desktopPane.add(internalFrame);
		internalFrame.setVisible(true);
		internalFrame.toFront();
	}

	/**
	 *
	 * Adds the given {@link Component} object to the given main {@link JInternalFrame} object and
	 * then to the given main {@link ApplicationPanelFrame} object and bring it to the front
	 *
	 * @param <T>
	 *            the generic type of the model object of the {@link ApplicationPanelFrame} object
	 * @param component
	 *            the {@link Component} object to add
	 * @param internalFrame
	 *            the {@link JInternalFrame} object
	 * @param mainFrame
	 *            the {@link ApplicationPanelFrame} object
	 */
	public static <T> void addInternalFrameToMainFrame(final Component component,
		JInternalFrame internalFrame, ApplicationPanelFrame<T> mainFrame)
	{
		JInternalFrameExtensions.addComponentToFrame(internalFrame, component);
		JInternalFrameExtensions.addInternalFrameToMainFrame(internalFrame, mainFrame);
	}

	/**
	 * Adds the given {@link JInternalFrame} object to the given main {@link ApplicationPanelFrame}
	 * object and bring it to the front
	 *
	 * @param <T>
	 *            the generic type of the model object of the {@link ApplicationPanelFrame} object
	 * @param internalFrame
	 *            the {@link JInternalFrame} object
	 * @param mainFrame
	 *            the {@link ApplicationPanelFrame} object
	 */
	public static <T> void addInternalFrameToMainFrame(JInternalFrame internalFrame,
		ApplicationPanelFrame<T> mainFrame)
	{
		BasePanel<T> mainComponent = mainFrame.getMainComponent();
		if (mainComponent instanceof JDesktopPanePanel)
		{
			JDesktopPanePanel<T> desktopPanePanel = (JDesktopPanePanel<T>)mainComponent;
			JInternalFrameExtensions.addJInternalFrame(desktopPanePanel.getDesktopPane(),
				internalFrame);
		}
	}

}
