package abr.tas.questise.gui.screen;

import abr.tas.questise.gui.Background;
import abr.tas.questise.gui.Fonts;
import abr.tas.questise.gui.QuestisePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreen extends Screen implements ActionListener {
    public TitleScreen(QuestisePanel panel, int width, int height) {
        super(panel, width, height);
        JLabel titleText = new JLabel("Questise");
        titleText.setFont(Fonts.TITLE_FONT);
        Point kf = MouseInfo.getPointerInfo().getLocation();
        titleText.setBounds((int) kf.getX(), (int) kf.getY(), 40, 50);
        panel.add(titleText);
        JButton playButton = new JButton("Play");
        playButton.addActionListener(this);
        panel.add(playButton);
    }

    @Override
    public void draw(Graphics g) {
        Background.getInstance().draw(g, true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.openScreen(new GameScreen(this));
    }
}
