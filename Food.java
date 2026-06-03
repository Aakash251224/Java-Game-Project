import java.awt.*;
import java.util.Random;

public class Food implements GameObject {

    private Point position;
    private Random random = new Random();

    public Food() {
        respawn();
    }

    public Point getPosition() {
        return position;
    }

    public void respawn() {
        position = new Point(random.nextInt(20), random.nextInt(20));
    }

    @Override
    public void update() {}

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(position.x * 20, position.y * 20, 20, 20);
    }
}
