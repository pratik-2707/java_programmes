import javax.swing.*;

public class swing_practice extends JFrame {
    public swing_practice() {
        super("Hello World");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(new JLabel("Hello, world!"));
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(swing_practice::new);
    }
}