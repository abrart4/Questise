package abr.tas.questise.visual.component;



public class Questorite {
    private int increment = 0;

    private int x;
    private int y;

    public Questorite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void incrementY() {
        y += 2;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
