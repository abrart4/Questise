package abr.tas.questise.visual.screen;



import abr.tas.questise.Utils;
import abr.tas.questise.visual.component.Background;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public abstract class Screen implements KeyListener, MouseListener {
    protected static final Image TITLE_IMAGE = Utils.createImage("logo.png").getScaledInstance(360, 60, 0);

    protected Graphics2D g;
    protected int width;
    protected int height;

    protected Screen(Screen previous) {
        this(previous.width, previous.height);
    }

    protected Screen(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics2D g) {
        this.g = g;
        Background.getInstance().draw(g, isMenu());
    }

    public abstract boolean isMenu();


    public void drawCenteredString(String string, int y) {
        drawCenteredString(string, width / 2, y);
    }

    public void drawCenteredString(String string, int x, int y) {
        int width = g.getFontMetrics().stringWidth(string);
        int height = g.getFontMetrics().getHeight();
        g.drawString(string, x - (width / 2), y + (height / 2));
    }

    public void drawCenteredImage(Image image, int y) {
        drawCenteredImage(image, width / 2, y);
    }

    public void drawCenteredImage(Image image, int x, int y) {
        g.drawImage(image, x - (image.getWidth(null) / 2), y - (image.getHeight(null) / 2), null);
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
}
