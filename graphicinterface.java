import com.sun.tools.javac.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class graphicinterface  extends JFrame {

    // private Dialog dialog2;    //Конструктор главного окна
    public graphicinterface() throws ClassNotFoundException, SQLException, IOException {
        //Название формы
        super("Таблица12");
        //размер окна
        setSize(700, 700);
        //Вспомогательная панель
        JPanel panel = new JPanel();
        panel.setLayout(null);

        //кнопки
        JLabel picLabel2 = new JLabel(new ImageIcon("C:\\Users\\KDFX Team\\Desktop\\vecher2.jpg"));
        picLabel2.setBounds(200, 100, 300, 200);
        panel.add(picLabel2);
        JButton r = new JButton("table");
        r.setBounds(450, 450, 100, 50);
        panel.add(r);
        JButton n = new JButton("table1");
        JButton b = new JButton("another window");
        b.setBounds(270, 550, 100, 50);
        panel.add(b);
        JLabel picLabel = new JLabel(new ImageIcon("C:\\Users\\KDFX Team\\Desktop\\vecher.jpg"));
        picLabel.setBounds(200, 100, 300, 200);
        panel.add(picLabel);
        JButton c = new JButton("enter data");
        c.setBounds(270, 450, 100, 50);
        panel.add(c);
        JButton d = new JButton("DELETE!");
        d.setBounds(100, 450, 100, 50);
        panel.add(d);
        JTextField t1 = new JFormattedTextField();
        t1.setBounds(80, 350, 150, 30);
        panel.add(t1);
        JTextField t2 = new JFormattedTextField();
        t2.setBounds(250, 350, 150, 30);
        panel.add(t2);
        JTextField t3 = new JFormattedTextField();


        t3.setBounds(420, 350, 150, 30);
        panel.add(t3);
        JLabel newLabel = new JLabel("name");
        newLabel.setBounds(80, 380, 150, 30);
        panel.add(newLabel);
        JLabel newLabel2 = new JLabel("surname");
        newLabel2.setBounds(250, 380, 150, 30);
        panel.add(newLabel2);
        JLabel newLabel3 = new JLabel("age");
        newLabel3.setBounds(420, 380, 150, 30);
        panel.add(newLabel3);




        //настройки подключения к бд
        Class.forName("com.mysql.cj.jdbc.Driver");
        /* statement.executeUpdate("CREATE TABLE ppl ("+
                "id int auto_increment primary key,"+
                "name varchar(30)not null,"+
                "surname varchar(10)not null,"+
                "age varchar(10)not null)"+
                 "UNIQUE ("name") ON CONFLICT REPLACE)");*/
        //Обрабатываем событие при нажатии на кнопку
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // Делаем видимым второе окно
                //Создаем диалог
                //panel.setVisible(false);
                Dialog dialog7 = new Dialog();
                dialog7.setVisible(true);
               /* Test2 test7 = new Test2();
                test7.setVisible(true);*/
            }
        });

        //открыть таблицу с базой
        r.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                try {
                    table7 table = new table7();
                    //table.setVisible(true);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }


            }

        });


        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                try {
                    String Kname = t1.getText();
                    String Surname = t2.getText();
                    String Age = t3.getText();

                    //очищает поля после ввода данных
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");

                    //проверка на пустые поля
                    if (Kname.isEmpty()) {
                        JOptionPane.showMessageDialog(panel, "Пустая запись!");
                    }
                    //запрещает буквы в поле возраст
                    if (!(Age.matches("[0-9]+"))) {
                        JOptionPane.showMessageDialog(null, "Только цифры в возрасте");

                    }
                    else {
                        statement.executeUpdate("INSERT INTO ppl (name,surname,age) value ('" + Kname + "','" + Surname + "','" + Age + "')");
                        JOptionPane.showMessageDialog(panel, "Данные внесены!");
                    }
                } catch (Exception Err) {
                    System.out.println(Err.getMessage());
                    JOptionPane.showMessageDialog(panel, "Уже есть такая запись!");
                }

            }

        });



        d.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    statement.executeUpdate("TRUNCATE TABLE sakila.ppl;");
                } catch (Exception Err) {
                    System.out.println(Err.getMessage());
                }
                JOptionPane.showMessageDialog(panel, "Данные удалены!");
            }
        });


       // panel.add(b);
        //картинка меняется от времени суток
        int hours = Calendar.getInstance().getTime().getHours();
        System.out.println(hours);
        String[] hello = {"Доброе утро!", "Добрый день!", "Добрый вечер!", "Вообще-то уже ночь..."};
        if(hours >= 6 && hours < 12){
            System.out.println(hello[0]);
        }
        if(hours >= 12 && hours < 18){
              panel.add(picLabel);
            System.out.println(hello[1]);
        }
        if(hours >= 18 && hours < 23){
            panel.add(picLabel2);
            System.out.println(hello[2]);
        }
        if(hours >=23 && hours < 6){
            System.out.println(hello[3]);
        }
        //добавляем кнопки и картинку и текстовое поле на форму



        //добавляем элементы
        getContentPane().add(panel);
        //Видимость формы
        setVisible(true);
        //Центрирование формы
        setLocationRelativeTo(null);

    }

    //данные для коннекта к базе
    public static final String NAME_USER = "root";
    public static final String PASSWORD = "45953";
    public static final String URL = "jdbc:mysql://localhost:3306/sakila";
    public static Statement statement;
    public static Connection connection;


    static {
        try {
            connection = DriverManager.getConnection(URL, NAME_USER, PASSWORD);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }


        public static void main(String[] args) throws  ClassNotFoundException, SQLException, IOException {
            //граф форма
            new graphicinterface();

        }
    }







