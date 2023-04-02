import java.util.*;
import java.text.DateFormatSymbols;

public class CalendarTest {
    public static void main(String[] args) {
        /*Создаем объект класса GregorianCalendar*/
        GregorianCalendar d = new GregorianCalendar();

        /*получаем текущий день недели*/
        int today = d.get(Calendar.DAY_OF_MONTH);

        /*получаем номер текущего месяца*/
        int month = d.get(Calendar.MONTH);

        d.set(Calendar.DAY_OF_MONTH, 1);

        /*получаем день недели*/
        int weekday = d.get(Calendar.DAY_OF_WEEK);

        /*получаем первый день первой недели*/
        int firstDayOfWeek = d.getFirstDayOfWeek();

        /*Здесь мы будем хранить отступ для первой недели*/
        int indent = 0;

        /*Пока текущий день не равен первому дню недели*/
        while (weekday != firstDayOfWeek) {
            /*увеличиваем отступ*/
            indent = indent + 1;

            /*уменьшаем номер дня месяца*/
            d.add(Calendar.DAY_OF_MONTH, -1);

            /*получаем номер дня недели*/
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }

        /*Массив названий дней недели*/
        String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();

        /*Выводим названия дней недели*/
        do {
            System.out.printf("%4s", weekdayNames[weekday]);
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        } while (weekday != firstDayOfWeek);
        System.out.println();

        /*Делаем отступ для первой недели месяца*/
        for (int i = 0; i < indent; i++) {
            System.out.print("    ");
        }

        d.set(Calendar.DAY_OF_MONTH, 1);

        /*Пока текущий месяц равен месяцу, установленному в переменной d*/
        do {
            /*получаем номер дня и выводим его на экран*/
            int day = d.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%3d", day);

            /*
                если номер совпал с текущим в календаре днем, 
                  то пометим его звездочкой, 
                  иначе выводим пробел
            */
            if (day == today) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }

            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);

            /*
                если мы вывели полностью всю неделю, 
                    то переведем курсор на новую строку в консоле
            */
            if (weekday == firstDayOfWeek) {
                System.out.println();
            }

        } while (d.get(Calendar.MONTH) == month);

        if (weekday != firstDayOfWeek) {
            System.out.println();
        }
    }
}