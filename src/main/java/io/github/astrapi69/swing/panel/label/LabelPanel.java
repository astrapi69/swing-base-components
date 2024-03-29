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
package io.github.astrapi69.swing.panel.label;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import io.github.astrapi69.swing.base.BasePanel;

public class LabelPanel extends BasePanel<String>
{

	private JLabel lblText;

	/**
	 * creates a new {@link LabelPanel}
	 */
	public LabelPanel()
	{
		this(BaseModel.of(""));
	}

	public LabelPanel(final IModel<String> model)
	{
		super(model);
	}

	@Override
	protected void onInitializeComponents()
	{
		lblText = newJLabel();
		lblText.setText(getModelObject());
		add(lblText);
	}

	/**
	 * Factory method that creates a new {@link JLabel} object. You can overwrite this method and
	 * return your new custom {@link JLabel} object
	 *
	 * @return the {@link JLabel} object
	 */
	protected JLabel newJLabel()
	{
		return new JLabel();
	}

	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();
		setLayout(new BorderLayout());
		add(lblText, BorderLayout.CENTER);
	}

}
