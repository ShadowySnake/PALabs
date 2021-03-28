package optionalPackage.tools;

import javax.swing.*;
import java.awt.*;

public class ConfigurationPanel extends JPanel {

    public JLabel shapeNoLabel = new JLabel("Shapes number: ");
    public JLabel strokeLabel = new JLabel("Stroke size: ");
    public JLabel shapeTypeLabel = new JLabel("Shape: ");

    public JTextField shapesNo = new JFormattedTextField();
    public JTextField shapesStroke = new JFormattedTextField();
    public JTextField shapeType = new JFormattedTextField();

    public JButton drawButton = new JButton("Draw");
    public JButton deleteButton = new JButton("Delete (Right-Click)");

    public ConfigurationPanel() {
        this.setBorder(BorderFactory.createTitledBorder("Toolbar"));
        init();
        this.setLayout(new GridLayout(3, 3, 20, 0));
    }

    private void init() {

        shapesStroke.setText("5");
        shapesNo.setText("1");
        shapeType.setText("Circle");

        add(deleteButton);
        add(drawButton);
        add(shapeNoLabel);
        add(strokeLabel);
        add(shapeTypeLabel);

        add(shapesNo);
        add(shapesStroke);
        add(shapeType);
    }

}
