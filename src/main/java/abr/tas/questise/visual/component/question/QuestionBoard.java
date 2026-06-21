package abr.tas.questise.visual.component.question;



import java.awt.*;
import java.awt.event.MouseEvent;



public abstract class QuestionBoard {
    public void draw(Graphics2D g) {
        g.setColor(Color.ORANGE);
        g.fillRect(0, 75, 480, 300);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Consider the following problem:", 20, 100);
        drawProblemImage(g);
        g.drawString("What is the result when calling", 20, 330);
        g.drawString("mystery(" + getParameter() + ")?", 20, 350);
        drawAnswers(g);
    }

    protected abstract void drawProblemImage(Graphics2D g);
    protected abstract Object getParameter();
    protected abstract void drawAnswers(Graphics2D g);
    public abstract QuestionResult onClick(MouseEvent e);
}
