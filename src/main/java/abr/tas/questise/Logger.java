package abr.tas.questise;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class Logger {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void log(String string) {
        LocalDateTime now = LocalDateTime.now();
        String formattedNow = now.format(formatter);
        String log = "<< Questise >> [" + formattedNow + "] " + string;
        String formattedLog = format(log);
        System.out.println(formattedLog);
    }

    private static String format(String string) {
        return string;
    }
}
