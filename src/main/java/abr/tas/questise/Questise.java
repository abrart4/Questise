package abr.tas.questise;

import abr.tas.questise.visual.QuestisePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Questise implements ActionListener {
    private static boolean started = false;

    private Timer loopTimer = new Timer(17, this);

    public void start() {
        if (started) {
            Logger.log("Already started! Returning...");
            return;
        }
        started = true;
        Logger.log("Starting Questise");
        JFrame frame = new JFrame("Questise");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 720);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = QuestisePanel.getInstance();
        frame.add(panel);
        frame.setVisible(true);

        //frame.setAlwaysOnTop(true);
        panel.requestFocusInWindow();
        loopTimer.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        QuestisePanel.getInstance().draw();
    }
}
