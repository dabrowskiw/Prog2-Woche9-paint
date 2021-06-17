package org.htw.prog2.woche9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainFrame extends JFrame {
    /**
     * Klasse, um ein Auto zu zeichnen
     */
    private class CarPanel extends JPanel {
        // Farbe des Autos
        private Color color;

        /**
         * Constructor
         * @param color Farbe, in der das Auto gezeichnet werden soll
         */
        public CarPanel(Color color) {
            super();
            this.color = color;
            Dimension size = new Dimension(100, 100);
            setPreferredSize(size);
            setMaximumSize(size);
            setMinimumSize(size);
        }

        /**
         * Zeichnet das Auto mit zwei Rechtecken und zwei Kreisen
         * @param g Graphics-Kontext
         */
        public void paintComponent(Graphics g) {
            g.setColor(color);
            g.drawRect(40, 35, 40, 20);
            g.drawRect(5, 55, 90, 20);
            g.drawOval(10, 70, 20, 20);
            g.drawOval(70, 70, 20, 20);
        }
    }

    /**
     * Klasse, um einen lustigen Button zu zeichnen
     */
    public class FunkyButton extends JButton {
        // Farbe der Linie im Normalfall
        private Color color;
        // Farbe der Linie, falls die Maus über dem Button ist
        private Color overColor;
        // Zeigt an, ob die Maus über dem Button ist
        private boolean isRolledOver = false;

        /**
         * Constructor
         * @param text Text des Buttons
         * @param color Farbe der Linie im Normalfall
         * @param overColor Farbe der Linie, falls die Maus über dem Button ist
         */
        public FunkyButton(String text, Color color, Color overColor) {
            super(text);
            this.color = color;
            this.overColor = overColor;
            // Mittels MouseListener isRolledOver anpassen, wenn die Maus den Bereich über dem Button
            // betritt oder verlässt
            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent mouseEvent) { }
                @Override
                public void mousePressed(MouseEvent mouseEvent) { }
                @Override
                public void mouseReleased(MouseEvent mouseEvent) { }
                @Override
                public void mouseEntered(MouseEvent mouseEvent) {
                    isRolledOver = true;
                }
                @Override
                public void mouseExited(MouseEvent mouseEvent) {
                    isRolledOver = false;
                }
            });
        }

        /**
         * Button zeichnen
         * @param g Graphics-Kontext
         */
        public void paintComponent(Graphics g) {
            // Den Button selber über die paintComponent-Methode von JButton zeichnen lassen
            super.paintComponent(g);
            // Farbe wählen
            if(isRolledOver) {
                g.setColor(overColor);
            }
            else {
                g.setColor(color);
            }
            // Linie auf den über super.paintComponent() gezeichneten Button malen
            g.drawPolygon(new int[]{0, 5, 10, 29, 172},  new int[]{2, 12, 19, 8, 12}, 5);
        }
    }

    /**
     * Constructor von MainFrame
     */
    public MainFrame() {
        super("paintComponent demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BoxLayout layout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        setLayout(layout);
        add(new CarPanel(Color.blue));
        add(new FunkyButton("Hi there!", Color.magenta, Color.yellow));
        pack();
    }

    /**
     * Entry point
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
    }
}
