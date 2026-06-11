package abr.tas.questise.gui.components;



import abr.tas.questise.ImageUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class QButton {
    public Image image;
    public final int x;
    public final int y;
    public final int width;
    public final int height;

    public QButton(String imageName, int centerX, int centerY, int widthDownscale, int heightDownscale) {
        try {
            image = ImageIO.read(new File("src/main/resources/" + imageName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        width = image.getWidth(null) / widthDownscale;
        height = image.getHeight(null) / heightDownscale;
        image = image.getScaledInstance(width, height, 0);
        this.x = centerX - (width / 2);
        this.y = centerY - (height / 2);
    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height, null);
    }

    public boolean isMouseOver(MouseEvent event) {
        int x = event.getX();
        int y = event.getY();
        return x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.height;
    }
}
