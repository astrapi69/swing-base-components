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

import java.awt.Color;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.border.Border;

import io.github.astrapi69.awt.window.adapter.CloseWindow;
import io.github.astrapi69.random.object.RandomStringFactory;
import io.github.astrapi69.swing.button.IconButtonFactory;
import io.github.astrapi69.swing.button.builder.JButtonInfo;
import io.github.astrapi69.swing.panel.desktoppane.JDesktopPanePanel;
import io.github.astrapi69.swing.plaf.LookAndFeels;
import io.github.astrapi69.test.object.ApplicationTestModel;
import lombok.Getter;
import lombok.Setter;

public class ApplicationPanelFrameExample
	extends
		ApplicationPanelFrame<ApplicationTestModel<String>>
{

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	JComponent topComponent;
	@Getter
	@Setter
	JComponent leftComponent;

	@Getter
	@Setter
	JComponent bottomComponent;

	JDesktopPanePanel<ApplicationTestModel<String>> desktopPanePanel;

	MultiSplitPane<ApplicationTestModel<String>> multiSplitPanePanel;

	/**
	 * Instantiates a new {@link ApplicationPanelFrameExample}
	 *
	 * @param title
	 *            the title
	 */
	public ApplicationPanelFrameExample(String title)
	{
		super(title);
		setDefaultLookAndFeel(LookAndFeels.NIMBUS, this);
	}

	/**
	 * Test init layout.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args)
	{
		final Frame frame = new ApplicationPanelFrameExample("ApplicationPanelFrameExample");
		frame.addWindowListener(new CloseWindow());
		frame.pack();

		frame.setSize(500, 500);
		frame.setVisible(true);
	}

	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();
		multiSplitPanePanel = (MultiSplitPane<ApplicationTestModel<String>>)getMainComponent();
		desktopPanePanel = new JDesktopPanePanel<>();
	}

	protected JComponent newBottomComponent()
	{
		JLabel label = new JLabel("Bottom Component");
		Border border = BorderFactory.createLineBorder(Color.lightGray, 1);
		label.setBorder(border);
		return label;
	}


	@Override
	protected String newIconPath()
	{
		return "img/xmas/bell.png";
	}

	protected JComponent newLeftComponent()
	{
		JLabel label = new JLabel("Left Component");
		Border border = BorderFactory.createLineBorder(Color.lightGray, 1);
		label.setBorder(border);
		return label;
	}

	@SuppressWarnings("serial")
	@Override
	protected BasePanel<ApplicationTestModel<String>> newMainComponent()
	{
		topComponent = newTopComponent();
		leftComponent = newLeftComponent();
		bottomComponent = newBottomComponent();
		// multiSplitPanePanel.getMultiSplitPane().add(topComponent, "content");
		// multiSplitPanePanel.getMultiSplitPane().add(bottomComponent, "bottom");
		// multiSplitPanePanel.getMultiSplitPane().add(leftComponent, "left");

		final JSplitPane multiSplitPanePanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
			topComponent, leftComponent);
		MultiSplitPane multiSplitPane = new MultiSplitPane<>();
		return multiSplitPane;
	}

	protected JComponent newTopComponent()
	{
		JLabel label = new JLabel("Top Component");
		Border border = BorderFactory.createLineBorder(Color.lightGray, 1);
		label.setBorder(border);
		return label;
	}

	@Override
	protected JToolBar newJToolBar()
	{
		JToolBar toolBar = super.newJToolBar();
		toolBar.setSize(this.getWidth(), 25);

		Icon directoryIcon = UIManager.getIcon("FileView.directoryIcon");
		Icon fileIcon = UIManager.getIcon("FileView.fileIcon");
		Icon computerIcon = UIManager.getIcon("FileView.computerIcon");
		Icon hardDriveIcon = UIManager.getIcon("FileView.hardDriveIcon");
		Icon floppyDriveIcon = UIManager.getIcon("FileView.floppyDriveIcon");

		Icon newFolderIcon = UIManager.getIcon("FileChooser.newFolderIcon");
		Icon upFolderIcon = UIManager.getIcon("FileChooser.upFolderIcon");
		Icon homeFolderIcon = UIManager.getIcon("FileChooser.homeFolderIcon");
		Icon detailsViewIcon = UIManager.getIcon("FileChooser.detailsViewIcon");
		Icon listViewIcon = UIManager.getIcon("FileChooser.listViewIcon");


		JButton listViewToolButton = IconButtonFactory.newIconButton(listViewIcon);
		listViewToolButton.addActionListener(event -> {
			replaceMainComponent(desktopPanePanel);
		});
		toolBar.add(listViewToolButton);
		JButton detailsViewToolButton = IconButtonFactory.newIconButton(detailsViewIcon);
		detailsViewToolButton.addActionListener(event -> {
			replaceMainComponent(multiSplitPanePanel);
		});
		toolBar.add(detailsViewToolButton);
		JButton computerToolButton = IconButtonFactory.newIconButton(computerIcon);
		computerToolButton.addActionListener(event -> {
			JLabel label = new JLabel(
				"New Left Component ::" + RandomStringFactory.newRandomString(10) + "::");
			Border border = BorderFactory.createLineBorder(Color.lightGray, 1);
			label.setBorder(border);

		});
		toolBar.add(computerToolButton);
		JButton hardDriveToolButton = IconButtonFactory.newIconButton(hardDriveIcon);
		hardDriveToolButton.addActionListener(event -> {
			JLabel label = new JLabel(
				"New Top Component ::" + RandomStringFactory.newRandomString(10) + "::");
			Border border = BorderFactory.createLineBorder(Color.lightGray, 1);
			label.setBorder(border);

		});
		toolBar.add(hardDriveToolButton);
		JButton floppyDriveToolButton = JButtonInfo.builder().icon(floppyDriveIcon)
			.actionListener(event -> {
				JLabel label = new JLabel(
					"New Bottom Component ::" + RandomStringFactory.newRandomString(10) + "::");
				Border border = BorderFactory.createLineBorder(Color.lightGray, 1);
				label.setBorder(border);


			}).build().toJButton();
		toolBar.add(floppyDriveToolButton);

		JButton newFolderToolButton = JButtonInfo.builder().icon(newFolderIcon)
			.actionListener(event -> {

			}).build().toJButton();
		toolBar.add(newFolderToolButton);

		return toolBar;
	}
}
