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
package io.github.astrapi69.swing.dialog;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.swing.listener.RequestFocusListener;
import io.github.astrapi69.swing.panel.help.HelpModelBean;
import io.github.astrapi69.swing.panel.help.HelpPanel;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

class JOptionPaneExtensionsTest
{
	public static void main(final String[] arguments)
	{
		HelpModelBean model = HelpModelBean.builder().title("Help title").content("Help content")
			.build();

		HelpPanel panel = new HelpPanel(BaseModel.of(model));
		JOptionPane pane = new JOptionPane(panel, JOptionPane.INFORMATION_MESSAGE,
			JOptionPane.OK_CANCEL_OPTION);
		int option;

		// option = getSelectionOptionWithPane(panel, pane);

		// option = getSelectionOptionWithJPanel(panel);

		option = getInfoDialogWithOkCancelButton(panel);

		System.exit(option);
	}

	private static int getInfoDialogWithOkCancelButton(HelpPanel panel)
	{
		return JOptionPaneExtensions.getInfoDialogWithOkCancelButton(panel, "Help",
			panel.getTxtHelpContent());
	}

	private static int getSelectionOptionWithJPanel(HelpPanel panel)
	{
		return JOptionPaneExtensions.getSelectedOption(panel, JOptionPane.INFORMATION_MESSAGE,
			JOptionPane.OK_CANCEL_OPTION, null, "Help", panel.getTxtHelpContent());
	}

	private static int getSelectionOptionWithPane(HelpPanel panel, JOptionPane pane)
	{
		JDialog dialog = pane.createDialog(null, "Help");
		dialog.addWindowFocusListener(new RequestFocusListener(panel.getTxtHelpContent()));
		dialog.pack();
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
		return JOptionPaneExtensions.getSelectedOption(pane);
	}
}
