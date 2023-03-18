import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.Calendar;

public class Test extends JFrame {
    public Test() {
        Container container = getContentPane();
        //Делаем невидимым окно
        setVisible(true);
        //Устанавливаем размеры
        setSize(500, 300);

        //Отображаем по центру
        setLocationRelativeTo(null);
    }
    public static void main(String[] args){
        int hours = Calendar.getInstance().getTime().getHours();
        System.out.println(hours);
        String[] hello = {"Доброе утро!", "Добрый день!", "Добрый вечер!", "Вообще-то уже ночь..."};
        if(hours >= 6 && hours < 12){
            System.out.println(hello[0]);
        }
        if(hours >= 12 && hours < 18){

            System.out.println(hello[1]);
        }
        if(hours >= 18 && hours < 23){
            Test dialog9 = new Test();
            JLabel picLabel = new JLabel(new ImageIcon("C:\\Users\\KDFX Team\\Desktop\\Screenshot_1.png"));
            dialog9.add(picLabel);
            System.out.println(hello[2]);
        }
        if(hours >=23 && hours < 6){
            System.out.println(hello[3]);
        }

    }
}

