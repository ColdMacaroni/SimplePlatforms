import java.awt.*;
import ecs100.*;
public class ColorBlock extends Block{
    private Color color;
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    ColorBlock(double x, double y, double width, double height, Color color) {
        super(x, y, width, height);
        this.color = color;
    }

    public void draw() {
        UI.setColor(getColor());
        UI.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public void erase() {
        UI.eraseRect(getX(), getY(), getWidth(), getHeight());
    }
}
