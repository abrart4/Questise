package abr.tas.questise.gui.screen;

import abr.tas.questise.gui.QuestisePanel;

import javax.swing.*;
import java.awt.*;

public abstract class Screen {
    protected final int width;
    protected final int height;

    public Screen(QuestisePanel panel, int width, int height) {
        this.width = width;
        this.height = height;
    }
    public abstract void draw(Graphics g);
}
