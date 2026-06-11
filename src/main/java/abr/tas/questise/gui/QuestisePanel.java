package abr.tas.questise.gui;

import abr.tas.questise.gui.screen.Screen;
import abr.tas.questise.gui.screen.TitleScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class QuestisePanel extends JPanel {
    private static final QuestisePanel INSTANCE = new QuestisePanel();

    public static QuestisePanel getInstance() {
        return INSTANCE;
    }

    private Screen currentScreen = new TitleScreen(this);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        currentScreen.draw(g);
    }

    public void openScreen(Screen screen) {
        if (screen != null) screen.close();
        currentScreen = screen;
    }

    public void loop() {
        repaint();
    }
}
