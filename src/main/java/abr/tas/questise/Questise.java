package abr.tas.questise;

import javax.swing.*;
import java.awt.*;

public class Questise {
    private static final Questise INSTANCE = new ;

    public static Questise getInstance() {
        return INSTANCE;
    }

    private JFrame frame;
    private QuestisePanel panel;

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
        Questise.getInstance().run();
    }
}
