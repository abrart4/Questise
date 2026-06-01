package abr.tas.questise.gui.screen;

import abr.tas.questise.gui.Background;
import abr.tas.questise.gui.Fonts;

import java.awt.*;

public class TitleScreen extends Screen {
    @Override
    public void draw(Graphics g) {
        Background.getInstance().draw(g, true);
        g.setFont(Fonts.TITLE_FONT);
        g.drawString("Questise", 5, 50);
    }
}
