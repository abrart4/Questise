package abr.tas.questise.gui.component.question;



import abr.tas.questise.Utils;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;



public class RecursiveIntegerBoard extends QuestionBoard {
    private static final BufferedImage RECURSIVE_INTEGER_MYSTERY_IMAGE = Utils.createImage("recursive_integer_mystery.png");
    private static final ArrayList<Rectangle> ANSWER_RECTANGLES = new ArrayList<>();
    private final int parameter;
    private final int value;
    private final int correctIndex;
    private final ArrayList<String> answers = new ArrayList<>();

    static {
        for (int i = 120; i <= 300; i += 60) {
            ANSWER_RECTANGLES.add(new Rectangle(350, i, 130, 60));
        }
    }

    public RecursiveIntegerBoard() {
        this.parameter = Utils.random(5, 10);
        this.value = mystery(parameter);
        correctIndex = Utils.random(0, 3);
        for (int i = 0; i < 4; i ++) {
            if (i == correctIndex) {
                answers.add(String.valueOf(value));
            }
            else {
                int random = 0;
                while (random == 0) {
                    random = Utils.random(-10, 10);
                }
                answers.add(String.valueOf(value + random));
            }
        }
    }

    private int mystery(int x) {
        if (x % 3 == 0) {
            return x;
        }
        return x + (mystery(x - 1));
    }

    @Override
    protected void drawProblemImage(Graphics2D g) {
        g.drawImage(RECURSIVE_INTEGER_MYSTERY_IMAGE, 20, 120, null);
    }

    @Override
    protected Object getParameter() {
        return parameter;
    }

    @Override
    protected void drawAnswers(Graphics2D g) {
        for (int i = 0; i < ANSWER_RECTANGLES.size(); i++) {
            Rectangle rectangle = ANSWER_RECTANGLES.get(i);
            g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            g.drawString(answers.get(i), rectangle.x + 20, rectangle.y + 20);
        }
    }

    @Override
    public QuestionResult onClick(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        for (int i = 0; i < ANSWER_RECTANGLES.size(); i++) {
            Rectangle rect = ANSWER_RECTANGLES.get(i);
            if (rect.contains(x, y)) {
                if (i == correctIndex) {
                    return QuestionResult.CORRECT;
                }
                return QuestionResult.INCORRECT;
            }
        }
        return QuestionResult.FAIL;
    }
}
