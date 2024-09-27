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

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import net.miginfocom.swing.MigLayout;

public class MultiSplitPane<T> extends BasePanel<T>
{

	/**
	 * creates a new {@link MultiSplitPane}
	 */
	public MultiSplitPane()
	{
		this(BaseModel.of());
	}

	public MultiSplitPane(final IModel<T> model)
	{
		super(model);
	}

	@Override
	protected void onInitializeComponents()
	{
		this.setLayout(new BorderLayout());
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Color.BLUE);
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.CYAN);
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(Color.GREEN);

		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, centerPanel);
		JSplitPane sp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp, rightPanel);

		this.add(sp2, BorderLayout.CENTER);
		this.setSize(500, 500);
	}

	@Override
	protected void onInitializeLayout()
	{
		MigLayout migLayout = new MigLayout("");
		setLayout(migLayout);
	}
}
