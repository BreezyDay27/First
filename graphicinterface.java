import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.sql.*;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;


public class graphicinterface  extends JFrame {
    // private Dialog dialog2;    //Конструктор главного окна
    public graphicinterface() throws ClassNotFoundException, SQLException, IOException {
        //Название формы
        super("Таблица_11");
        //размер окна
        setSize(700, 700);
        //Вспомогательная панель
        JPanel panel = new JPanel();

        //Менеджер красположения
         GridLayout layout = new GridLayout(3, 3, 5, 5);
         panel.setLayout(layout);
        //кнопки
        JButton r = new JButton("table");
        JButton n = new JButton("table");
        JButton b = new JButton("another window");
        JLabel picLabel = new JLabel(new ImageIcon("C:\\Users\\KDFX Team\\Downloads\\Safeimagekit-resized-img.png"));
        JButton c = new JButton("enter data");
        JButton d = new JButton("delete");
        JTextField t1 = new JFormattedTextField();
        JTextField t2 = new JFormattedTextField();
        JTextField t3 = new JFormattedTextField();

        //добавляем кнопки и картинку и текстовое поле на форму
        panel.add(b);
        panel.add(picLabel);
        panel.add(c);
        panel.add(d);
        panel.add(r);
        panel.add(n);
        panel.add(t1);
        panel.add(t2);
        panel.add(t3);



        //настройки подключения к бд
        Class.forName("com.mysql.cj.jdbc.Driver");
        /* statement.executeUpdate("CREATE TABLE ppl ("+
                "id int auto_increment primary key,"+
                "name varchar(30)not null,"+
                "surname varchar(10)not null,"+
                "age varchar(10)not null)");*/

        //statement.executeUpdate("INSERT INTO test23 (name,name2,name3) value ( Sname,'privet','privet')");
        //Обрабатываем событие при нажатии на кнопку
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // Делаем видимым второе окно
                //Создаем диалог
                //panel.setVisible(false);
                Dialog dialog7 = new Dialog();
                dialog7.setVisible(true);

            }
        });
        //открыть таблицу с базой
        r.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                try {
                    table7 table = new table7();
                    table.setVisible(true);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }


            }
        });
        //кнопка добавления в базу
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                JOptionPane.showMessageDialog(panel, "Данные добавлены!");

            }
        });
     //кнопка удаления из базы
        d.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                JOptionPane.showMessageDialog(panel, "Данные удалены!");

            }
        });


 /*       r.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setSize(500,500);
                frame.setVisible(true);
            }
        });*/

        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                try {
                    String Kname = t1.getText();
                    String Surname = t2.getText();
                    String Age = t3.getText();
                    statement.executeUpdate("INSERT INTO ppl (name,surname,age) value ('" + Kname + "','" + Surname + "','" + Age + "')");
                } catch (Exception Err) {
                    System.out.println(Err.getMessage());
                }

            }


        });
        d.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    statement.executeUpdate("DELETE FROM sakila.ppl;");
                } catch (Exception Err) {
                    System.out.println(Err.getMessage());
                }
                System.out.println("Deleted");
            }
        });

/*        r.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0)  {
                try{
                    Connection conn;
                    conn = DriverManager.getConnection(URL, NAME_USER, PASSWORD);
                    Statement stmt = (Statement) conn.createStatement();
                    String query = "Select name1, name2, name3 from test27";
                    ResultSet rs = stmt.executeQuery(query);

                    rs.beforeFirst();

                    while (rs.next()) {
                        String title = rs.getString("Title");
                        String season = rs.getString("Season");
                        String episode = rs.getString("Episode");

                        String[] columns = {"Title", "S", "E"};
                        String[][] data = {{title, season, episode}};


                        vk = new JTable(data, columns);
                    };

                    vk.setPreferredScrollableViewportSize(new Dimension(450, 63));
                    vk.setFillsViewportHeight(true);

                    JScrollPane jps = new JScrollPane(jt);
                    add(jps);
                }

                catch (Exception Err){
                    System.out.println(Err.getMessage());
                }
            }
        });*/


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







