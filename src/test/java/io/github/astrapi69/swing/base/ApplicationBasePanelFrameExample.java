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

import java.awt.Frame;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.swing.button.IconButtonFactory;
import io.github.astrapi69.swing.button.builder.JButtonInfo;
import io.github.astrapi69.swing.plaf.LookAndFeels;
import io.github.astrapi69.test.object.ApplicationTestModel;
import io.github.astrapi69.window.adapter.CloseWindow;

public class ApplicationBasePanelFrameExample
	extends
		ApplicationPanelFrame<ApplicationTestModel<String>>
{

	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new {@link ApplicationPanelFrame}
	 *
	 * @param title
	 *            the title
	 */
	public ApplicationBasePanelFrameExample(String title)
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
		final Frame frame = new ApplicationBasePanelFrameExample("ApplicationPanelFrameExample");
		frame.addWindowListener(new CloseWindow());
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	protected String newIconPath()
	{
		return "img/xmas/bell.png";
	}

	@SuppressWarnings("serial")
	@Override
	protected BasePanel<ApplicationTestModel<String>> newMainComponent()
	{
		ApplicationTestModel<String> applicationTestModel = ApplicationTestModel.<String> builder()
			.model("click on the toolbar button to replace the main component").build();

		return new LabelBasePanel(BaseModel.of(applicationTestModel));
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

		// toolBar.add(JComponentFactory
		// .newJButton(directoryIcon, "Dir"));
		// toolBar.add(JComponentFactory
		// .newJButton(fileIcon, "File"));
		JButton computerToolButton = IconButtonFactory.newIconButton(computerIcon);
		computerToolButton.addActionListener(event -> {
			System.out.println("computerToolButton ....");
			ApplicationTestModel<String> applicationTestModel = ApplicationTestModel
				.<String> builder().model("bar").build();
			LabelBasePanel labelPanel = new LabelBasePanel(BaseModel.of(applicationTestModel));
			replaceMainComponent(labelPanel);
		});
		toolBar.add(computerToolButton);
		JButton hardDriveToolButton = IconButtonFactory.newIconButton(hardDriveIcon);
		hardDriveToolButton.addActionListener(event -> {
			System.out.println("hardDriveToolButton ....");
			ApplicationTestModel<String> applicationTestModel = ApplicationTestModel
				.<String> builder().model("bla").build();
			LabelBasePanel labelPanel = new LabelBasePanel(BaseModel.of(applicationTestModel));
			replaceMainComponent(labelPanel);
		});
		toolBar.add(hardDriveToolButton);
		JButton floppyDriveToolButton = JButtonInfo.builder().icon(floppyDriveIcon)
			.actionListener(event -> {
				System.out.println("hardDriveToolButton ....");
				ApplicationTestModel<String> applicationTestModel = ApplicationTestModel
					.<String> builder().model("fasel").build();
				LabelBasePanel labelPanel = new LabelBasePanel(BaseModel.of(applicationTestModel));
				replaceMainComponent(labelPanel);
			}).build().toJButton();
		toolBar.add(floppyDriveToolButton);
		JButton newFolderToolButton = JButtonInfo.builder().icon(floppyDriveIcon)
			.actionListener(event -> {
				System.out.println("newFolderToolButton ....");
				ApplicationTestModel<String> applicationTestModel = ApplicationTestModel
					.<String> builder().model("new folder").build();
				LabelBasePanel labelPanel = new LabelBasePanel(BaseModel.of(applicationTestModel));
				replaceMainComponent(labelPanel);
			}).build().toJButton();
		toolBar.add(newFolderToolButton);
		return toolBar;
	}
}
