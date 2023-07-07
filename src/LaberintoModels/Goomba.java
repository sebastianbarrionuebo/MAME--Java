
package LaberintoModels;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;


public class Goomba {
    private Laberinto lab;
    private ImageIcon img;
    private int x;
    private int y;
    private int xAtras;
    private int yAtras;
    private final int ancho;
    private final int alto;
    private final int movimiento;
    private Boolean direccion;
    private static Boolean comer = false;
    private static Boolean cambioDeEscenario = true;

    public Goomba(int x,int y, int xAt, int yAt, Laberinto labo) {
        this.lab = labo;
        this.img = new ImageIcon(getClass().getResource("/ImgsLaberinto/Goomba.png"));
        this.x = x;
        this.y = y;
        this.ancho = 40;
        this.alto = 40;
        this.movimiento = 40;
        this.xAtras = xAt;
        this.yAtras = yAt;
        this.direccion = true;
    }
    
    public void resetComer() {
        comer = false;
    }
    
    public void paintComponent(Graphics grafico) {
        grafico.drawImage(img.getImage(), x, y, alto, ancho, null);
    }
    
    public void stalker(){
        ArrayList lista = new ArrayList();
        int i = 0;
        int[][] laberinto = lab.obtenerLaberinto(lab.obtenerNivel());
        Random dados = new Random();

        if( (laberinto[ (y/40) + 1 ][ (x/40) ] != 1)  &&  !( (yAtras == (y+40)) && (xAtras == x) ) ){ /// Abajo
            lista.add("Abajo");
            i++;
        }
        if( (laberinto[ (y/40) - 1 ][ x/40 ] != 1)  &&  !( (yAtras == (y-40)) && (xAtras == x) ) ){ /// Arriba
            lista.add("Arriba");
            i++;
        }
        if( (laberinto[ y/40 ][ (x/40) + 1 ] != 1)  &&  !( (yAtras == y) && (xAtras == (x+40)) ) ){ /// Derecha
            lista.add("Derecha");
            i++;
        }
        if( (laberinto[ y/40 ][ (x/40) - 1 ] != 1)  &&  !( (yAtras == y) && (xAtras == (x-40)) ) ){ ///Izquierda
            lista.add("Izquierda");
            i++;
        }
        switch( (String) lista.get( dados.nextInt(0, i) ) ){
            case "Abajo":
                this.xAtras = this.x;
                this.yAtras= this.y;
                this.y = this.y + this.movimiento;
                if(this.direccion){
                    this.img = new ImageIcon(getClass().getResource("/ImgsLaberinto/Goomba.png"));
                    this.direccion = false;
                }else{
                    this.img = new ImageIcon(getClass().getResource("/ImgsLaberinto/Goomba2.png"));
                    this.direccion = true;
                }
            break;
            case "Arriba":
                this.xAtras = this.x;
                this.yAtras = this.y;
                this.y = this.y - this.movimiento;
                if(this.direccion){
                    this.img = new ImageIcon(getClass().getResource("/ImgsLaberinto/Goomba.png"));
                    this.direccion = false;
                }else{
                    this.img = new ImageIcon(getClass().getResource("/ImgsLaberinto/Goomba2.png"));
                    this.direccion = true;
                }
            break;
            case "Derecha":
                this.xAtras = this.x;
                this.yAtras = this.y;
                this.x = this.x + this.movimiento;
                if(this.direccion){
                    this.img = new ImageIcon(getClass().getResource("/ImgsLaberinto/Goomba.png"));
                    this.direccion = false;
                }else{
                    this.img = new ImageIcon(getClass().getResource("/ImgsLaberinto/Goomba2.png"));
                    this.direccion = true;
                }
            break;
            case "Izquierda":
                this.xAtras = this.x;
                this.yAtras = this.y;
                this.x = this.x - this.movimiento;
                if(this.direccion){
                    this.img = new ImageIcon(getClass().getResource("/ImgsLaberinto/Goomba.png"));
                    this.direccion = false;
                }else{
                    this.img = new ImageIcon(getClass().getResource("/ImgsLaberinto/Goomba2.png"));
                    this.direccion = true;
                }
            break;
            default:
                System.out.println("Error");
            break;
        }
    }

    public void comer(int xPers, int yPers){
        if( (this.x == xPers) && (this.y == yPers) ){ ///Ensima
            this.comer = true;
        }
        if( (this.x == xPers) && (this.y-40 == yPers) ){ ///Arriba
            this.comer = true;
        }
        if( (this.x == xPers) && (this.y+40 == yPers) ){ ///Abajo
            this.comer = true;
        }
        if( (this.x+40 == xPers) && (this.y == yPers) ){ ///Derecha
            this.comer = true;
        }
        if( (this.x-40 == xPers) && (this.y == yPers) ){ ///Izquierda
            this.comer = true;
        }
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static Boolean getComer() {
        return comer;
    }

    public static Boolean getCambioDeEscenario() {
        return cambioDeEscenario;
    }

    public static void setCambioDeEscenario(Boolean cambioDeEscenario) {
        Goomba.cambioDeEscenario = cambioDeEscenario;
    }
    
    
}
