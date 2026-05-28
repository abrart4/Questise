package abr.tas.questise;

import javax.swing.*;
import java.awt.*;

public class Questise {
    private static Questise INSTANCE;

    public static Questise getInstance() {
        return INSTANCE;
    }

    private JFrame frame;
    private QuestisePanel panel;

    public Questise() {
        INSTANCE = this;
    }

    private void run() {
        frame = new JFrame("Questise");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) (screenSize.getHeight() / 2), (int) (screenSize.getWidth() / 2));
        frame.setLocationRelativeTo(null);


        panel = new QuestisePanel();
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Questise().run();
    }
}
