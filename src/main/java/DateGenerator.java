import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateGenerator {
    public String setRange(int plusDays) {
        LocalDateTime datetime1 = LocalDateTime.of(2021, 1, 10, 0, 0);
        LocalDateTime datetime2 = datetime1.plusDays(plusDays);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formatDateTime = datetime2.format(format);
        System.out.println("After Formatting: " + formatDateTime);
        return formatDateTime;
    }
}
