package ch02;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.lang.System.out;
import static java.time.LocalDate.now;

public class E11 {
    public static void run() {
        LocalDate date = now().withDayOfMonth(1);
        int month = date.getMonthValue();

        out.println(" Mon Tue Wed Thu Fri Sat Sun");
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue(); // 1 = Monday, ... 7 = Sunday
        for (int i = 1; i < value; i++)
            out.print("    ");
        while (date.getMonthValue() == month) {
            out.printf("%4d", date.getDayOfMonth());
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1)
                out.println();
        }
        if (date.getDayOfWeek().getValue() != 1)
            out.println();
    }
}
