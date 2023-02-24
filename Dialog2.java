import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * Класс второго окна
 * */
public class Dialog2 extends JDialog {
    //Конструктор второго окна
    public Dialog2() {
        // Панель содержимого
        Container container = getContentPane();
        //Делаем невидимым окно
        setVisible(false);
        //Устанавливаем размеры
        setSize(500, 300);
    }
}