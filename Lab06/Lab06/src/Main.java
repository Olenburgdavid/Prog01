import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(0, 0, 100, 100));
        shapes.add(new Rectangle(40, 60, 50, 70));
        shapes.add(new Circle(100, 200, 20));
        shapes.add(new Circle(40, 60,  20));

        boolean working = true;
        while (working){
            System.out.print("cmd: ");
            String command = sc.next();

            switch (command){
                case "click":
                    System.out.print("x: ");
                    int x = sc.nextInt();

                    System.out.print("y: ");
                    int y = sc.nextInt();

                    for (Shape shape : shapes) {
                        if (shape.contains(x, y)) {
                            System.out.println(shape);
                        }

                    }
                    break;
                case "move":
                    System.out.print("x1: ");
                    int x1 = sc.nextInt();

                    System.out.print("y1: ");
                    int y1 = sc.nextInt();

                    System.out.print("x2: ");
                    int x2 = sc.nextInt();

                    System.out.print("y2: ");
                    int y2 = sc.nextInt();

                    for (Shape shape : shapes) {
                        if (shape.contains(x1, y1)) {
                            shape.move(x2 - x1, y2 - y1);
                        }

                    }

                    break;
                case "present":
                    for (Shape shape : shapes) {
                        System.out.println(shape);

                    }
                    break;
                case "stop":
                    break;

            }
        }

    }
}
