package io.github.astrapi69.swing.help;

import java.awt.*;

import io.github.astrapi69.window.adapter.CloseWindow;

public class HelpFrameTest
{
    public static void main(final String[] arguments)
    {
        final Frame frame = new HelpFrame("HelpFrameTest", "Help test");
        frame.addWindowListener(new CloseWindow());
        frame.setSize(800, 300);
        // frame.pack();
        frame.setVisible(true);
    }

}
