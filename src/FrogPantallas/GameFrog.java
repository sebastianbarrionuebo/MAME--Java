
package FrogPantallas;

import FrogModels.Car;
import FrogModels.Frog;
import FrogModels.Scenario;
import MamePantallas.MameFrame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class GameFrog extends JPanel implements KeyListener, ActionListener {
    
    private Car car1 = new Car(840, 280, "izq", "/FrogAssets/auto3.png", 80, "auto");
    private Car car2 = new Car(0, 320, "der", "/FrogAssets/camion1.png", 120, "auto");
    private Car car3 = new Car(840, 360, "izq", "/FrogAssets/auto2.png", 80, "auto");
    private Car car4 = new Car(0, 400, "der", "/FrogAssets/auto1.png", 80, "auto");
    private Car car5 = new Car(800, 440, "izq", "/FrogAssets/camion2.png", 120, "auto");

    private Car car1b = new Car(320, 280, "izq", "/FrogAssets/auto3.png", 80, "auto");
    private Car car2b = new Car(160, 320, "der", "/FrogAssets/camion1.png", 120, "auto");
    private Car car3b = new Car(360, 360, "izq", "/FrogAssets/auto2.png", 80, "auto");
    private Car car4b = new Car(240, 400, "der", "/FrogAssets/auto1.png", 80, "auto");
    private Car car5b = new Car(400, 440, "izq", "/FrogAssets/camion2.png", 120, "auto");

    private Car car1c = new Car(480, 280, "izq", "/FrogAssets/auto3.png", 80, "auto");
    private Car car4c = new Car(360, 400, "der", "/FrogAssets/auto1.png", 80, "auto");

    private Car troncoA = new Car(760, 40, "der", "/FrogAssets/tronco.png", 120, "tronco");
    private Car troncoB = new Car(0, 80, "izq", "/FrogAssets/tronco.png", 120, "tronco");
    private Car troncoC = new Car(840, 120, "der", "/FrogAssets/tronco.png", 120, "tronco");
    private Car troncoD = new Car(0, 160, "izq", "/FrogAssets/tronco.png", 120, "tronco");
    private Car troncoE = new Car(800, 200, "der", "/FrogAssets/tronco.png", 120, "tronco");

    private Car troncoA2 = new Car(200, 40, "der", "/FrogAssets/tronco.png", 120, "tronco");
    private Car troncoB2 = new Car(440, 80, "izq", "/FrogAssets/tronco.png", 120, "tronco");
    private Car troncoC2 = new Car(520, 120, "der", "/FrogAssets/tronco.png", 120, "tronco");
    private Car troncoD2 = new Car(400, 160, "izq", "/FrogAssets/tronco.png", 120, "tronco");
    private Car troncoE2 = new Car(200, 200, "der", "/FrogAssets/tronco.png", 120, "tronco");

    private Car troncoA3 = new Car(600, 40, "der", "/FrogAssets/tronco.png", 120, "tronco");
    private Car troncoC3 = new Car(640, 120, "der", "/FrogAssets/tronco.png", 120, "tronco");
    private Car troncoE3 = new Car(560, 200, "der", "/FrogAssets/tronco.png", 120, "tronco");

    private Car troncoE4 = new Car(240, 120, "der", "/FrogAssets/tronco.png", 120, "tronco");

    private Frog frog = new Frog();
    private Scenario scenario = new Scenario();
    private int interactMatrix[][];
    private MyThread hiloObstaculo;
    private Boolean bool;
    private MameFrame mame;
    private int finalSpace[];

    public GameFrog(MameFrame frame) {
        this.mame = frame;

        this.addKeyListener((KeyListener) this);
        this.setPreferredSize(new Dimension(930, 560));
        this.setVisible(true);
        this.setFocusable(true);

        int matrix[][]
                = {
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                };
        interactMatrix = matrix;
        bool = true;
        //finalSpace = scenario.randomFrogs();
    }

    @Override
    public void paint(Graphics g) {
        if (frogStillAlive(frog) == false) {
            frog.frogDead();
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(100);
                    this.repaint();
                }
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(GameFrog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            frog.frogRevive();
        } else if ((frog.getLife() <= 0) || frog.winFrog()){
            frog.puntajeFinal();
            mame.deFrogAMuerte();
            bool = false;
            try {
                hiloObstaculo.join(500);
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(GameFrog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            
        }
        scenario.paint(g);

        //this.paintFrogs(g);
        
        troncoA.paint(g);
        troncoB.paint(g);
        troncoC.paint(g);
        troncoD.paint(g);
        troncoE.paint(g);
        troncoA2.paint(g);
        troncoB2.paint(g);
        troncoC2.paint(g);
        troncoD2.paint(g);
        troncoE2.paint(g);
        troncoA3.paint(g);
        troncoE3.paint(g);
        troncoE4.paint(g);

        frog.paint(g, interactMatrix);

        car1.paint(g);
        car2.paint(g);
        car3.paint(g);
        car4.paint(g);
        car5.paint(g);
        car1b.paint(g);
        car2b.paint(g);
        car3b.paint(g);
        car4b.paint(g);
        car5b.paint(g);
        car1c.paint(g);
        car4c.paint(g);
    }

    public void initGame() {
        hiloObstaculo = new MyThread(this);
        hiloObstaculo.start();
    }

    public int[][] getInteractMatrix() {
        return interactMatrix;
    }

    ;
    
    public Boolean frogStillAlive(Frog frog) {
        Boolean alive = true;
        if (interactMatrix[frog.getY() / 40][frog.getX() / 40] == 1) {
            alive = false;
        }
        return alive;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        frog.control(e, scenario, interactMatrix);
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public class MyThread extends Thread {

        private GameFrog game;

        public MyThread(GameFrog game) {
            this.game = game;
        }

        public void run() {
            System.out.println(bool+"");
            while (bool) {
                try {
                    Thread.sleep(5);
                    car1.move(interactMatrix);
                    car2.move(interactMatrix);
                    car3.move(interactMatrix);
                    car4.move(interactMatrix);
                    car5.move(interactMatrix);
                    car1b.move(interactMatrix);
                    car2b.move(interactMatrix);
                    car3b.move(interactMatrix);
                    car4b.move(interactMatrix);
                    car5b.move(interactMatrix);
                    car1c.move(interactMatrix);
                    car4c.move(interactMatrix);

                    troncoA.move(interactMatrix);
                    troncoB.move(interactMatrix);
                    troncoC.move(interactMatrix);
                    troncoD.move(interactMatrix);
                    troncoE.move(interactMatrix);
                    troncoA2.move(interactMatrix);
                    troncoB2.move(interactMatrix);
                    troncoC2.move(interactMatrix);
                    troncoD2.move(interactMatrix);
                    troncoE2.move(interactMatrix);
                    troncoA3.move(interactMatrix);
                    troncoE3.move(interactMatrix);
                    troncoE4.move(interactMatrix);
                    
                    frog.frogTronco(interactMatrix);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                this.game.repaint();
            }
        }
    }
    public void resetGame(){
        Frog newF = new Frog();
        this.frog = newF;
        this.bool = true;
        this.initGame();
    };
    public void paintFrogs(Graphics g){
        ImageIcon imgFrog = new ImageIcon(getClass().getResource("/FrogAssets/ranaAbajo1.png"));
        for (int i = 0; i < 7; i++) {
            if(i == 6){
                imgFrog = new ImageIcon(getClass().getResource("/FrogAssets/mosca.png"));
            }
            switch (finalSpace[i]) {
                case 2:
                    g.drawImage(imgFrog.getImage(), 120, 0, 40, 40, null);
                    break;
                case 5:
                    g.drawImage(imgFrog.getImage(), 240, 0, 40, 40, null);
                    break;
                case 9:
                    g.drawImage(imgFrog.getImage(), 400, 0, 40, 40, null);
                    break;
                case 12:
                    g.drawImage(imgFrog.getImage(), 520, 0, 40, 40, null);
                    break;
                case 15:
                    g.drawImage(imgFrog.getImage(), 640, 0, 40, 40, null);
                    break;
                case 19:
                    g.drawImage(imgFrog.getImage(), 800, 0, 40, 40, null);
                    break;
                default:
                    throw new AssertionError();
            }
        }
        
    }
}
