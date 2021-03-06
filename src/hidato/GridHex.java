package hidato;

import javax.swing.*;
import java.awt.*;


public class GridHex extends GridGame {
    public GridHex(JPanel gamePanel, Celda[][] mapaCeldas) {
        super(gamePanel,mapaCeldas);
    }

    @Override
    public int offiniY() {
        return 50;
    }

    @Override
    public int incrementoIY(int j) {
        if(!(j % 2 == 0)) return 150;
        else return 100;
    }

    @Override
    public int incrementoJY(int y) {
        if(y % 2 == 0) return -50;
        else return 50;
    }

    @Override
    public int incrementoJX() {
        return 86;
    }

    @Override
    public JButton[][] obteArrayCelda() {
        return new HexButton[super.getI()][super.getJ()];
    }

    @Override
    public JButton ObteCelda(boolean act, boolean orientacio, Color c) {
        return new HexButton(act,c);
    }
}
