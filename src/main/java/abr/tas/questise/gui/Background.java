package abr.tas.questise.gui;

import abr.tas.questise.ImageUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

public class Background {
    private static final Background INSTANCE = new Background();

    public static Background getInstance() {
        return INSTANCE;
    }

    private Background() {}

    private final BufferedImage image = ImageUtils.create("src/main/resources/background.jpg");
    private int brightness = 0;

    public void draw(Graphics g, boolean menu) {
        if (menu) brightness = -100;
        RescaleOp op = new RescaleOp(1, brightness, null);
        g.drawImage(op.filter(image, null), 0, 0, null);
    }
}
