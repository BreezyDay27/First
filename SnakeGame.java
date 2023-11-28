import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class SnakeGame extends JPanel implements ActionListener {

    private Timer timer;
    private ArrayList<Point> snake;
    private Point food;
    private int direction;
    private boolean gameOver;


    private int fieldWidth = 19;
    private int fieldHeight = 19;




    public SnakeGame() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT && direction != 1) direction = 3;
                if (key == KeyEvent.VK_RIGHT && direction != 3) direction = 1;
                if (key == KeyEvent.VK_UP && direction != 2) direction = 0;
                if (key == KeyEvent.VK_DOWN && direction != 0) direction = 2;
            }
        });
        init();

    }



    private void init() {
        snake = new ArrayList<>();
        snake.add(new Point(10, 10));
        snake.add(new Point(10, 11));
        food = new Point((int) (Math.random() * 20), (int) (Math.random() * 20));
        direction = 1;
        gameOver = false;
        timer = new Timer(100, this);
        timer.start();
    }




    private void move() {

        Point head = snake.get(0);
        if (direction == 0) head = new Point(head.x, head.y - 1);
        if (direction == 1) head = new Point(head.x + 1, head.y);
        if (direction == 2) head = new Point(head.x, head.y + 1);
        if (direction == 3) head = new Point(head.x - 1, head.y);
        if (head.equals(food)) {
            snake.add(0, head);
            food = new Point((int) (Math.random() * 3), (int) (Math.random() * 3));
        } else {
            snake.remove(snake.size() - 1);
            snake.add(0, head);
        }
        for (int i = 1; i < snake.size(); i++) {
            if (head.equals(snake.get(i))) {
               // gameOver = true;
            }
        }

        if (head.x < 0 || head.x > 19 || head.y < 0 || head.y > 19) {


            }




       /* else if (head.x >= fieldWidth){
            head.x = 0;*/
        }




    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gameOver) {
            g.setColor(Color.red);
            g.drawString("Game Over!", 180, 200);
            //timer.stop();

        } else {
            g.setColor(Color.BLUE);
            for (Point p : snake) {
                g.fillRect(p.x * 20, p.y * 20, 20, 20);
            }
            g.setColor(Color.RED);
            g.fillRect(food.x * 20, food.y * 20, 20, 20);
        }

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new SnakeGame(), BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
