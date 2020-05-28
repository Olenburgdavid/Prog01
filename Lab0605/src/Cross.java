import java.awt.*;

public class Cross extends Shape {
    Rectangle rV;
    Rectangle rH;

    public Cross(int aX, int aY, int aW1, int aW2) {
        super(aX, aY);
        rV = new Rectangle(x - aW2 / 2, y - aW1 / 2, aW2, aW1);
        rH = new Rectangle(x - aW1 / 2, y - aW2 / 2, aW1, aW2);
    }

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
        rV.move(dx, dy);
        rH.move(dx, dy);
    }

    @Override
    public boolean contains(int aX, int aY) {
        return rV.contains(aX, aY) || rH.contains(aX, aY);
    }

    @Override
    public void draw(Graphics g) {
        rV.draw(g);
        rH.draw(g);
    }

    @Override
    public void setSelected(boolean b) {
        super.setSelected(b);
        rV.setSelected(b);
        rH.setSelected(b);
    }

    @Override
    public String toString() {
        return "Cross: (" + rV + ")" + ", (" + rH + ")";
    }
}