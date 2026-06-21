package abr.tas.questise.visual.screen;



import abr.tas.questise.Utils;
import abr.tas.questise.visual.QuestisePanel;
import abr.tas.questise.visual.component.QButton;

import java.awt.*;
import java.awt.event.MouseEvent;



public class TitleScreen extends Screen {
    private static final Image PURE_ART_IMAGE = Utils.createImage("pure_art.png").getScaledInstance(240, 360, 0);
    private final QButton PLAY_BUTTON = new QButton(Utils.createImage("play_button.png").getScaledInstance(240, 72, 0), 240, 560);
    private final QButton HELP_BUTTON = new QButton(Utils.createImage("help_button.png").getScaledInstance(180,  54, 0), 240, 640);
    private static final Font WARNING_FONT = new Font("MS Gothic", Font.BOLD, 20);

    private TitleScreen(Screen previous) {
        super(previous);
    }

    public TitleScreen(int width, int height) {
        super(width, height);
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        drawCenteredImage(TITLE_IMAGE, 50);
        drawCenteredImage(PURE_ART_IMAGE, 300);
        g.setColor(Color.WHITE);
        g.setFont(WARNING_FONT);
        drawCenteredString("(please don't collect the questorites!)", 500);
        PLAY_BUTTON.draw(g);
        HELP_BUTTON.draw(g);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (PLAY_BUTTON.isMouseOver(e)) {
            GameScreen.open(this);
        }
        else if (HELP_BUTTON.isMouseOver(e)) {
            HelpScreen.open(this);
        }
    }

    @Override
    public boolean isMenu() {
        return true;
    }

    public static void open(Screen previous) {
        QuestisePanel.getInstance().openScreen(new TitleScreen(previous));
    }
}
