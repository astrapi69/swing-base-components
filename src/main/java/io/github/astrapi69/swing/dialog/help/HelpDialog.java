package io.github.astrapi69.swing.dialog.help;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import io.github.astrapi69.model.api.IModel;
import io.github.astrapi69.swing.base.BaseDialog;
import io.github.astrapi69.swing.panel.help.HelpModelBean;
import io.github.astrapi69.swing.panel.help.HelpPanel;


/**
 * The class {@link HelpDialog} for a simple help dialog with title and content.
 */
public class HelpDialog extends BaseDialog<HelpModelBean>
{

	private static final long serialVersionUID = 1L;
	JPanel buttons;
	Container container;
	HelpPanel helpPanel;
	/** The button close. */
	private JButton buttonClose;

	public HelpDialog(final Frame owner, final String title, final boolean modal,
		final IModel<HelpModelBean> model)
	{
		super(owner, title, modal, model);
	}

	protected JButton newButtonClose()
	{
		JButton button = new JButton("Close");
		button.addActionListener(e -> onClose(e));
		return button;
	}

	protected JPanel newButtons(final IModel<HelpModelBean> model)
	{
		JPanel buttons = new JPanel();
		return buttons;
	}


	protected HelpPanel newHelpPanel(final IModel<HelpModelBean> model)
	{
		return new HelpPanel(model);
	}

	protected void onClose(final ActionEvent e)
	{
		this.setVisible(false);
		this.dispose();
	}

	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();
		setModal(isModal());

		helpPanel = newHelpPanel(getModel());
		buttonClose = newButtonClose();
		buttons = newButtons(getModel());
	}

	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();
		buttons.add(buttonClose, BorderLayout.EAST);

		container = getContentPane();
		container.add(helpPanel, BorderLayout.CENTER);
		container.add(buttons, BorderLayout.SOUTH);
	}

}
