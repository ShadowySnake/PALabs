package optionalPackage;

import optionalPackage.shapes.Circle;
import optionalPackage.shapes.Squares;
import optionalPackage.tools.ConfigurationPanel;
import optionalPackage.tools.ControlPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame {
    static ConfigurationPanel form;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int height = screenSize.height / 2;
    int width = screenSize.width / 3;
    Canvas drawArea;
    ControlPanel control;

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == control.resetButton) {
                drawArea.drawnOBJ.nodesList.clear();
                drawArea.drawnOBJ.edgesList.clear();
                drawArea.drawnOBJ.squaresList.clear();
                drawArea.clear();
            } else if (e.getSource() == control.loadButton) {
                try {
                    load();
                } catch (IOException e1) {
                    System.out.println("Fisierul nu exista sau formatul nu este bun.");
                }
            } else if (e.getSource() == control.saveButton) {
                try {
                    save();
                } catch (IOException e1) {
                    System.out.println("Destinatia nu exista sau nu ai drept de salvare.");
                }
            } else if (e.getSource() == form.drawButton) {
                int repeat = Integer.parseInt(form.shapesNo.getText());

                drawArea.drawRandomShapes(repeat);
                repaint();
            } else if (e.getSource() == form.deleteButton) {
                Circle node = drawArea.drawnOBJ.getNodeAt(drawArea.currentMouseX, drawArea.currentMouseY);
                if (node != null) {
                    drawArea.drawnOBJ.deleteNode(node);
                } else {
                    Squares square = drawArea.drawnOBJ.getSquareAt(drawArea.currentMouseX, drawArea.currentMouseY);
                    if(square!=null){
                        drawArea.drawnOBJ.deleteSquare(square);
                    }
                }
                repaint();
            }
        }
    };

    public MainFrame() {
        super("JAVA Paint");
        rootPane.setBorder(BorderFactory.createTitledBorder("Drawing panel"));
        rootPane.setPreferredSize(new Dimension(width, height));
        init();
        addComponents();
        this.pack();
    }

    private void init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        form = new ConfigurationPanel();
        drawArea = new Canvas();
        control = new ControlPanel(this);
        form.drawButton.addActionListener(actionListener);
        control.resetButton.addActionListener(actionListener);
        control.saveButton.addActionListener(actionListener);
        control.loadButton.addActionListener(actionListener);
    }

    private void addComponents() {
        add(form, BorderLayout.NORTH);
        add(drawArea, BorderLayout.CENTER);
        add(control, BorderLayout.SOUTH);
    }

    public void save() throws IOException {
        ImageIO.write(drawArea.getImage(), "PNG", new File("lab6_Paint_demo.png"));
    }

    public void load() throws IOException {
        drawArea.setImage(ImageIO.read(new File("lab6_Paint_demo.png")));
        repaint();
    }
}
