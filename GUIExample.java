import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIExample implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JTextField textField;
    private JButton button;

    public GUIExample() {
        frame = new JFrame("GUI Example");
        panel = new JPanel();
        label = new JLabel("Enter your name:");
        textField = new JTextField(20);
        button = new JButton("Submit");

        button.addActionListener(this);

        panel.add(label);
        panel.add(textField);
        panel.add(button);

        frame.add(panel);
        frame.setSize(300, 150);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new GUIExample();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = textField.getText();
        JOptionPane.showMessageDialog(frame, "Hello, " + name + "!");
    }
}
