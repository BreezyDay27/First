import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.Calendar;

public class Test2 extends JFrame {
    public Test2() {
        Container container = getContentPane();
        //Делаем невидимым окно
        setVisible(true);
        //Устанавливаем размеры
        setSize(500, 300);
        //Отображаем по центру
        setLocationRelativeTo(null);
        JLabel picLabel = new JLabel(new ImageIcon("C:\\Users\\KDFX Team\\Downloads\\Safeimagekit-resized-img.png"));
        picLabel.setVisible(true);
        container.add(picLabel,BorderLayout.CENTER);
    }
    public static void main(String[] args){

           new Test2();
    }
}

