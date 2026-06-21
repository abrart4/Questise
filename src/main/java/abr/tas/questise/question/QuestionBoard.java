package abr.tas.questise.question;



import abr.tas.questise.Utils;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;



public abstract class QuestionBoard {
    protected static final ArrayList<Rectangle> ANSWER_RECTANGLES = new ArrayList<>();
    protected final ArrayList<String> answers = new ArrayList<>();

    static {
        for (int i = 120; i <= 300; i += 60) {
            ANSWER_RECTANGLES.add(new Rectangle(350, i, 130, 60));
        }
    }

    protected int correctIndex;

    protected QuestionBoard() {
        correctIndex = Utils.random(0, 3);
        for (int i = 0; i < 4; i ++) {
            if (i == correctIndex) {
                answers.add(String.valueOf(getValue()));
            }
            else {
                int random = 0;
                while (random == 0) {
                    random = Utils.random(-10, 10);
                }
                answers.add(String.valueOf(random));
            }
        }
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.ORANGE);
        g.fillRect(0, 75, 480, 300);
        drawProblem(g);
        drawAnswers(g);
    }

    protected abstract Object getValue();

    protected abstract void drawProblem(Graphics2D g);

    private void drawAnswers(Graphics2D g) {
        for (int i = 0; i < ANSWER_RECTANGLES.size(); i++) {
            Rectangle rectangle = ANSWER_RECTANGLES.get(i);
            g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            g.drawString(answers.get(i), rectangle.x + 20, rectangle.y + 20);
        }
    }

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

    public static QuestionBoard getRandomQuestionBoard() {
        return new RecursiveIntegerBoard();
    }
}
