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

    public void moveRight() {
        setX(getX() + stepSize);
    }

    public void moveLeft() {
        setX(getX() - stepSize);
    }
}
