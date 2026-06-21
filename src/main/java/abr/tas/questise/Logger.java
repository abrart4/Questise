package abr.tas.questise;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;



public class Logger {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final Map<String, String> minecraftToAnsi = new HashMap<>();

    static {
        String[] minecraftCodes = "0123456789abcdeflonr".split("");
        // got these from ai, lets hope these are right!
        int[] ansiCodes = {30, 34, 32, 36, 31, 35, 33, 37, 90, 94, 92, 96, 91, 95, 93, 97, 1, 3, 4, 0};
        for (int i = 0; i < minecraftCodes.length; i++) {
            String minecraftCode = minecraftCodes[i];
            int ansiCode = ansiCodes[i];
            minecraftToAnsi.put("§" + minecraftCode, "\u001B[" + ansiCode + "m");
        }
    }

    public static void log(String string) {
        LocalDateTime now = LocalDateTime.now();
        String formattedNow = now.format(formatter);
        String log = "§5<< Questise >> §6[" + formattedNow + "]§r " + string + "";
        String formattedLog = format(log);
        System.out.println(formattedLog);
    }

    private static String format(String string) {
        String formattedString = string;
        for (Map.Entry<String, String> entry : minecraftToAnsi.entrySet()) {
            formattedString = formattedString.replaceAll(entry.getKey(), entry.getValue());
        }
        return formattedString;
    }
}
