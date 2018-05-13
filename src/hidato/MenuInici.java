package hidato;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MenuInici {
    //MENU INICI
    private JButton novaPartidaButton;
    private JButton carregarPartidaButton;
    private JButton sortirButton;
    private JPanel MenuInici;
    private JLabel imageIni;
    private JButton musicButton;
    private JPanel southpanel;

    //Partida nova
    private PartidaNova partidaNova;

    private boolean music;
    private MusicPlayer player;


    public MenuInici() {
        partidaNova = new PartidaNova();
        music = true;
        player = new MusicPlayer("narutoInicio.wav", true);
        player.start();
        Color background = new Color(255,255,255);
        MenuInici.setBackground(background);
        southpanel.setBackground(background);
        sortirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        musicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(music){
                    music = false;
                    player.stopPlayback();
                    musicButton.setText("Music ON");
                }else{
                    music = true;
                    player.startPlayback();
                    musicButton.setText("Music OFF");
                }
            }
        });
        novaPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacio.getSingletonInstance().setContentFrame(partidaNova.getPanel());
            }
        });
    }


    private void createUIComponents() {
        String path = new File("").getAbsolutePath();
        // TODO: place custom component creation code here
        imageIni = new JLabel(new ImageIcon(path+"/res/hidato1.png"));

    }
    public JPanel getMenuIni(){
        return MenuInici;
    }

}
