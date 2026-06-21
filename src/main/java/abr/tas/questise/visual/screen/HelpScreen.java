package abr.tas.questise.visual.screen;



import abr.tas.questise.Utils;
import abr.tas.questise.visual.QuestisePanel;
import abr.tas.questise.visual.component.QButton;

import java.awt.*;
import java.awt.event.MouseEvent;



public class HelpScreen extends Screen {
    private static final Font HELP_FONT = new Font("MS Gothic", Font.BOLD, 30);
    private static final Image MOUSE_IMAGE = Utils.createImage("mouse.png");
    private static final Image ARROW_KEYS_IMAGE = Utils.createImage("arrow_keys.png").getScaledInstance(84, 36, 0);
    private static final Image ESC_IMAGE = Utils.createImage("esc.png").getScaledInstance(60, 48, 0);
    private static final QButton HELP_EXIT_BUTTON = new QButton(Utils.createImage("exit_button.png").getScaledInstance(180, 54, 0), 240, 640);

    private HelpScreen(Screen previous) {
        super(previous);
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        drawCenteredImage(TITLE_IMAGE, 50);
        g.setColor(Color.WHITE);
        g.setFont(HELP_FONT);
        drawCenteredString("Use your CSA skills", 120);
        drawCenteredString("to dodge the", 150);
        drawCenteredString("incoming questorites!", 180);
        drawCenteredImage(MOUSE_IMAGE, 75, 300);
        drawCenteredString("Use mouse to", 260, 285);
        drawCenteredString("answer questions", 260, 315);
        drawCenteredImage(ARROW_KEYS_IMAGE, 75, 400);
        drawCenteredString("Use arrow keys to", 275, 390);
        drawCenteredString("dodge questorites", 275, 415);
        drawCenteredImage(ESC_IMAGE, 75, 480);
        drawCenteredString("Use esc key to", 275, 465);
        drawCenteredString("exit to title screen", 275, 490);
        HELP_EXIT_BUTTON.draw(g);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (HELP_EXIT_BUTTON.isMouseOver(e)) {
            TitleScreen.open(this);
        }
    }

    @Override
    public boolean isMenu() {
        return true;
    }

    public static void open(Screen previous) {
        QuestisePanel.getInstance().openScreen(new HelpScreen(previous));
    }
}
