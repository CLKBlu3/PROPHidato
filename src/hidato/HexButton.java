package hidato;
import javax.swing.*;
import java.awt.*;

//Following class draws the Buttons
class HexButton extends JButton {
    private static final long serialVersionUID = 1L;
    private static final int SIDES = 6;
    private static final int SIDE_LENGTH = 25;
    public static final int LENGTH = 50;
    public static final int WIDTH = 50;
    private Polygon hex;
    public Color c;


    public HexButton() {
        super();
        setContentAreaFilled(false);
        setFocusPainted(true);
        setBorderPainted(false);
        setPreferredSize(new Dimension(WIDTH, LENGTH));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        hex = new Polygon();
        for (int i = 0; i < SIDES; i++) {
            hex.addPoint((int) (25 + SIDE_LENGTH * Math.cos(i * 2 * Math.PI / SIDES)), //calculation for side
                    (int) (25 + SIDE_LENGTH * Math.sin(i * 2 * Math.PI / SIDES)));   //calculation for side
        }
        g.setColor(Color.ORANGE);
        //g.fillPolygon(hex);
        g.drawPolygon(hex);
    }
}