package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.function.Consumer;

public class FractalGenerator extends JFrame {
    private final DrawingPanel drawingPanel = new DrawingPanel();
    
    // create private variables for your sliders if you want sliders
    private JSlider depthSlider = createSlider("Recursion Depth:", 0, 7, 3);
    private JSlider thicknessSlider = createSlider("Thickness:", 1, 10, 1);

    // create private variables for colors of components if you want color 
    
    // create private variable for the type of fractal you are drawing if you want 
    private String fractalType;
    private Color chooseColor;

    // user to be able to change type
    
    public FractalGenerator() {
        super("Fractal Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(createControlPanel(), BorderLayout.WEST);
        add(drawingPanel, BorderLayout.CENTER);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createControlPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // create a JComboBox/drop down menu and listener
        JComboBox<String> dropDown = new JComboBox<>();
        dropDown.setBounds(10, 80, 100, 20);
        dropDown.addItem("");
        dropDown.addItem("Sierpinski's Carpet");
        dropDown.addItem("Sierpinski's Triangle");
        dropDown.addItem("Koch Curve");
        dropDown.addItem("Koch Snowflake");
        dropDown.addItem("Fractal Tree");
        dropDown.addItem("Fractal Tree Snowflake");
        dropDown.setVisible(true);
        panel.add(dropDown);

        dropDown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selected = (String) dropDown.getSelectedItem();
                fractalType = selected;
                drawingPanel.repaint();
            }});

        // make color button
        panel.add(createColorButton("Color", c -> chooseColor = c));

        // add components to the left side control panel
        
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> resetSettings());
        panel.add(resetButton);

        panel.add(depthSlider);
        panel.add(thicknessSlider);

        return panel;
    }

    private JPanel createLabeledComponent(String label, JComponent component) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel(label), BorderLayout.NORTH);
        panel.add(component, BorderLayout.CENTER);
        return panel;
    }

    private JButton createColorButton(String text, Consumer<Color> colorSetter) {
        JButton button = new JButton(text);
        button.addActionListener(e -> {
            Color initialColor = getColorByButtonName(text);
            Color newColor = JColorChooser.showDialog(this, "Choose " + text, initialColor);
            if (newColor != null) {
                colorSetter.accept(newColor);
                drawingPanel.repaint();
            }
        });
        return button;
    }
    
    private Color getColorByButtonName(String name) {
        return Color.BLACK;
        // returns the color depending on what part they name
    }

    private void resetSettings() {
        // reset slider values
        depthSlider.setValue(3);
        thicknessSlider.setValue(1);

        // reset colors
        
        drawingPanel.repaint();
    }

    private JSlider createSlider(String title, int min, int max, int value) {
        JSlider slider = new JSlider(min, max, value);
        slider.setMajorTickSpacing((max - min) / 4);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(e -> drawingPanel.repaint());
        return slider;
    }

    private class DrawingPanel extends JPanel {
        public DrawingPanel() {
            setBackground(Color.WHITE);
        }
        
        @Override protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int width = getWidth();
            int height = getHeight();
            int size = Math.min(width, height) - 50;

            int x1 = width / 2;
            int y1 = 20;
            int x2 = x1 - size / 2;
            int y2 = y1 + size - 100;
            int x3 = x1 + size / 2;
            int y3 = y2;
            int depth = depthSlider.getValue();
            
            // call the correct draw fractal function

            if (fractalType.equals("Sierpinski's Carpet")){
                drawSierpinski(g2d, width/2 + 80, width/2 + 80, depth, 110, 60);
            }
            else if (fractalType.equals("Sierpinski's Triangle")){
                drawTriangle(g2d, x1, y1, x2, y2, x3, y3, depth);
            }
            else if (fractalType.equals("Koch Curve")){
                drawKochCurve(g2d, 500, 300, 100, 300, depth);
            }
            else if (fractalType.equals("Koch Snowflake")){
                drawKochSnowflake(g2d, x2, y2, x1, y1, x3, y3, depth);
            }
            else if (fractalType.equals("Fractal Tree")){
                drawFractalTree(g2d, 300, 500, 300, 400, Math.PI/2, depth);
            }
            else if(fractalType.equals("Fractal Tree Snowflake")){
                drawFractalSnowflake(g2d, 200, 300, 300, 200, 400, 300, 300, 400, depth);
            }
            
        }
        
        
        private void drawKochSnowflake(Graphics2D g, int x1, int y1, int x2, int y2, int x3, int y3, int depth) {
            // complete this method
            g.setColor(chooseColor);
            g.setStroke(new BasicStroke(thicknessSlider.getValue()));

            // base case equilateral triangle
            if (depth == 0){
                g.drawLine(x1, y1, x2, y2);
                g.drawLine(x2, y2, x3, y3);
                g.drawLine(x3, y3, x1, y1);
            }

            // draws koch curve on each side of triangle
            else{
                drawKochCurve(g, x2, y2, x1, y1, depth - 1);
                drawKochCurve(g, x3, y3, x2, y2, depth - 1);
                drawKochCurve(g, x1, y1, x3, y3, depth - 1);
            }
        }

        private void drawKochCurve(Graphics2D g, int x1, int y1, int x2, int y2, int depth) {
            g.setColor(chooseColor);
            g.setStroke(new BasicStroke(thicknessSlider.getValue()));

            if (depth == 0) {
                g.drawLine(x1, y1, x2, y2);
                return;
            }

            // xA is 1/3, xB is 2/3
            int dx = x2 - x1;
            int dy = y2 - y1;
            int xA = x1 + dx / 3;
            int yA = y1 + dy / 3;
            int xB = x1 + 2 * dx / 3;
            int yB = y1 + 2 * dy / 3;
            double angle = Math.toRadians(60);
            
            // i relent it makes sense but idk how u made this math urself i admit defeat to the computer math
            int xC = (int) (0.5 * (xA + xB) - Math.sin(angle) * (yB - yA));
            int yC = (int) (0.5 * (yA + yB) + Math.sin(angle) * (xB - xA));

            // draws koch curve on all four sides
            drawKochCurve(g, x1, y1, xA, yA, depth - 1);
            drawKochCurve(g, xA, yA, xC, yC, depth - 1);
            drawKochCurve(g, xC, yC, xB, yB, depth - 1);
            drawKochCurve(g, xB, yB, x2, y2, depth - 1);
        }
        
        private void drawSierpinski(Graphics2D g, int width, int height, int depth, int x, int y) {
            g.setColor(chooseColor);
            g.setStroke(new BasicStroke(thicknessSlider.getValue()));
            // complete this method

            // base case square
            if (depth == 0){
                g.setColor(new Color(40, 150, 150));
                g.drawRect(x, y, width, height);
            }

            // recursion draws 8 squares around a middle square
            else{
                for(int left = 0; left < 3; left++){
                    for(int top = 0; top < 3; top++){
                        if(!(left == 1 && top == 1)){
                            drawSierpinski(g, width/3, height/3, depth - 1, x + left * (width/3), y + top * (height/3));
                        }
                    }
                }
            }
        }

        private void drawFractalTree(Graphics2D g, int x1, int y1, int x2, int y2, double angle, int depth) {
            // complete this method
            g.setColor(chooseColor);
            g.setStroke(new BasicStroke(thicknessSlider.getValue()));

            // base case single trunk
            if (depth == 0){
                g.drawLine(x1, y1, x2, y2);
            }

            // recursion, draws two branches with length l/2
            else{
                angle = Math.atan2((y2-y1), (x2-x1));
                double angle60 = Math.toRadians(30);
                double d = Math.sqrt((Math.pow((x2-x1), 2))+(Math.pow((y2-y1), 2)));
                double h = d * 0.7;

                int xLeft = (int) (x2 + (Math.cos(angle - angle60) * h));
                int yLeft = (int) (y2 + (Math.sin(angle - angle60) * h));
                int xRight = (int) (x2 + (Math.cos(angle + angle60) * h));
                int yRight = (int) (y2 + (Math.sin(angle + angle60) * h));

                g.drawLine(x1, y1, x2, y2);

                drawFractalTree(g, x2, y2, xLeft, yLeft, angle - angle60, depth - 1);
                drawFractalTree(g, x2, y2, xRight, yRight, angle + angle60, depth - 1);
            }
        }

        private void drawFractalSnowflake(Graphics2D g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int depth){
            g.setColor(chooseColor);
            g.setStroke(new BasicStroke(thicknessSlider.getValue()));

            // base case, four lines in the shape of an cross
            // x1 is left line pointing west, x2 is top line pointing north, etc.
            if (depth == 0){
                int xMid = (x1 + x3)/2;
                int yMid = (y1 + y3)/2;

                g.drawLine(x1, y1, xMid, yMid);
                g.drawLine(x2, y2, xMid, yMid);
                g.drawLine(x3, y3, xMid, yMid);
                g.drawLine(x4, y4, xMid, yMid);
            }

            else{
                int xMid = (x1 + x3)/2;
                int yMid = (y1 + y3)/2;
                drawFractalTree(g, x1, y1, xMid, yMid, Math.PI, depth - 1);
                drawFractalTree(g, x2, y2, xMid, yMid, Math.PI/2 ,depth - 1);
                drawFractalTree(g, x3, y3, xMid, yMid, (3*Math.PI)/2, depth - 1);
                drawFractalTree(g, x4, y4, xMid, yMid, 0 ,depth - 1);
            }
        }
        
        private void drawTriangle(Graphics2D g, int x1, int y1, int x2, int y2, int x3, int y3, int depth) {
            g.setColor(chooseColor);
            g.setStroke(new BasicStroke(thicknessSlider.getValue()));
            
            // base case draws a triangle
            if (depth == 0) {
                g.drawLine(x1, y1, x2, y2);
                g.drawLine(x2, y2, x3, y3);
                g.drawLine(x3, y3, x1, y1);
                return;
            }

            // recursion draws three triangles around
            else{
                drawTriangle(g, x1, y1, (x1 + x2)/2, (y1 + y2)/2, (x1 + x3)/2, (y1 + y3)/2, depth - 1);
                drawTriangle(g, (x1 + x2)/2, (y1 + y2)/2, x2, y2, (x2 + x3)/2, (y2 + y3)/2, depth - 1);
                drawTriangle(g, (x1 + x3)/2, (y1 + y3)/2, (x2 + x3)/2, (y2 + y3)/2, x3, y3, depth - 1);
            }
        }

    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(FractalGenerator::new);
    }
}