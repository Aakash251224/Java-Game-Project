import javax.swing.*;

public class GameFrame extends JFrame {

    public GameFrame() {
        add(new GamePanel());

        setTitle("Snake Game");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
