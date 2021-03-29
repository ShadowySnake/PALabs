package optionalPackage;

import optionalPackage.shapes.Circle;
import optionalPackage.shapes.Edge;
import optionalPackage.shapes.SimpleLines;
import optionalPackage.shapes.Squares;

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
    public int currentMouseX, currentMouseY;
    int lastMouseXPress, lastMouseYPress;
    int lastX = -1, lastY = -1;

    DrawnObjects drawnOBJ;

    public Canvas() {
        drawnOBJ = new DrawnObjects();

        this.setBorder(BorderFactory.createTitledBorder("Drawing paper:"));
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentMouseX = e.getX();
                currentMouseY = e.getY();

                if (e.getButton() == MouseEvent.BUTTON3) {
                    Circle node = drawnOBJ.getNodeAt(currentMouseX, currentMouseY);

                    if(node != null) {
                        drawnOBJ.deleteNode(node);
                    } else {
                        Squares square = drawnOBJ.getSquareAt(currentMouseX,currentMouseY);

                        if(square!=null){
                            drawnOBJ.deleteSquare(square);
                        } else {
                            int stroke = Integer.parseInt(MainFrame.form.shapesStroke.getText());
                            SimpleLines line = drawnOBJ.getLineAt(currentMouseX,currentMouseY,stroke);

                            if(line!=null){
                                drawnOBJ.linesList.remove(line);
                            }
                        }
                    }

                    repaint();
                } else if(graphics != null) {
                    int stroke = Integer.parseInt(MainFrame.form.shapesStroke.getText());
                    String type = MainFrame.form.shapeType.getText();

                    if(type.equals("Square") || type.equals("square")){
                        Squares square = drawnOBJ.getSquareAt(currentMouseX,currentMouseY);

                        if(square == null){
                            drawnOBJ.addSquare(new Squares(currentMouseX,currentMouseY,stroke));
                            lastX = -1;
                            lastY = -1;
                        }
                    }
                    else {
                        Circle node = drawnOBJ.getNodeAt(currentMouseX, currentMouseY);

                        if(node != null) {
                            if (lastX == -1 && lastY == -1) {
                                lastX = currentMouseX;
                                lastY = currentMouseY;
                            } else {
                                Circle from = drawnOBJ.getNodeAt(lastX, lastY);
                                Circle to = drawnOBJ.getNodeAt(currentMouseX, currentMouseY);

                                if(from != null && to != null) {
                                    drawnOBJ.addEdge(from, to, stroke);
                                }

                                lastX = -1;
                                lastY = -1;
                            }
                        } else {
                            drawnOBJ.addNode(currentMouseX, currentMouseY, stroke);

                            lastX = -1;
                            lastY = -1;
                        }
                    }
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
                    drawnOBJ.addLine(new SimpleLines(lastMouseXPress,lastMouseYPress,currentMouseX,currentMouseY));
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

        super.paintComponent(g);
        image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        graphics = (Graphics2D)image.getGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Circle circle : drawnOBJ.getNodes()){
            drawCircleAt(circle.x,circle.y,circle.stroke);
        }

        for (Edge edge: drawnOBJ.getEdges()) {
            drawLine(edge.getFrom().x, edge.getFrom().y, edge.getTo().x, edge.getTo().y, 5);
        }

        for (Squares square: drawnOBJ.getSquaresList()){
            drawSquareAt(square.x,square.y,square.width);
        }

        for (SimpleLines line: drawnOBJ.getLinesList()){
            graphics.setPaint(Color.black);
            graphics.drawLine(line.startX,line.startY,line.endX,line.endY);
        }

        g.drawImage(image, 0, 0, null);
    }

    public void clear() {
        graphics.setPaint(Color.white);
        graphics.fillRect(0, 0, getSize().width, getSize().height);
        graphics.setPaint(Color.black);
        repaint();
    }

    public void drawCircleAt(int x, int y, int radius) {
        Random rand = new Random();
        graphics.setColor(new Color(rand.nextInt(0xFFFFFF)));
        graphics.fillOval(x - (radius / 2), y - (radius / 2), radius, radius);
    }

    public void drawLine(int x1, int y1, int x2, int y2, int stroke) {
        graphics.setStroke(new BasicStroke(stroke));
        graphics.drawLine(x1, y1, x2, y2);
    }

    public void drawSquareAt(int x,int y, int stroke){
        Random rand = new Random();
        graphics.setColor(new Color(rand.nextInt(0xFFFFFF)));
        graphics.fillRect(x - (stroke / 2), y - (stroke / 2), stroke, stroke);
    }

    public void drawRandomShapes(int repeatNo) {
        while (repeatNo>0) {
            Random rand = new Random();
            graphics.setColor(new Color(rand.nextInt(0xFFFFFF)));
            int random_x = rand.nextInt(getWidth() - 5);
            int random_y = rand.nextInt(getHeight() - 20);
            int random_circle_radius = rand.nextInt(50-5) + 6;
            int random_square_width = rand.nextInt(50-5) + 7;
            boolean randomShape = rand.nextBoolean();

            if(randomShape) {
                drawnOBJ.addNode(random_x,random_y,random_circle_radius);
                graphics.fillOval(random_x, random_y, random_circle_radius, random_circle_radius);
            }
            else {
                drawnOBJ.addSquare(new Squares(random_x,random_y,random_square_width));
                graphics.fillRect(random_x, random_y, random_square_width, random_square_width);
            }

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
