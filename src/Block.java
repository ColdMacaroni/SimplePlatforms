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

    /**
     * Checks if the given point is inside the block
     * @return If the point is inside the block.
     */
    public boolean isPointInside(double x, double y) {
        return (getX() < x && x < getFarX() &&
                getY() < y && y < getFarY());
    }

    // These individual collision aren't ideal. TBH no idea what i'm doing lmfao
    // Main reasoning is that I want to be able to stop movement (and detect) in a specific direction.
    /**
     * Does the right side of this block collide with the other's left side?
     */
    public boolean collideRight(Block other) {
        return other.isPointInside(getFarX(), getY()) || isPointInside(getFarX(), getFarY());
    }

    /**
     * Does the left side of this block collide with the other's right side?
     */
    public boolean collideLeft(Block other) {
        return other.isPointInside(getX(), getY()) || isPointInside(getX(), getFarY());
    }

    /**
     * Does the bottom side of this block collide with the other's top side?
     */
    public boolean collideBottom(Block other) {
        return other.isPointInside(getX(), getFarY()) || isPointInside(getFarX(), getFarY());
    }

    /**
     * Does the top side of this block collide with the other's bottom side?
     */
    public boolean collideTop(Block other) {
        return other.isPointInside(getX(), getY()) || isPointInside(getFarX(), getY());
    }
}
