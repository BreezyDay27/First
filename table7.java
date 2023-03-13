import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;


public class table7 extends JFrame {

    public table7() throws Exception {
        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();
        //Подключение к базе данных
        String url = "jdbc:mysql://localhost:3306/sakila";
        String userid = "root";
        String password = "45953";
        String sql = "SELECT * FROM ppl51";
       //setLocationRelativeTo(null);
        //Положение на экране
        setLocation(600,250);
        //Размер
        setSize(500, 500);
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
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);
        // JPanel buttonPanel = new JPanel();
        //   getContentPane().add(buttonPanel, BorderLayout.NORTH);

    }


    public static void main (String[]args) throws Exception {
        Main frame = new Main();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

}



