package abr.tas.questise.visual;



public enum Screen {
    TITLE,
    HELP,
    GAME(false),
    GAME_OVER;

    private final boolean isMenu;

    Screen() {
        isMenu = true;
    }

    Screen(boolean inMenu) {
        this.isMenu = inMenu;
    }

    public boolean isMenu() {
        return isMenu;
    }
}
