import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * Класс второго окна
 * */
public class Dialog extends JFrame{
    //Конструктор второго окна
    public Dialog() {
        // Панель содержимого
        Container container = getContentPane();
        //Делаем невидимым окно
        setVisible(false);
        //Устанавливаем размеры
        setSize(500, 300);
        //Отображаем по центру
        setLocationRelativeTo(null);
        //строковые поля
        JTextField t1,t2;
        //первое поле
        JButton button1;
        button1 = new JButton("button!");
        t1=new JTextField("Welcome to Javatpoint.");
        JLabel picLabel = new JLabel(new ImageIcon("C:\\Users\\KDFX Team\\Downloads\\Safeimagekit-resized-img.png"));
        container.add(picLabel,BorderLayout.CENTER);
        container.add(t1, BorderLayout.WEST);
        container.add(button1, BorderLayout.EAST);

    }
}