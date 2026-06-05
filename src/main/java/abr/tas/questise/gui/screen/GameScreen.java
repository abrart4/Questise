package abr.tas.questise.gui.screen;

import abr.tas.questise.gui.Background;
import abr.tas.questise.gui.QuestisePanel;

import java.awt.*;

public class GameScreen extends Screen {
    public GameScreen(Screen previous) {
        super(previous);
    }

    public GameScreen(QuestisePanel panel, int width, int height) {
        super(panel, width, height);
    }

    @Override
    public void draw(Graphics g) {
        Background.getInstance().draw(g, false);
    }
}
