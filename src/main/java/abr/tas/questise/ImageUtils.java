package abr.tas.questise;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageUtils {
    public static BufferedImage create(String file) {
        try {
            return ImageIO.read(new File("src/main/resources/" + file));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
