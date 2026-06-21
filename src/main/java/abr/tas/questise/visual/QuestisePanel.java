package abr.tas.questise.visual;

import abr.tas.questise.Utils;
import abr.tas.questise.visual.component.QButton;
import abr.tas.questise.visual.component.Questorite;
import abr.tas.questise.visual.component.question.QuestionBoard;
import abr.tas.questise.visual.component.question.QuestionResult;
import abr.tas.questise.visual.component.question.RecursiveIntegerBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;



public class QuestisePanel extends JPanel implements MouseListener, KeyListener, ActionListener {
    private static final QuestisePanel INSTANCE = new QuestisePanel();

    public static QuestisePanel getInstance() {
        return INSTANCE;
    }

    private final int LEFT_KEY_CODE = 37;
    private final int RIGHT_KEY_CODE = 39;
    private final int MOVEMENT_AMOUNT = 10;
    private final Font HELP_FONT = new Font("MS Gothic", Font.BOLD, 30);
    private final Font STATS_FONT = new Font("MS Gothic", Font.BOLD, 25);
    private final Font WARNING_FONT = STATS_FONT.deriveFont(20f);
    private final Font GAME_OVER_FONT = new Font("MS Gothic", Font.PLAIN, 40);
    private final Stroke LINE_STROKE = new BasicStroke(3);
    private final Image TITLE_IMAGE;
    private final Image PURE_ART_IMAGE;
    private final Image MOUSE_IMAGE;
    private final Image ARROW_KEYS_IMAGE;
    private final Image ESC_IMAGE;
    private final Image PLAYER_IMAGE;
    private final Image QUESTORITE_IMAGE;
    private final QButton PLAY_BUTTON;
    private final QButton HELP_BUTTON;
    private final QButton HELP_EXIT_BUTTON;
    private final QButton GAME_OVER_EXIT_BUTTON;
    private Screen screen = Screen.TITLE;
    private Graphics2D g;

    private int hearts;
    private long timeStarted;
    private long timeEnded;
    private int playerX;
    private Rectangle playerRectangle = new Rectangle(playerX, 640, 30, 30);
    private ArrayList<Questorite> questorites = new ArrayList<>();
    private boolean haveSpawnedInExtra = false;
    private Timer questionBoardTimer = new Timer(5000, this);
    private QuestionBoard questionBoard;
    private int pings = 0;

    private QuestisePanel() {
        setLayout(null);
        setBounds(0, 0, 480, 720);
        TITLE_IMAGE = Utils.createImage("logo.png").getScaledInstance(360, 60, 0);
        PURE_ART_IMAGE = Utils.createImage("pure_art.png").getScaledInstance(240, 360, 0);
        MOUSE_IMAGE = Utils.createImage("mouse.png");
        ARROW_KEYS_IMAGE = Utils.createImage("arrow_keys.png").getScaledInstance(84, 36, 0);
        ESC_IMAGE = Utils.createImage("esc.png").getScaledInstance(60, 48, 0);
        PLAYER_IMAGE = Utils.createImage("player.png").getScaledInstance(30, 30, 0);
        QUESTORITE_IMAGE = Utils.createImage("questorite.png");
        PLAY_BUTTON = new QButton(Utils.createImage("play_button.png").getScaledInstance(240, 72, 0), 240, 560);
        HELP_BUTTON = new QButton(Utils.createImage("help_button.png").getScaledInstance(180,  54, 0), 240, 640);
        HELP_EXIT_BUTTON = new QButton(Utils.createImage("exit_button.png").getScaledInstance(180, 54, 0), 240, 640);
        GAME_OVER_EXIT_BUTTON = new QButton(Utils.createImage("exit_button.png").getScaledInstance(180, 54, 0), 240, 440);
        addKeyListener(this);
        addMouseListener(this);
    }

    private void startGame() {
        screen = Screen.GAME;
        hearts = 3;
        timeStarted = System.currentTimeMillis();
        timeEnded = System.currentTimeMillis();
        playerX = 240;
        playerRectangle = new Rectangle(playerX, 640, 30, 30);
        questorites.clear();
        questorites.add(new Questorite(150, 400));
        questorites.add(new Questorite(240, 400));
        questorites.add(new Questorite(330, 400));
        haveSpawnedInExtra = false;
        questionBoardTimer.start();
        questionBoard = null;
        pings = 0;
    }

    private void endGame() {
        screen = Screen.GAME_OVER;
        timeEnded = System.currentTimeMillis();
    }

    private void onQuestionBoard() {
        if (questionBoard == null) {
            questionBoard = new RecursiveIntegerBoard();
        }
        pings ++;
        if (pings % 3 == 0) {
            spawnNewQuestorite();
        }
    }

    @Override
    protected void paintComponent(Graphics gl) {
        Graphics2D g = (Graphics2D) gl;
        super.paintComponent(g);
        this.g = g;
        Background.getInstance().draw(g, screen.isMenu());
        if (screen == Screen.TITLE) {
            drawTitleScreen();
        }
        else if (screen == Screen.HELP) {
            drawHelpScreen();
        }
        else if (screen == Screen.GAME) {
            drawGameScreen();
        }
        else if (screen == Screen.GAME_OVER) {
            drawGameOverScreen();
        }
    }

    private void drawTitleScreen() {
        drawCenteredImage(TITLE_IMAGE, 50);
        drawCenteredImage(PURE_ART_IMAGE, 300);
        g.setColor(Color.WHITE);
        g.setFont(WARNING_FONT);
        drawCenteredString("(please don't collect the questorites!)", 500);
        PLAY_BUTTON.draw(g);
        HELP_BUTTON.draw(g);
    }

    private void drawHelpScreen() {
        drawCenteredImage(TITLE_IMAGE, 50);
        g.setColor(Color.WHITE);
        g.setFont(HELP_FONT);
        drawCenteredString("Use your CSA skills", 120);
        drawCenteredString("to dodge the", 150);
        drawCenteredString("incoming questorites!", 180);
        drawCenteredImage(MOUSE_IMAGE, 75, 300);
        drawCenteredString("Use mouse to", 260, 285);
        drawCenteredString("answer questions", 260, 315);
        drawCenteredImage(ARROW_KEYS_IMAGE, 75, 400);
        drawCenteredString("Use arrow keys to", 275, 390);
        drawCenteredString("dodge questorites", 275, 415);
        drawCenteredImage(ESC_IMAGE, 75, 480);
        drawCenteredString("Use esc key to", 275, 465);
        drawCenteredString("exit to title screen", 275, 490);
        HELP_EXIT_BUTTON.draw(g);
    }

    private void drawGameScreen() {
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
            endGame();
        }
    }

    private void drawGameOverScreen() {
        g.setColor(Color.GRAY);
        g.fillRect(80, 175, 320, 330);
        g.setColor(Color.WHITE);
        g.setFont(GAME_OVER_FONT);
        drawCenteredString("Game over!", 240);
        drawCenteredString("You survived", 300);
        drawCenteredString(((double) timeEnded - timeStarted) / 1000 + " seconds.", 340);
        GAME_OVER_EXIT_BUTTON.draw(g);
    }

    private void spawnNewQuestorite() {
        questorites.add(new Questorite(Utils.random(120, 330), Utils.random(380, 420)));
    }

    public void draw() {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

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
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            screen = Screen.TITLE;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (screen == Screen.GAME) {
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
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (screen == Screen.TITLE) {
            if (PLAY_BUTTON.isMouseOver(e)) {
                startGame();
            }
            else if (HELP_BUTTON.isMouseOver(e)) {
                screen = Screen.HELP;
            }
        }
        else if (screen == Screen.HELP) {
            if (HELP_EXIT_BUTTON.isMouseOver(e)) {
                screen = Screen.TITLE;
            }
        }
        else if (screen == Screen.GAME_OVER) {
            if (GAME_OVER_EXIT_BUTTON.isMouseOver(e)) {
                screen = Screen.TITLE;
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        onQuestionBoard();
    }

    public void drawCenteredString(String string, int y) {
        drawCenteredString(string, getWidth() / 2, y);
    }

    public void drawCenteredString(String string, int x, int y) {
        int width = g.getFontMetrics().stringWidth(string);
        int height = g.getFontMetrics().getHeight();
        g.drawString(string, x - (width / 2), y + (height / 2));
    }

    public void drawCenteredImage(Image image, int y) {
        drawCenteredImage(image, getWidth() / 2, y);
    }

    public void drawCenteredImage(Image image, int x, int y) {
        g.drawImage(image, x - (image.getWidth(null) / 2), y - (image.getHeight(null) / 2), null);
    }
}
