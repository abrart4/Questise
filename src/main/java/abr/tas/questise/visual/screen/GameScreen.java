package abr.tas.questise.visual.screen;



import abr.tas.questise.Logger;
import abr.tas.questise.Utils;
import abr.tas.questise.visual.QuestisePanel;
import abr.tas.questise.visual.component.Questorite;
import abr.tas.questise.question.QuestionBoard;
import abr.tas.questise.question.QuestionResult;
import abr.tas.questise.question.RecursiveIntegerBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;



public class GameScreen extends Screen {
    private static final Stroke LINE_STROKE = new BasicStroke(3);
    private static final Font STATS_FONT = new Font("MS Gothic", Font.BOLD, 25);
    private static final Image PLAYER_IMAGE = Utils.createImage("player.png").getScaledInstance(30, 30, 0);
    private static final Image QUESTORITE_IMAGE = Utils.createImage("questorite.png");

    private static final int LEFT_KEY_CODE = KeyEvent.VK_LEFT;
    private static final int RIGHT_KEY_CODE = KeyEvent.VK_RIGHT;
    private static final int MOVEMENT_AMOUNT = 10;

    private int hearts = 3;
    private long timeStarted = System.currentTimeMillis();
    private long timeEnded = System.currentTimeMillis();
    private int playerX = 240;
    private Rectangle playerRectangle = new Rectangle(playerX, 640, 30, 30);
    private ArrayList<Questorite> questorites = new ArrayList<>();
    private boolean haveSpawnedInExtra = false;
    private Timer questionBoardTimer = new Timer(5000, this::handleQuestionBoardTimer);
    private QuestionBoard questionBoard;
    private int pings = 0;

    private GameScreen(Screen previous) {
        super(previous);
        questorites.add(new Questorite(150, 400));
        questorites.add(new Questorite(240, 400));
        questorites.add(new Questorite(330, 400));
        questionBoardTimer.start();
        Logger.log("Starting game");
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        g.setStroke(LINE_STROKE);
        g.setColor(Color.BLACK);
        g.drawLine(120, 360, 120, 720);
        g.drawLine(360, 360, 360, 720);
        g.drawLine(120, 600, 360, 600);
        g.drawLine(0, 360, 480, 360);
        g.setColor(Color.WHITE);
        g.setFont(STATS_FONT);
        drawCenteredString(hearts + " hearts", 20);
        drawCenteredString(pings + " answered", 50);
        drawCenteredImage(PLAYER_IMAGE, playerX, 640);
        for (int i = 0; i < questorites.size(); i ++) {
            Questorite questorite = questorites.get(i);
            questorite.incrementY();
            int questoriteX = questorite.getX();
            int questoriteY = questorite.getY();
            drawCenteredImage(QUESTORITE_IMAGE, questoriteX, questoriteY);
            Rectangle questoriteRectangle = new Rectangle(questoriteX, questoriteY, 30, 30);
            if (questoriteRectangle.intersects(playerRectangle)) {
                hearts --;
                questorites.remove(i);
                i --;
                spawnNewQuestorite();
            }
            if (questoriteY > 720) {
                if (!haveSpawnedInExtra) {
                    haveSpawnedInExtra = true;
                    spawnNewQuestorite();
                    spawnNewQuestorite();
                }
                questorite.setX(Utils.random(120, 330));
                questorite.setY(Utils.random(380, 420));
            }
        }
        if (questionBoard != null) questionBoard.draw(g);
        if (hearts <= 0) {
            GameOverScreen.open(this, timeStarted, timeEnded = System.currentTimeMillis());
        }
    }

    private void handleQuestionBoardTimer(ActionEvent e) {
        if (questionBoard == null) {
            questionBoard = new RecursiveIntegerBoard();
        }
        pings ++;
        if (pings % 3 == 0) {
            spawnNewQuestorite();
        }
    }

    private void spawnNewQuestorite() {
        questorites.add(new Questorite(Utils.random(120, 330), Utils.random(380, 420)));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        int newX = playerX;
        if (keyCode == LEFT_KEY_CODE) {
            newX -= MOVEMENT_AMOUNT;
        }
        if (keyCode == RIGHT_KEY_CODE) {
            newX += MOVEMENT_AMOUNT;
        }
        if (newX >= 120 && newX <= 360) {
            playerX = newX;
            playerRectangle = new Rectangle(playerX, 640, 30, 30);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (questionBoard != null) {
            QuestionResult result = questionBoard.onClick(e);
            if (result.answered()) {
                questionBoard = null;
            }
            if (result.correct()) {
                hearts ++;
            }
        }
    }

    @Override
    public boolean isMenu() {
        return false;
    }

    public static void open(Screen previous) {
        QuestisePanel.getInstance().openScreen(new GameScreen(previous));
    }
}
