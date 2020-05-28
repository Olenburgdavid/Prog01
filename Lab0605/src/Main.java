import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Main extends JFrame {

    public static final int MAX_RECT_SIZE = 100;
    public static final int MAX_CIRCLE_RAD = 50;
    public static final int MAX_CROSS_SIZE = 50;
    class Canvas extends JPanel {
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);

            g.setColor(Color.BLUE);
            for(Shape shape : shapes) {
                shape.draw(g);
            }
        }
    }
    ArrayList<Shape> shapes = new ArrayList<>();
    Shape selected = null;
    int prevMouseX, prevMouseY;
    boolean dragging = false;

    public Main() {
        setTitle("Graphic Editor");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        Canvas canvas = new Canvas();
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1) {


                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    Shape selectedShape = null;
                    for (Shape shape : shapes) {
                        if (shape.contains(e.getX(), e.getY())) {
                            selectedShape = shape;
                        }
                    }
                    if (selectedShape != null) {
                        JOptionPane.showMessageDialog(null, selectedShape);
                    }

                }
            }
            @Override
            public void mousePressed(MouseEvent e){
                if (selected != null) {
                    selected.setSelected(false);
                    selected = null;

                }
                Shape selectedShape = null;
                for (Shape shape : shapes) {
                    if (shape.contains(e.getX(), e.getY())) {
                        selectedShape = shape;
                    }
                }
                if (selectedShape != null) {
                    selected = selectedShape;
                    selected.setSelected(true);

                    prevMouseX = e.getX();
                    prevMouseY = e.getY();
                    dragging = true;
                }
                repaint();

            }
            @Override
            public void mouseReleased(MouseEvent e) {
                dragging = false;
            }
        });
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (dragging) {
                    selected.move(e.getX() - prevMouseX, e.getY() - prevMouseY);
                    prevMouseX = e.getX();
                    prevMouseY = e.getY();
                    repaint();
                }
            }
        });
        JPanel toolbar = new JPanel();
        toolbar.setLayout(new GridLayout(1, 2));


        JButton rectangleButton = new JButton("Rectangle");
        rectangleButton.addActionListener(e -> {
            int x = (int)(Math.random() * getWidth());
            int y = (int)(Math.random() * getHeight());
            int width = (int)(Math.random() * MAX_RECT_SIZE);
            int height = (int)(Math.random() * MAX_RECT_SIZE);
            shapes.add(new Rectangle(x, y, width, height));
            repaint();
        } );
        JButton circleButton = new JButton("circle");
        circleButton.addActionListener(e -> {
            int x = (int)(Math.random() * getWidth());
            int y = (int)(Math.random() * getHeight());
            int radius = (int)(Math.random() * MAX_CIRCLE_RAD);
            shapes.add(new Circle(x, y, radius));
            repaint();

        });
        JButton crossButton = new JButton("cross");
        crossButton.addActionListener(e -> {
            int x = (int)(Math.random() * getWidth());
            int y = (int)(Math.random() * getHeight());
            int width = (int)(Math.random() * MAX_RECT_SIZE);
            int height = (int)(Math.random() * MAX_CROSS_SIZE);
            shapes.add(new Cross(x, y ,width,height));
            repaint();

        });



        toolbar.add(rectangleButton);
        toolbar.add(circleButton);
        toolbar.add(crossButton);


        add(canvas, BorderLayout.CENTER);
        add(toolbar, BorderLayout.SOUTH);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_D){
                    if (selected != null) {
                        shapes.remove(selected);
                        selected = null;
                        repaint();
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}