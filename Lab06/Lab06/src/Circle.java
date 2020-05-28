public class Circle extends Shape{
    private final int radius;

    public Circle(int x, int y, int radius){
        super(x,y);
        this.radius = radius;
    }
    @Override
    public boolean contains(int x, int y){
        int dx = this.x - x;
        int dy = this.y - y;

        return dx * dx + dy * dy < radius * radius;
    }


    @Override
    public String toString(){
        return String.format("Circle: %d, %d, %d", x, y, radius);
    }
}
