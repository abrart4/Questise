package abr.tas.questise.visual.component;



import java.awt.*;
import java.awt.event.MouseEvent;



public class QButton {
    private final Image image;
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    public QButton(Image image, int centerX, int centerY) {
        this.image = image;
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
        this.x = centerX - (width / 2);
        this.y = centerY - (height / 2);
    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height, null);
    }

    public boolean isMouseOver(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
    }
}
