public abstract class Shape {
    protected int x, y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public abstract boolean contains(int x, int y);

    public void move(int dx, int dy) {
        x += dx;
        y += dy;

    }
}