import java.awt.*;

/**
 * Class for the player sprite.
 *
 */
public class Player extends ColorBlock {
    private static final double stepSize = 1.5;
    Player(double x, double y) {
        super(x, y, 32, 32, Color.RED);
    }


    public void tick() {
        move(0, 1);
    }

    private void move(double x, double y) {
        setX(getX() + stepSize * x);
        setY(getY() + stepSize * y);
    }

    public void moveRight() {
        move(1, 0);
    }

    public void moveLeft() {
        move(-1, 0);
    }
}
