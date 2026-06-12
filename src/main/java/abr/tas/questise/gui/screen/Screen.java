package abr.tas.questise.gui.screen;

import abr.tas.questise.gui.QuestisePanel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public abstract class Screen implements MouseListener, KeyListener {
    protected final QuestisePanel panel;
    protected Screen previous;

    public Screen(Screen previous) {
        this(previous.panel);
        this.previous = previous;
    }

    public Screen(QuestisePanel panel) {
        this.panel = panel;
        panel.setLayout(null);
        panel.setBounds(0, 0, 480, 720);
        panel.addMouseListener(this);
        panel.addKeyListener(this);
    }

    public abstract void draw(Graphics g);

    public void close() {
        panel.removeMouseListener(this);
        panel.removeKeyListener(this);
        //panel.openScreen(previous);
    }

    public static void drawCenteredString(Graphics g, String string, int x, int y) {
        int width = g.getFontMetrics().stringWidth(string);
        int height = g.getFontMetrics().getHeight();
        g.drawString(string, x - (width / 2), y + (height / 2));
    }

    public static void drawCenteredImage(Graphics g, Image image, int x, int y) {
        g.drawImage(image, x - (image.getWidth(null) / 2), y - (image.getHeight(null) / 2), null);
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

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyChar());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar());
    }
}
