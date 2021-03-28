package optionalPackage.tools;

import optionalPackage.MainFrame;

import javax.swing.*;

public class ControlPanel extends JPanel {
    public JButton loadButton = new JButton("Load");
    public JButton saveButton = new JButton("Save");
    public JButton resetButton = new JButton("Reset");
    MainFrame frame;

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