import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JFrame {
    class ColorButtonActionListener implements ActionListener {
        private Color color;

        public ColorButtonActionListener(JPanel panel, Color color){
            this.color = color;
        }

        public void actionPerformed(ActionEvent e){
            panel.setBackground(color);

        }
    }
    private JPanel panel;

    public Main() throws HeadlessException{
        setTitle("First GUI App");
        setSize(500, 500);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setBackground(Color.RED);
        add(panel, BorderLayout.CENTER);

        JPanel toolbar = new JPanel();
        toolbar.setBackground(Color.DARK_GRAY);
        toolbar.setLayout(new FlowLayout());

        JButton redButton = new JButton("Red");
        redButton.addActionListener(e -> panel.setBackground(Color.RED));
        toolbar.add(redButton);

        JButton greenButton = new JButton("Green");
        greenButton.addActionListener(e -> panel.setBackground(Color.GREEN));
        toolbar.add(greenButton);

        JButton blueButton = new JButton("Blue");
        blueButton.addActionListener(e -> panel.setBackground(Color.BLUE));
        toolbar.add(blueButton);



        add(toolbar, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}