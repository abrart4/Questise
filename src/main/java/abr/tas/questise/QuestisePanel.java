package abr.tas.questise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

public class QuestisePanel extends JPanel implements ActionListener {
    private static final QuestisePanel INSTANCE = new QuestisePanel();

    public static QuestisePanel getInstance() {
        return INSTANCE;
    }

    private QuestisePanel() {}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
