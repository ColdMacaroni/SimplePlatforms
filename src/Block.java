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

    public void draw() {}

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
    // This is horrible, btw. A more efficient algorithm is left as an exercise to the CPU.
    /**
     * Does the right side of this block collide with the other's left side?
     */
    public boolean collideRight(Block other, double offset) {
        return other.isPointInside(getFarX() + offset, getY()) ||
               other.isPointInside(getFarX() + offset, getFarY()) ||
               isPointInside(other.getX() - offset, other.getY()) ||
               isPointInside(other.getX() - offset, other.getFarY());
    }

    public boolean collideRight(Block other) {return collideRight(other, 0);}

    /**
     * Does the left side of this block collide with the other's right side?
     */
    public boolean collideLeft(Block other, double offset) {
        return other.isPointInside(getX() + offset, getY()) ||
               other.isPointInside(getX() + offset, getFarY()) ||
                isPointInside(other.getFarX() - offset, other.getY())||
                isPointInside(other.getFarX() - offset, other.getFarY());
    }

    public boolean collideLeft(Block other) {return collideLeft(other, 0);}


    /**
     * Does the bottom side of this block collide with the other's top side?
     */
    public boolean collideBottom(Block other, double offset) {
        return other.isPointInside(getX(), getFarY() + offset) ||
               other.isPointInside(getFarX(), getFarY() + offset) ||
               isPointInside(other.getX(), other.getY() - offset) ||
               isPointInside(other.getFarX(), other.getY() - offset);
    }

    public boolean collideBottom(Block other) {return collideBottom(other, 0);}

    /**
     * Does the top side of this block collide with the other's bottom side?
     */
    public boolean collideTop(Block other, double offset) {
        return other.isPointInside(getX(), getY() + offset) ||
               other.isPointInside(getFarX(), getY() + offset) ||
               isPointInside(other.getX(), getFarY() - offset) ||
               isPointInside(other.getFarX(), getFarY() - offset);
    }
    public boolean collideTop(Block other) {return collideTop(other, 0);}

}
