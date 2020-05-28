public class Rectangle extends Shape{
    private int x , y , width, height;

  public Rectangle(int x, int y, int width, int height){
      super(x,y);
      this.height = height;
      this.width = width;
  }
    public boolean contains(int x, int y){
      return x >= this.x && x < this.x + width &&
              y >= this.y && y < this.y + height;
    }
    @Override
    public String toString() {
        return String.format("Rectangle: %d, %d, %d, %d", x, y, width, height);
    }
}