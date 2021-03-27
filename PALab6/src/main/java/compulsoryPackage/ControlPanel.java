package compulsoryPackage;

import javax.swing.*;

public class ControlPanel extends JPanel {
    private final MainFrame frame;
    JButton loadButton = new JButton("Load");
    JButton saveButton = new JButton("Save");
    JButton resetButton = new JButton("Reset");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        add(loadButton);
        add(saveButton);
        add(resetButton);
    }
}