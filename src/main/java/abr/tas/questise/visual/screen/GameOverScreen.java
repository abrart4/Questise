package abr.tas.questise.visual.screen;



import abr.tas.questise.Utils;
import abr.tas.questise.visual.QuestisePanel;
import abr.tas.questise.visual.component.QButton;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;



public class GameOverScreen extends Screen {
    private static final Font GAME_OVER_FONT = new Font("MS Gothic", Font.PLAIN, 40);
    private static final QButton GAME_OVER_EXIT_BUTTON = new QButton(Utils.createImage("exit_button.png").getScaledInstance(180, 54, 0), 240, 440);

    private final double timeSurvived;

    private GameOverScreen(Screen previous, long timeStarted, long timeEnded) {
        super(previous);
        this.timeSurvived = ((double) timeEnded - timeStarted) / 1000;
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        g.setColor(Color.GRAY);
        g.fillRect(80, 175, 320, 330);
        g.setColor(Color.WHITE);
        g.setFont(GAME_OVER_FONT);
        drawCenteredString("Game over!", 240);
        drawCenteredString("You survived", 300);
        drawCenteredString( timeSurvived + " seconds.", 340);
        GAME_OVER_EXIT_BUTTON.draw(g);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (GAME_OVER_EXIT_BUTTON.isMouseOver(e)) {
            TitleScreen.open(this);
        }
    }

    @Override
    public boolean isMenu() {
        return false;
    }

    public static void open(Screen previous, long timeStarted, long timeEnded) {
        QuestisePanel.getInstance().openScreen(new GameOverScreen(previous, timeStarted, timeEnded));
    }
}
