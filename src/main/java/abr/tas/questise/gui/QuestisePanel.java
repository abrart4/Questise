package abr.tas.questise.gui;

import abr.tas.questise.QuestiseConstants;
import abr.tas.questise.Utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class QuestisePanel extends JPanel implements MouseListener, KeyListener {
    private static final QuestisePanel INSTANCE = new QuestisePanel();

    public static QuestisePanel getInstance() {
        return INSTANCE;
    }

    private final Image TITLE_IMAGE;
    private boolean inMenu = true;


    private QuestisePanel() {
        setLayout(null);
        setBounds(0, 0, QuestiseConstants.WIDTH, QuestiseConstants.HEIGHT);
        TITLE_IMAGE = Utils.createImage("logo.png").getScaledInstance((int) (getWidth() * 0.75), (int) (getWidth() * 0.125), 0);
    }

    @Override
    protected void paintComponent(Graphics gl) {
        Graphics2D g = (Graphics2D) gl;
        super.paintComponent(g);
        Background.getInstance().draw(g, inMenu);
        drawCenteredImage(g, TITLE_IMAGE, getWidth() / 2, 50);
    }

    public void draw() {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static void drawCenteredString(Graphics g, String string, int x, int y) {
        int width = g.getFontMetrics().stringWidth(string);
        int height = g.getFontMetrics().getHeight();
        g.drawString(string, x - (width / 2), y + (height / 2));
    }

    public static void drawCenteredImage(Graphics g, Image image, int x, int y) {
        g.drawImage(image, x - (image.getWidth(null) / 2), y - (image.getHeight(null) / 2), null);
    }
}
