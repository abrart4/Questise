package abr.tas.questise;



import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class Utils {
    public static BufferedImage createImage(String fileName) {
        try {
            return ImageIO.read(new File("src/main/resources/" + fileName));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
