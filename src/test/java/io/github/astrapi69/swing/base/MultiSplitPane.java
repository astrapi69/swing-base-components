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
