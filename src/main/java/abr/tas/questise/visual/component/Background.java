package abr.tas.questise.visual.component;



import abr.tas.questise.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;



public class Background {
    private static final Background INSTANCE = new Background();

    public static Background getInstance() {
        return INSTANCE;
    }

    private final BufferedImage BACKGROUND_NORMAL_IMAGE = Utils.createImage("background_normal.jpg");
    private final BufferedImage BACKGROUND_DARKENED_IMAGE = Utils.createImage("background_darkened.jpg");
    private int backgroundX = 0;
    private final double backgroundXModifier = 0.25;
    private int increment = 0;

    private Background() {}

    public void draw(Graphics2D g, boolean inMenu) {
        if (increment % (1 / backgroundXModifier) == 0) {
            backgroundX -= 1;
        }
        increment ++;
        if (backgroundX <= -3840) backgroundX = 0;
        g.drawImage(inMenu ? BACKGROUND_DARKENED_IMAGE : BACKGROUND_NORMAL_IMAGE, backgroundX, 0, null);
    }
}
