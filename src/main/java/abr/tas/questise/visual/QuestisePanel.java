package abr.tas.questise.visual;

import abr.tas.questise.Utils;
import abr.tas.questise.visual.component.QButton;
import abr.tas.questise.visual.component.Questorite;
import abr.tas.questise.visual.component.question.QuestionBoard;
import abr.tas.questise.visual.component.question.QuestionResult;
import abr.tas.questise.visual.component.question.RecursiveIntegerBoard;
import abr.tas.questise.visual.screen.Screen;
import abr.tas.questise.visual.screen.TitleScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;



public class QuestisePanel extends JPanel implements MouseListener, KeyListener {
    private static final QuestisePanel INSTANCE = new QuestisePanel();

    public static QuestisePanel getInstance() {
        return INSTANCE;
    }

    private Screen currentScreen;

    private QuestisePanel() {
        setLayout(null);
        setBounds(0, 0, 480, 720);
        addKeyListener(this);
        addMouseListener(this);
        currentScreen = new TitleScreen(getWidth(), getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        currentScreen.draw((Graphics2D) g);
    }

    public void draw() {
        repaint();
    }

    public void openScreen(Screen screen) {
        this.currentScreen = screen;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        currentScreen.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        currentScreen.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        currentScreen.keyReleased(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        currentScreen.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        currentScreen.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        currentScreen.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        currentScreen.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        currentScreen.mouseExited(e);
    }
}
