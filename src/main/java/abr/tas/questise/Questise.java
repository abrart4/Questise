package abr.tas.questise;

import abr.tas.questise.gui.QuestisePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Questise implements ActionListener {
    private static final Questise INSTANCE = new Questise();

    public static Questise getInstance() {
        return INSTANCE;
    }

    private Questise() {}

    private final Timer timer = new Timer(0, this);
    private JFrame frame;
    private QuestisePanel panel;

    private void run() {
        frame = new JFrame("Questise");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) (screenSize.getWidth() / 3), (int) (screenSize.getHeight() / 1.2));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        panel = QuestisePanel.getInstance();
        frame.add(panel);
        frame.setVisible(true);
        timer.start();
        for (Font font: GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts()) {
            System.out.println(font);
        }
    }

    private void loop() {
        panel.loop();
    }

    public static void main(String[] args) {
        Questise.getInstance().run();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        loop();
    }
}
