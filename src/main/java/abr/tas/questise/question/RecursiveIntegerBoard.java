package abr.tas.questise.question;



import abr.tas.questise.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;



public class RecursiveIntegerBoard extends AlgorithmicBoard {
    private static final BufferedImage RECURSIVE_INTEGER_MYSTERY_IMAGE = Utils.createImage("recursive_integer_mystery.png");

    public RecursiveIntegerBoard() {
        super();
        parameter = Utils.random(5, 10);
        value = mystery(parameter);
    }

    @Override
    protected int mystery(int x) {
        if (x % 3 == 0) {
            return x;
        }
        return x + (mystery(x - 1));
    }

    @Override
    protected BufferedImage getImage() {
        return RECURSIVE_INTEGER_MYSTERY_IMAGE;
    }
}
