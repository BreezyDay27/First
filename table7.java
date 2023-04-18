import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;


public class table7  {

    public table7() throws Exception {
        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();
        JFrame jFrame = new JFrame();
        jFrame.setSize(500, 300);
        jFrame.setLocation(600,250);
        //Подключение к базе данных
        String url = "jdbc:mysql://localhost:3306/sakila";
        String userid = "root";
        String password = "45953";
        String sql = "SELECT * FROM ppl51";

        JPanel mainPane = new JPanel();
        JPanel buttonPane = new JPanel();
        JButton button1 = new JButton("Test 1");
        buttonPane.add(button1);


        //Положение на экране

        //Создание переменной для подключения
        Connection connection = DriverManager.getConnection(url, userid, password);
        //Создает объект себе для отправки запросов SQL к базе данных
        Statement stmt = connection.createStatement();
        //Получаем результирующую таблицу
        ResultSet rs = stmt.executeQuery(sql);
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        //Количество колонок
        for (int i = 1; i <= columns; i++) {
            columnNames.add(md.getColumnName(i));
        }
        // Перебор строк с данными
        while (rs.next()) {
            ArrayList row = new ArrayList(columns);
            for (int i = 1; i <= columns; i++) {
                row.add(rs.getObject(i));
            }
            data.add(row);
        }
        //Количество строк
        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();
        for (int i = 0; i < data.size(); i++) {
            ArrayList subArray = (ArrayList) data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++) {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }
        for (int i = 0; i < columnNames.size(); i++)
            columnNamesVector.add(columnNames.get(i));
        JTable table = new JTable(dataVector, columnNamesVector) {
            public Class getColumnClass(int column) {
                for (int row = 0; row < getRowCount(); row++) {
                    Object o = getValueAt(row, column);
                    if (o != null) {
                        return o.getClass();
                    }
                }
                return Object.class;
            }

        };
        //кнопка удаления строчки выделенной из базы
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int row = table.getSelectedRow();
                String cell = table.getModel().getValueAt(row, 0).toString();
                try {

                    statement.executeUpdate("DELETE FROM sakila.ppl51 WHERE id = '" + cell + "'");
                } catch (Exception Err) {
                    System.out.println(Err.getMessage());
                }

            }
        });
        JScrollPane scrollPane = new JScrollPane(table);
       // getContentPane().add(scrollPane);
        mainPane.add(table);
        mainPane.add(buttonPane);
        jFrame.add(mainPane);
        jFrame.setVisible(true);
        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
        //buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.X_AXIS));


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


    public static void main (String[]args) throws Exception {
        Main frame = new Main();
     //   frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

}



