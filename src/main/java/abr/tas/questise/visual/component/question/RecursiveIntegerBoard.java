package abr.tas.questise.visual.component.question;



import abr.tas.questise.Utils;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;



public class RecursiveIntegerBoard extends QuestionBoard {
    private static final BufferedImage RECURSIVE_INTEGER_MYSTERY_IMAGE = Utils.createImage("recursive_integer_mystery.png");
    private int parameter;
    private int value;

    public RecursiveIntegerBoard() {
        // have to do this for some reason
        int parameter = Utils.random(5, 10);
        this.parameter = parameter;
        this.value = mystery(parameter);
        super();
    }

    private static int mystery(int x) {
        if (x % 3 == 0) {
            return x;
        }
        return x + (mystery(x - 1));
    }

    @Override
    protected Object getValue() {
        return value;
    }

    @Override
    protected void drawProblem(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Consider the following problem:", 20, 100);
        g.drawImage(RECURSIVE_INTEGER_MYSTERY_IMAGE, 20, 120, null);
        g.drawString("What is the result when calling", 20, 330);
        g.drawString("mystery(" + parameter + ")?", 20, 350);
    }
}
