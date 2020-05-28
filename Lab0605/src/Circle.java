import java.awt.*;

public class Circle extends Shape{
    private final int radius;

    public Circle(int x, int y, int radius){
        super(x, y);

        this.radius = radius;

    }

    public boolean contains (int x, int y) {
        int dx = this.x - x;
        int dy = this.y - y;
        return dx * dx + dy + dy < radius * radius;
    }

    @Override
    public void draw(Graphics g) {
        int diameter = radius * 2;
        g.fillOval(x - radius, y - radius, diameter, diameter);
        if (isSelected()) {
            Color previousColor = g.getColor();
            g.setColor(Color.RED);
            g.drawOval(x - radius, y - radius, diameter, diameter);
            g.setColor(previousColor);
        }

    }

    @Override
    public String toString() {
        return String.format("Circle: %d, %d, %d", x, y, radius);
    }
}