package abr.tas.questise.gui.screen;

import abr.tas.questise.gui.Background;
import abr.tas.questise.gui.QuestisePanel;

import java.awt.*;
import java.awt.event.MouseEvent;



public class GameScreen extends Screen {
    public GameScreen(Screen previous) {
        super(previous);
    }

    @Override
    public void draw(Graphics g) {
        Background.draw(g, false);
    }
}
