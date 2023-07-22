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
package io.github.astrapi69.swing.base;

import javax.swing.JLabel;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import io.github.astrapi69.test.object.ApplicationTestModel;
import net.miginfocom.swing.MigLayout;

public class LabelBasePanel extends BasePanel<ApplicationTestModel<String>>
{

	private JLabel lblText;

	/**
	 * creates a new {@link LabelBasePanel}
	 */
	public LabelBasePanel()
	{
		this(BaseModel.of(ApplicationTestModel.<String> builder().build()));
	}

	public LabelBasePanel(final IModel<ApplicationTestModel<String>> model)
	{
		super(model);
	}

	@Override
	protected void onInitializeComponents()
	{
		lblText = new JLabel();
		lblText.setText(getModelObject().getModel());
		add(lblText);
	}

	@Override
	protected void onInitializeLayout()
	{
		MigLayout migLayout = new MigLayout("");
		setLayout(migLayout);
	}

}
