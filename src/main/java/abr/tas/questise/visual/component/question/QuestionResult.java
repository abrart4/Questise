package abr.tas.questise.visual.component.question;



public enum QuestionResult {
    FAIL(false, false),
    INCORRECT(true, false),
    CORRECT(true, true);

    private final boolean answered;
    private final boolean correct;

    QuestionResult(boolean answered, boolean correct) {
        this.answered = answered;
        this.correct = correct;
    }

    public boolean answered() {
        return answered;
    }

    public boolean correct() {
        return correct;
    }
}
