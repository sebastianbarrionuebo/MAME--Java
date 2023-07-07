
package LaberintoPantallas;

import MamePantallas.MameFrame;
import com.sun.tools.javac.Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import LaberintoModels.Goomba;
import LaberintoModels.Laberinto;
import LaberintoModels.Mario;
import Usuario.Usuario;


public class JuegoPanel extends JPanel implements KeyListener{
    
    private Laberinto laberinto = new Laberinto();
    private Mario personaje = new Mario(laberinto);
    private Goomba goomba = new Goomba(800,320,800,360, laberinto);
    private Goomba goomba2 = new Goomba(800,320,800,360, laberinto);
    private MameFrame mame;
    private MyThread goombaTh;
    private Boolean finalJuego;  ///FInaliza el hilo del movimiento de los goomba
    private Integer puntaje = 1000;
    private Usuario userOn;
   
    public JuegoPanel(JFrame frame, Usuario usu) {
        this.mame = (MameFrame)frame;
        this.userOn = usu;
        this.addKeyListener((KeyListener) this);
        this.setPreferredSize(new Dimension(930,560));
        this.setVisible(true);
        this.setFocusable(true);
    }

    public void setUserOn(Usuario userOn) {
        this.userOn = userOn;
    }
    
    public void resetGame(){
        this.laberinto.setNivel(1);
        this.puntaje = 1000;
    }
    
    @Override
    public void paintComponent(Graphics grafico){
        super.paintComponent(grafico);
        this.laberinto.paintComponent(grafico);
        this.personaje.paintComponent(grafico);
        if (laberinto.obtenerNivel() == 1){
            this.goomba.paintComponent(grafico);
        }
        if (laberinto.obtenerNivel() == 2){
            if( goomba.getCambioDeEscenario() ){
                goomba.setX(800);
                goomba.setY(320);
                goomba.setCambioDeEscenario(false);
            }
            this.goomba.paintComponent(grafico);
        }
        if (laberinto.obtenerNivel() == 3){
            if( !goomba.getCambioDeEscenario() ){
                goomba.setX(800);
                goomba.setY(320);
                goomba.setCambioDeEscenario(true);
            }
            this.goomba.paintComponent(grafico);
            this.goomba2.paintComponent(grafico);
        }
        if(personaje.getMuerto()){
            goomba.setX(800);
            goomba.setY(320);
            personaje.setMuerto(false);
            laberinto.setNivel(1);
        }
    }
    
    public void resetPosition() {
        goomba.setX(800);
        goomba.setY(320);
        goomba.resetComer();
        
        goomba2.setX(800);
        goomba2.setY(320);
        goomba2.resetComer();
        
        personaje.setX(40);
        personaje.setY(40);
        personaje.setMuerto(false);
        this.repaint();
    }
    
    public void initJuego(){
        resetPosition();
        this.goombaTh= new MyThread(this);
        this.goombaTh.start();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        personaje.teclaTocada(e);
        puntaje = puntaje -1;
        if( this.laberinto.obtenerNivel() >= 4 ){
            this.mame.deJuegoaVictory();
            finalJuego = false;
            if(userOn.getMaxLab() < puntaje){
                userOn.setMaxLab(puntaje);
            }
            userOn.setCoins(puntaje);
            try {
                goombaTh.join(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(JuegoPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if((goomba.getComer() == true) || (goomba2.getComer()) == true){
            this.mame.deJuegoAMuerto();
            finalJuego = false;
            try {
                goombaTh.join(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(JuegoPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            this.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    ///Hilo movimiento de los Goomba
    public class MyThread extends Thread {
        private JuegoPanel juego;

        public MyThread(JuegoPanel jp) {
            this.juego = jp;
        }
        
         public void run(){
            finalJuego = true;
            while(finalJuego){
                try {
                    Thread.sleep(300);
                    if (laberinto.obtenerNivel() == 3){
                        goomba2.stalker();
                        goomba2.comer(personaje.getX(), personaje.getY());
                        goomba.stalker();
                        goomba.comer(personaje.getX(), personaje.getY());
                    }else{
                        goomba.stalker();
                        goomba.comer(personaje.getX(), personaje.getY());
                    } 
                } catch (InterruptedException ex) {
                    Logger.getLogger(JuegoPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.juego.repaint();
            }
        }
         
         
    }
    
}
