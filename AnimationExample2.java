import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimationExample2 extends JPanel implements ActionListener {
    private int x = 0;
    private int y = 0;
    private int dx = 2;
    private int dy = 2;
    private int width = 100;
    private int height = 100;

    public AnimationExample2() {
        Timer timer = new Timer(10, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }

    public void actionPerformed(ActionEvent e) {
        if (x < 0 || x > getWidth() - width) {
            dx = -dx;
        }
        if (y < 0 || y > getHeight() - height) {
            dy = -dy;
        }
        x += dx;
        y += dy;
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animation Example 2");
        frame.add(new AnimationExample2());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}