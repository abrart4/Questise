package abr.tas.questise.gui.screen;

import abr.tas.questise.gui.Background;
import abr.tas.questise.gui.Fonts;

import javax.swing.*;
import java.awt.*;

public class TitleScreen extends Screen {
    public TitleScreen(JPanel panel) {
        panel.add(new JButton().setAction(this));
    }

    @Override
    public void draw(Graphics g, int width, int height) {
        Background.getInstance().draw(g, true);
        g.setFont(Fonts.TITLE_FONT);
        g.setColor(Color.WHITE);

        Fonts.drawCenteredString(g, "Questise", width / 2, 75);
    }
}
