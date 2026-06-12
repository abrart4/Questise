package abr.tas.questise;

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

    private final BufferedImage BACKGROUND_NORMAL_IMAGE = createImage("background_normal.jpg");
    private final BufferedImage BACKGROUND_DARKENED_IMAGE = createImage("background_darkened.jpg");
    private static final BufferedImage TITLE_IMAGE = createImage("logo.png");
    private boolean inMenu = true;

    private QuestisePanel() {
        setLayout(null);
        setBounds(0, 0, 480, 720);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(inMenu ? BACKGROUND_DARKENED_IMAGE : BACKGROUND_NORMAL_IMAGE, 0, 0, null);
        drawCenteredImage(g, TITLE_IMAGE.getScaledInstance(1024 / 3, 342 / 6, 0), 240, 50);
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

    public static BufferedImage createImage(String fileName) {
        try {
            return ImageIO.read(new File("src/main/resources/" + fileName));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
