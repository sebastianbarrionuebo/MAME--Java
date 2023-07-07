
package Usuario;

import java.awt.List;
import java.io.Serializable;


public class Tienda implements Serializable{
    private int  colorTableroSN;
    private int  colorSnake;
    private int  colorTableroPN;
    private int  colorPelota;
    private int  colorFrog;

    public Tienda() {
        colorTableroSN = 1;
        colorSnake = 1;
        colorTableroPN = 1;
        colorPelota = 1;
        colorFrog = 1;
    }

    public Tienda(int colorTableroSN, int colorSnake, int colorTableroPN, int colorPelota, int colorFrog) {
        /*
        this.colorTableroSN = colorTableroSN;
        this.colorSnake = colorSnake;
        this.colorTableroPN = colorTableroPN;
        this.colorPelota = colorPelota;
        this.colorFrog = colorFrog;
        */
    }
    /*
    public int getColorTableroSN() {
        return colorTableroSN;
    }

    public void setColorTableroSN(int colorTableroSN) {
        this.colorTableroSN = colorTableroSN;
    }

    public int getColorSnake() {
        return colorSnake;
    }

    public void setColorSnake(int colorSnake) {
        this.colorSnake = colorSnake;
    }

    public int getColorTableroPN() {
        return colorTableroPN;
    }

    public void setColorTableroPN(int colorTableroPN) {
        this.colorTableroPN = colorTableroPN;
    }

    public int getColorPelota() {
        return colorPelota;
    }

    public void setColorPelota(int colorPelota) {
        this.colorPelota = colorPelota;
    }

    public int getColorFrog() {
        return colorFrog;
    }

    public void setColorFrog(int colorFrog) {
        this.colorFrog = colorFrog;
    }
    */
}
