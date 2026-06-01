package abr.tas.questise;

public class QuestiseErrorHandling {
    private static final QuestiseErrorHandling INSTANCE = new QuestiseErrorHandling();

    public static QuestiseErrorHandling getInstance() {
        return INSTANCE;
    }

    private QuestiseErrorHandling() {}

    public void error(Exception e) {
        throw new RuntimeException(e);
    }
}
