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

		option = getSelectionOptionWithJPanel(panel);
		System.exit(0);
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
