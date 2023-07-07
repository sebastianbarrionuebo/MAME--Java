package Snake;

import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;

public class Manzana {

    private int x;
    private int y;
    private int puntos;
    private ImageIcon imagen;
    private boolean dorada;
    private Random rand = new Random();

    public Manzana(int totalCuadritosX,int totalCuadritosY, int cuadritoSize) {
        this.x = rand.nextInt(0, totalCuadritosX)*cuadritoSize;
        this.y = rand.nextInt(0, totalCuadritosY)*cuadritoSize;
    }

    public void doradaORoja(int totalCuadritosX,int totalCuadritosY, int cuadritoSize, List<Snake> snake) {
        int i = 0;
        System.out.println("posicion en x: "+ this.x + "  posicion en y:"+ this.y);
        while(i < snake.size()){
            if(snake.get(i).getX() == this.x && snake.get(i).getY() == this.y){
                this.x = rand.nextInt(0, totalCuadritosX)*cuadritoSize;
                this.y = rand.nextInt(0, totalCuadritosY)*cuadritoSize;
            }
            i++;
        }
        int probabilidad = rand.nextInt(0, 101);
        if (probabilidad <= 15) {
            this.imagen = new ImageIcon(getClass().getResource("/ImagenesSnake/MDorada.png"));
            this.puntos = 20;
            this.dorada = true;
        } else {
            this.imagen = new ImageIcon(getClass().getResource("/ImagenesSnake/MRoja.png"));
            this.puntos = 10;
            this.dorada = false;
        }

    }

    public boolean isDorada() {
        return dorada;
    }

    public void setDorada(boolean dorada) {
        this.dorada = dorada;
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

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }
}
