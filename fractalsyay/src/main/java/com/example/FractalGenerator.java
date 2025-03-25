package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.function.Consumer;

public class FractalGenerator extends JFrame {
    private final DrawingPanel drawingPanel = new DrawingPanel();
    
    // create private variables for your sliders if you want sliders


    // create private variables for colors of components if you want color 
    
    // create private variable for the type of fractal you are drawing if you want 
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
        JComboBox dropDown = new JComboBox<>();
        dropDown.setBounds(20, 20, 20, 20);
        dropDown.setVisible(true);

        // add components to the left side control panel
     
        
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> resetSettings());
        panel.add(resetButton);
        

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

            int width = getWidth(), height = getHeight();
            int depth = 4;
            
            // call the correct draw fractal function

            
        }
        
        
        private void drawKochSnowflake(Graphics2D g, int width, int height, int depth) {
            // complete this method
        }
        
        private void drawSierpinski(Graphics2D g, int width, int height, int depth) {
            // complete this method
        }
        
        private void drawFractalTree(Graphics2D g, int width, int height, int depth) {
            // complete this method
        }

    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(FractalGenerator::new);
    }
}