import java.awt.*;

public class Rectangle extends Shape{
    private final int  width, height;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);

        this.width = width;
        this.height = height;
    }
    public boolean contains(int x, int y){
        return x >= this.x && x < this.x + width &&
                y >= this.y && y < this.y + height;
    }
    @Override
    public void draw(Graphics g) {
        g.fillRect(x, y, width, height);
        if (isSelected()) {
            Color previousColor = g.getColor();
            g.setColor(Color.RED);
            g.drawRect(x, y, width, height);
            g.setColor(previousColor);
        }

    }
    @Override
    public String toString() {
        return String.format("Rectangle: %d, %d, %d, %d" , x, y, width, height);
    }
}