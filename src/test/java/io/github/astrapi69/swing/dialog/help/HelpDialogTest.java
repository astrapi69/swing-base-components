package io.github.astrapi69.swing.dialog.help;

import java.awt.event.ActionEvent;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.swing.layout.ScreenSizeExtensions;
import io.github.astrapi69.swing.panel.help.HelpModelBean;
import io.github.astrapi69.window.adapter.CloseWindow;

public class HelpDialogTest
{

    public static void main(final String[] a)
    {
        HelpModelBean helpModelBean = HelpModelBean.builder().title("Help title")
                .content("Help content").build();
        final HelpDialog dialog = new HelpDialog(null, "Help Dialog", true,
                BaseModel.of(helpModelBean))
        {
            @Override
            protected void onClose(ActionEvent e)
            {
                super.onClose(e);
                System.exit(0);
            }
        };
        dialog.addWindowListener(new CloseWindow());
        ScreenSizeExtensions.centralize(dialog, 3, 3);
        dialog.setSize(800, 300);

        dialog.setVisible(true);
    }
}
