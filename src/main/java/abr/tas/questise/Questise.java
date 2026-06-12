package abr.tas.questise;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Questise implements ActionListener {
    private Timer loopTimer = new Timer(0, this);

    private void start() {
        JFrame frame = new JFrame("Questise");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 720);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = QuestisePanel.getInstance();
        panel.requestFocusInWindow();
        frame.add(panel);
        frame.setVisible(true);
        loopTimer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        QuestisePanel.getInstance().draw();
    }

    public static void main(String[] args) {
        new Questise().start();
    }

}
