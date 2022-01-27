package io.github.astrapi69.swing.panel.help;

import static io.github.astrapi69.model.typesafe.TypeSafeModel.from;
import static io.github.astrapi69.model.typesafe.TypeSafeModel.model;

import java.awt.*;

import io.github.astrapi69.random.object.RandomStringFactory;
import io.github.astrapi69.window.adapter.CloseWindow;

public class HelpPanelTest
{
    public static void main(final String[] arguments)
    {
        final Frame frame = new Frame("HelpPanel");
        frame.addWindowListener(new CloseWindow());
        String content = RandomStringFactory.newRandomLongString(100000);
        HelpModelBean helpModelBean = HelpModelBean.builder().title("Help title").content(content)
                .build();
        frame.add(new HelpPanel(model(from(helpModelBean))));
        frame.pack();
        frame.setVisible(true);
    }

}
