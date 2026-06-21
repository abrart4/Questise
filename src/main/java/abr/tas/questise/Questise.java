package abr.tas.questise;

import abr.tas.questise.visual.QuestisePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Questise {
    private static final int WIDTH = 480;
    private static final int HEIGHT = 720;

    private static boolean started = false;

    private Timer loopTimer = new Timer(17, (_) -> QuestisePanel.getInstance().draw());

    public void start() {
        if (started) {
            Logger.log("Already started! Returning...");
            return;
        }
        started = true;
        Logger.log("Starting Questise");
        Logger.log("- Operating system: " +  System.getProperty("os.name"));
        Logger.log("- Dimensions: " + WIDTH + ", " + HEIGHT);
        JFrame frame = new JFrame("Questise");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = QuestisePanel.getInstance();
        frame.add(panel);
        frame.setVisible(true);
        panel.requestFocusInWindow();
        loopTimer.start();
    }
}
