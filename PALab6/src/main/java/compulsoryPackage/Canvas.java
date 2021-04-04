package compulsoryPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Canvas extends JPanel {

    private BufferedImage image;
    private Graphics2D graphics;
    int currentMouseX,currentMouseY,lastMouseXPress,lastMouseYPress;

    public Canvas() {
        this.setBorder(BorderFactory.createTitledBorder("Drawing paper:"));
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(graphics != null) {
                    int stroke = Integer.parseInt(MainFrame.form.shapesStroke.getText());
                    lastMouseXPress = e.getX();
                    lastMouseYPress = e.getY();
                    drawNode(lastMouseXPress, lastMouseYPress, stroke);
                    repaint();
                }
            }
        });

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                currentMouseX = e.getX();
                currentMouseY = e.getY();

                if(graphics != null){
                    graphics.drawLine(lastMouseXPress,lastMouseYPress,currentMouseX,currentMouseY);
                    repaint();
                    lastMouseXPress = currentMouseX;
                    lastMouseYPress = currentMouseY;
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                lastMouseXPress = e.getX();
                lastMouseYPress = e.getY();
            }
        });
    }

    protected void paintComponent(Graphics g) {
        if(image == null) {
            image = new BufferedImage(640, 800, BufferedImage.TYPE_INT_ARGB);
            graphics = image.createGraphics();
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }

    public void clear() {
        graphics.setPaint(Color.white);
        graphics.fillRect(0, 0, getSize().width, getSize().height);
        graphics.setPaint(Color.black);
        repaint();
    }

    public void drawNode(int x, int y, int stroke) {
        Random rand = new Random();
        graphics.setColor(new Color(rand.nextInt(0xFFFFFF)));

        graphics.fill(new Circle(x,y,stroke));
        //graphics.drawRect(x-(stroke/2),y-(stroke/2),stroke,stroke);
    }

    public void drawRandomNodes(int repeatNo) {
        while (repeatNo>0) {
            Random rand = new Random();
            graphics.setColor(new Color(rand.nextInt(0xFFFFFF)));
            int random_x = rand.nextInt(getWidth() - 5);
            int random_y = rand.nextInt(getHeight() - 20);
            int random_circle_radius = rand.nextInt(50-5) + 6;

            graphics.fillOval(random_x,random_y,random_circle_radius,random_circle_radius);
            repeatNo--;
        }
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        graphics = image.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

}
