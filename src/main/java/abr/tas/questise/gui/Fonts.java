package abr.tas.questise.gui;

import java.awt.*;

public class Fonts {
    public static final Font TITLE_FONT = new Font("Monospace 821 BT", Font.BOLD, 50);

    public static void drawCenteredString(Graphics g, String str, int x, int y) {
        int length = g.getFontMetrics().stringWidth(str);
        g.drawString(str, x - (length / 2), y);
    }
}
