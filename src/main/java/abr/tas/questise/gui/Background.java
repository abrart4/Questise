package abr.tas.questise.gui;

import abr.tas.questise.ImageUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

public class Background {
    private static final BufferedImage BACKGROUND_NORMAL = ImageUtils.create("background_normal.jpg");
    private static final BufferedImage BACKGROUND_DARKENED = ImageUtils.create("background_darkened.jpg");

    public static void draw(Graphics g, boolean menu) {
        Image image = menu ? BACKGROUND_DARKENED : BACKGROUND_NORMAL;
        g.drawImage(image, 0, 0, null);
    }
}
