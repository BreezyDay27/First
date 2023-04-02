import java.time.*;

public class Local {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date);
        DayOfWeek weekday = date.getDayOfWeek();
        System.out.println(weekday);
        int value = weekday.getValue();
        System.out.println(value);
    }
}
