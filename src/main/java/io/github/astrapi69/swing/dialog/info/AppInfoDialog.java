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
package io.github.astrapi69.swing.dialog.info;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import io.github.astrapi69.model.api.IModel;
import io.github.astrapi69.swing.base.BaseDialog;
import io.github.astrapi69.swing.panel.info.AppInfoPanel;
import io.github.astrapi69.swing.panel.info.InfoModelBean;

/**
 * The class {@link AppInfoDialog} for display a simple info message
 */
public class AppInfoDialog extends BaseDialog<InfoModelBean>
{

	private static final long serialVersionUID = 1L;
	JPanel buttons;
	Container container;
	AppInfoPanel infoPanel;
	/** The button close. */
	private JButton buttonClose;

	public AppInfoDialog(final Frame owner, final String title, final boolean modal,
		final IModel<InfoModelBean> model)
	{
		super(owner, title, modal, model);
	}

	protected JButton newButtonClose()
	{
		JButton button = new JButton("Close");
		button.addActionListener(e -> onClose(e));
		return button;
	}

	protected JPanel newButtons(final IModel<InfoModelBean> model)
	{
		JPanel buttons = new JPanel();
		return buttons;
	}


	protected AppInfoPanel newAppInfoPanel(final IModel<InfoModelBean> model)
	{
		return new AppInfoPanel(model);
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

		infoPanel = newAppInfoPanel(getModel());
		buttonClose = newButtonClose();
		buttons = newButtons(getModel());
	}

	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();
		buttons.add(buttonClose, BorderLayout.EAST);

		container = getContentPane();
		container.add(infoPanel, BorderLayout.CENTER);
		container.add(buttons, BorderLayout.SOUTH);
	}

}
