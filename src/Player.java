import java.awt.*;

/**
 * Class for the player sprite.
 *
 */
public class Player extends ColorBlock {
    public static final double stepSize = 4;
    Player(double x, double y) {
        super(x, y, 32, 32, Color.RED);
    }

    public void fall() {
        move(0, 1.5);
    }

    public void tick() {
        // TODO: Sprite changes?
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
