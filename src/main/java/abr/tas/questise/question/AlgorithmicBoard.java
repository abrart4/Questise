package abr.tas.questise.question;



import abr.tas.questise.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;



public abstract class AlgorithmicBoard extends QuestionBoard {
    protected int parameter;
    protected int value;

    public AlgorithmicBoard() {
        super();
    }

    protected abstract int mystery(int x);

    @Override
    protected Object getValue() {
        return value;
    }

    @Override
    protected void drawProblem(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Consider the following problem:", 20, 100);
        g.drawImage(getImage(), 20, 120, null);
        g.drawString("What is the result when calling", 20, 330);
        g.drawString("mystery(" + parameter + ")?", 20, 350);
    }

    protected abstract BufferedImage getImage();
}
