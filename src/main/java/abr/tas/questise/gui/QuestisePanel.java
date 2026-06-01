package abr.tas.questise.gui;

import abr.tas.questise.gui.screen.Screen;
import abr.tas.questise.gui.screen.TitleScreen;

import javax.swing.*;
import java.awt.*;

public class QuestisePanel extends JPanel {
    private static final QuestisePanel INSTANCE = new QuestisePanel();

    public static QuestisePanel getInstance() {
        return INSTANCE;
    }

    private Screen currentScreen = new TitleScreen();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        currentScreen.draw(g);
    }

    public void loop() {
        repaint();
    }
}
