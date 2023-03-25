import java.awt.*;

/**
 * Class for the player sprite.
 *
 */
public class Player extends ColorBlock {
    public static final double stepSize = 4;

    // Jumping logic. Will go up by stepSize until curJumps = maxJumps.
    // jumping bool decides if up or down.
    private final int maxJumps = 20;

    // -1: Can start jumping, 0: has finished going up but can't start jumping, >0: going up
    private int curJumps = 0;

    Player(double x, double y) {
        super(x, y, 32, 32, Color.RED);
    }

    public void fall() {
        move(0, 1.5);
    }

    public void tick() {

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

    public void moveUp() {
        move(0, -1);
    }

    public void setCurJumps(int curJumps) {
        this.curJumps = curJumps;
    }

    public int getCurJumps() {
        return curJumps;
    }

    public int getMaxJumps() {
        return maxJumps;
    }
}
