
package FrogModels;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;


public class Frog {
  
    private String color;
    private int x;
    private int y;
    private int movement;
    private int walk;
    private Boolean direccion;
    private int high;
    private int weigh;
    private int life;
    private ImageIcon img = new ImageIcon(getClass().getResource("/FrogAssets/ranaArriba1.png"));
    private int contTronco;
    private int puntaje;

    public Frog() {
        x = 440;
        y = 480;
        high = 40;
        weigh = 40;
        walk = 0;
        direccion = true;
        movement = 40;
        life = 4;
        contTronco = 0;
        puntaje = 0;
    }

    public Frog(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public String getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMovement() {
        return movement;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void setMovement(Integer movement) {
        this.movement = movement;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void paint(Graphics graphic, int peligro[][]) {
        graphic.drawImage(img.getImage(), x, y, high, weigh, null);
    }

    public void control(KeyEvent e, Scenario scenario, int peligro[][]) {
        int[][] screen = scenario.getScenario();

        if (e.getKeyCode() == 37) { ///Izquierda
            if ((screen[y / 40][(x / 40) - 1] != 1) || (peligro[y / 40][(x / 40) - 1] == 2)) {
                x = x - movement;
            }
            if (direccion) {
                if (walk == 0) {
                    ImageIcon imgD = new ImageIcon(getClass().getResource("/FrogAssets/ranaIzq1.png"));
                    img = imgD;
                    walk = 1;
                } else if (walk == 1) {
                    ImageIcon imgDC = new ImageIcon(getClass().getResource("/FrogAssets/ranaIzq2.png"));
                    img = imgDC;
                    walk = 2;
                } else {
                    ImageIcon imgDC = new ImageIcon(getClass().getResource("/FrogAssets/ranaIzq3.png"));
                    img = imgDC;
                    walk = 0;
                }
            }
        }
        if (e.getKeyCode() == 39) { ///Derecha
            if ((screen[y / 40][(x / 40) + 1] != 1) || (peligro[y / 40][(x / 40) + 1] == 2)) {
                x = x + movement;
            }
            if (direccion) {
                if (walk == 0) {
                    ImageIcon imgD = new ImageIcon(getClass().getResource("/FrogAssets/ranaDer1.png"));
                    img = imgD;
                    walk = 1;
                } else if (walk == 1) {
                    ImageIcon imgDC = new ImageIcon(getClass().getResource("/FrogAssets/ranaDer2.png"));
                    img = imgDC;
                    walk = 2;
                } else {
                    ImageIcon imgDC = new ImageIcon(getClass().getResource("/FrogAssets/ranaDer3.png"));
                    img = imgDC;
                    walk = 0;
                }
            }
        }
        if (e.getKeyCode() == 40) { ///Abajo
            if ((screen[(y / 40) + 1][x / 40] != 1) || (peligro[(y / 40) + 1][x / 40] == 2)) {
                y = y + movement;
            }
            if (direccion) {
                if (walk == 0) {
                    ImageIcon imgD = new ImageIcon(getClass().getResource("/FrogAssets/ranaAbajo1.png"));
                    img = imgD;
                    walk = 1;
                } else if (walk == 1) {
                    ImageIcon imgDC = new ImageIcon(getClass().getResource("/FrogAssets/ranaAbajo2.png"));
                    img = imgDC;
                    walk = 2;
                } else {
                    ImageIcon imgDC = new ImageIcon(getClass().getResource("/FrogAssets/ranaAbajo3.png"));
                    img = imgDC;
                    walk = 0;
                }
            }
        }
        if (e.getKeyCode() == 38) { ///Arriba
            if (((screen[(y / 40) - 1][x / 40] != 1) && (screen[(y / 40) - 1][x / 40] != 4)) || (peligro[(y / 40) - 1][x / 40] == 2)) {
                y = y - movement;
            }
            if (direccion) {
                if (walk == 0) {
                    ImageIcon imgD = new ImageIcon(getClass().getResource("/FrogAssets/ranaArriba1.png"));
                    img = imgD;
                    walk = 1;
                } else if (walk == 1) {
                    ImageIcon imgDC = new ImageIcon(getClass().getResource("/FrogAssets/ranaArriba2.png"));
                    img = imgDC;
                    walk = 2;
                } else {
                    ImageIcon imgDC = new ImageIcon(getClass().getResource("/FrogAssets/ranaArriba3.png"));
                    img = imgDC;
                    walk = 0;
                }
            }
        }
    }

    public void frogDead() {
        ImageIcon imgD = new ImageIcon(getClass().getResource("/FrogAssets/muerte.png"));
        this.img = imgD;
        life -= 1;
        System.out.println("life:" + life);
    }

    public void frogTronco(int m[][]) {
        int mod = 0;
        if ((this.y / 40 == 1) || (this.y / 40 == 3) || (y / 40 == 5)) {
            mod = 1;
        } else {
            mod = -1;
        }

        if (m[this.y / 40][this.x / 40] == 2) {
            if (contTronco == 4) {
                x += mod;
                contTronco = 0;
            } else {
                contTronco++;
            }
        }
    }

    public void frogRevive() {
        ImageIcon imgD = new ImageIcon(getClass().getResource("/FrogAssets/ranaArriba1.png"));
        this.img = imgD;
        this.x = 440;
        this.y = 480;
    }

    public boolean winFrog() {
        boolean bool = false;
        Scenario scenario = new Scenario();
        int screen[][] = scenario.getScenario();
        if (screen[this.y / 40][this.x / 40] == 3) {
            bool = true;
        }
        return bool;
    }
    public Boolean frogStillAlive(int m[][]) {
        Boolean alive = true;
        if ((m[this.y / 40][this.x / 40] == 1) && (m[this.y / 40][(this.x / 40) +1] != 2) && (m[this.y / 40][(this.x / 40)-1] != 2)){
            alive = false;
        }
        return alive;
    }
    public void puntajeFinal(){
        puntaje += y -  480;
        puntaje += life *  20;
    }
}
