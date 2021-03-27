package compulsoryPackage;

import javax.swing.*;
import java.awt.*;

public class ConfigurationPanel extends JPanel {

    JLabel shapeNoLabel = new JLabel("Shapes number: ");
    JLabel strokeLabel = new JLabel("Stroke size: ");

    JTextField shapesNo = new JFormattedTextField();
    JTextField shapesStroke = new JFormattedTextField();

    JButton drawButton = new JButton("Draw");

    public ConfigurationPanel() {
        this.setBorder(BorderFactory.createTitledBorder("Toolbar"));
        init();
        this.setLayout(new GridLayout(2,3, 20, 0));
    }

    private void init() {

        shapesStroke.setText("5");
        shapesNo.setText("1");

        add(shapeNoLabel);
        add(strokeLabel);
        add(drawButton);

        add(shapesNo);
        add(shapesStroke);
    }

}
