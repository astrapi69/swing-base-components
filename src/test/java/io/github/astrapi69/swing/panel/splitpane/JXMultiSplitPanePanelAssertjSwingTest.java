package io.github.astrapi69.swing.panel.splitpane;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.awt.Frame;

import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JPanelFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.github.astrapi69.junit.jupiter.callback.before.test.IgnoreHeadlessExceptionExtension;
import io.github.astrapi69.test.object.ApplicationTestModel;
import io.github.astrapi69.window.adapter.CloseWindow;

public class JXMultiSplitPanePanelAssertjSwingTest
{
	private FrameFixture underTest;

	private JXMultiSplitPanePanel<ApplicationTestModel<String>> multiSplitPanePanel;

	@ExtendWith(IgnoreHeadlessExceptionExtension.class)
	@Test
	public void test()
	{
		final Frame frame = new Frame("JXMultiSplitPanePanel");

		multiSplitPanePanel = TestComponentFactory.newJXMultiSplitPanePanelCustomLayout();
		frame.add(multiSplitPanePanel);
		frame.addWindowListener(new CloseWindow());
		frame.setSize(300, 200);
		frame.setVisible(true);
		underTest = new FrameFixture(frame);
		JPanelFixture focus = underTest.panel("JXMultiSplitPanePanel.JXMultiSplitPane").focus();
		// check target is set
		assertNotNull(focus.target());
	}
}
