package abr.tas.questise.gui.screen;



import abr.tas.questise.gui.Background;

import java.awt.*;



public class HelpScreen extends Screen {
    private static final Font HELP_FONT = new Font("Cascadia Code Italic", 0, 24);

    public HelpScreen(Screen previous) {
        super(previous);
    }

    @Override
    public void draw(Graphics g) {
        Background.draw(g, true);
        g.setFont(new Font("Palatino Linotype", 0, 24));
        g.setColor(Color.WHITE);
        Screen.drawCenteredString(g, "Protect yourself from incoming obstacles", 240, 100);
        Screen.drawCenteredString(g, "while learning the CSA curriculum!", 240, 130);
    }
}
