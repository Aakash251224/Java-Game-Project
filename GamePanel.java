import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private Snake snake;
    private Food food;
    private Timer timer;
    private boolean gameOver = false;

    public GamePanel() {
        snake = new Snake();
        food = new Food();

        timer = new Timer(120, this);
        timer.start();

        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!gameOver) {
            snake.draw(g);
            food.draw(g);
        } else {
            g.setColor(Color.RED);
            g.drawString("GAME OVER", 150, 150);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            snake.update();
            food.update();

            if (snake.getHead().equals(food.getPosition())) {
                snake.grow();
                food.respawn();
            }

            if (snake.checkSelfCollision()) {
                gameOver = true;
            }
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> snake.setDirection(Direction.UP);
            case KeyEvent.VK_DOWN -> snake.setDirection(Direction.DOWN);
            case KeyEvent.VK_LEFT -> snake.setDirection(Direction.LEFT);
            case KeyEvent.VK_RIGHT -> snake.setDirection(Direction.RIGHT);
        }
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}
