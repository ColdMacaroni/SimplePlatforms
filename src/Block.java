// The UI library uses doubles for all the stuff...

/**
 * Simplest object. Has a position and dimensions.
 *
 */
public class Block {
    /** The block's width in px */
    private double width = 64;

    /** The block's height in px */
    private double height = 64;

    /** Block's X position (top-left) */
    private double x;

    /** Block's Y position (top-left) */
    private double y;
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // For getting the points at the other corner

    /**
     * Gets the Y at the bottom of the block
     * @return y + height
     */
    public double getFarY() {
        return y + height;
    }

    /**
     * Gets the X at the right of the block
     * @return x + width
     */
    public double getFarX() {
        return x + width;
    }

    Block(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean collidesWith(Block other) {
        // Collision from https://developer.mozilla.org/en-US/docs/Games/Techniques/2D_collision_detection
        // I'm not sure why but the bool is reversed
        return !(getX() < other.getFarX() &&
                getFarX() > other.getX() &&
                getY() < other.getFarY() &&
                getFarY() < other.getY());
    }
}
