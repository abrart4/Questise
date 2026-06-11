package abr.tas.questise.gui.screen;

import abr.tas.questise.ImageUtils;
import abr.tas.questise.gui.Background;
import abr.tas.questise.gui.QuestisePanel;
import abr.tas.questise.gui.components.QButton;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;



public class TitleScreen extends Screen {
    private static final BufferedImage TITLE_IMAGE = ImageUtils.create("logo.png");
    private static final QButton PLAY_BUTTON = new QButton("play_button.png", 240, 550, 2, 2);
    private static final QButton HELP_BUTTON = new QButton("help_button.png", 240, 640, 3, 3);

    public TitleScreen(Screen previous) {
        super(previous);
    }

    public TitleScreen(QuestisePanel panel) {
        super(panel);
    }

    @Override
    public void draw(Graphics g) {
        Background.draw(g, true);
        drawCenteredImage(g, TITLE_IMAGE.getScaledInstance(1024 / 3, 342 / 6, 0), 240, 50);
        PLAY_BUTTON.draw(g);
        HELP_BUTTON.draw(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (PLAY_BUTTON.isMouseOver(e)) {
            panel.openScreen(new GameScreen(this));
        }
        if (HELP_BUTTON.isMouseOver(e)) {
            panel.openScreen(new HelpScreen(this));
        }
    }
}
