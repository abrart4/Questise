package abr.tas.questise.gui.screen;

import abr.tas.questise.QuestiseNative;
import abr.tas.questise.gui.QuestisePanel;

import javax.swing.*;
import java.awt.*;

public abstract class Screen {
    protected final QuestisePanel panel;
    protected final int width;
    protected final int height;

    public Screen(Screen previous) {
        this(previous.panel, previous.width, previous.height);
    }

    public Screen(QuestisePanel panel, int width, int height) {
        this.panel = panel;
        this.width = width;
        this.height = height;
        panel.setLayout(null);
        panel.setBounds(0, 0, (int) QuestiseNative.SCREEN_WIDTH, (int) QuestiseNative.SCREEN_HEIGHT);
    }

    public abstract void draw(Graphics g);

    public void close() {
        panel.removeAll();
    }

    protected void centerAround(JComponent component, int x, int y) {
        int width = component.getWidth();
        int height = component.getHeight();
        component.setBounds(x - (width / 2), y - (height / 2), x, y);
    }
}
