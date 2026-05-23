import java.awt.*;
import java.util.ArrayList;

public class Snake implements GameObject {

    private ArrayList<Point> body;
    private Direction direction;
    private boolean grow;

    public Snake() {
        body = new ArrayList<>();
        body.add(new Point(5, 5));
        direction = Direction.RIGHT;
        grow = false;
    }

    public void setDirection(Direction d) {
        direction = d;
    }

    public Point getHead() {
        return body.get(0);
    }

    public void grow() {
        grow = true;
    }

    @Override
    public void update() {
        Point head = getHead();
        Point newHead = new Point(head);

        switch (direction) {
            case UP -> newHead.y--;
            case DOWN -> newHead.y++;
            case LEFT -> newHead.x--;
            case RIGHT -> newHead.x++;
        }

        body.add(0, newHead);

        if (!grow) {
            body.remove(body.size() - 1);
        } else {
            grow = false;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        for (Point p : body) {
            g.fillRect(p.x * 20, p.y * 20, 20, 20);
        }
    }

    public boolean checkSelfCollision() {
        Point head = getHead();
        for (int i = 1; i < body.size(); i++) {
            if (head.equals(body.get(i))) return true;
        }
        return false;
    }
}
