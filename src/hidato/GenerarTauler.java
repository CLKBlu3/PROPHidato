package hidato;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author marc.catrisse & lluis.marques
 */
public class GenerarTauler {
    private JPanel generarT;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JButton tornarButton;
    private JButton OKButton;
    private JPanel insertarConf;
    private JPanel southPanel;
    private JTextField textField1;
    private JProgressBar progressBar1;
    private Thread threadSolver;
    private Partida p;

    public GenerarTauler() {
        threadSolver = null;
        tornarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacio.getSingletonInstance().setContentFrame(new PartidaNova().getPanel());
            }
        });
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name;
                try{
                    name = getName();
                }catch(Utils.ExceptionNomNoValid ex){
                    return;
                }
                OKButton.setEnabled(false);
                threadSolver = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar1.setVisible(true);
                        //Gestor g = CtrlPresentacio.gestorSingleton();
                        CtrlPresentacio.getSingletonInstance().crearPartida(getOpcio("tcela"),getOpcio("adj"),getOpcio("dif"),name);
                        //TODO System.out 4 debug ELIMINAR!!!
                        p = CtrlPresentacio.getSingletonInstance().getPartida();
                        System.out.println("Nom user: " + p.getJugador().getNom());
                        System.out.println("Tipus cela: " + p.getConf().getcell());
                        System.out.println("Adj: " + p.getConf().getAdjacencia());
                        System.out.println("Dificultat: " + p.getConf().getDificultat());
                        System.out.println("Tauler: ");
                        Utils.printa_tauler(p.getTauler().getTauler());
                        progressBar1.setVisible(false);
                        OKButton.setEnabled(true);
                        Utils.start_partida();
                    }
                });
                threadSolver.start();
            }
        });
    }
    private String getName() throws Utils.ExceptionNomNoValid {
        String aux = textField1.getText();
        aux = aux.replace(" ","");
        if(!aux.isEmpty()){
            return aux;
        }else{
            JOptionPane.showMessageDialog(new JFrame(),
                    "Inserta un nom de jugador!");
            throw new Utils.ExceptionNomNoValid();
        }
    }
    public JPanel getPanel(){
        return generarT;
    }

    private String getOpcio(String opcio){
        int aux;
        switch(opcio){
            case "tcela":
                aux = comboBox1.getSelectedIndex();
                switch (aux){
                    case 0:
                        return "Q";
                    case 1:
                        return "T";
                    default:
                        return "H";
                }
            case "adj":
                aux = comboBox2.getSelectedIndex();
                switch (aux){
                    case 0:
                        return "C";
                    default:
                        return "CA";
                }
            default:
                aux = comboBox3.getSelectedIndex();
                switch (aux){
                    case 0:
                        return "Facil";
                    case 1:
                        return "Normal";
                    default:
                        return "Dificil";
                }
        }
    }

}
