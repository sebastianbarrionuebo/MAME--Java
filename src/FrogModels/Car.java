
package FrogModels;

import java.awt.Graphics;
import javax.swing.ImageIcon;


public class Car {

    private String color;
    private int x;
    private int y;
    private int originalX;
    private String sentido;
    private int movement;
    private int high;
    private int width;
    private ImageIcon img;
    private int matriX;
    private int matriY;
    private String tipo;
    private int contadorMov;
    private int contTronco;

    public Car() {
    }

    public Car(Integer x, Integer y, String sentido, String img, int width, String tipo) {
        this.x = x;
        this.y = y;
        originalX = x;
        this.sentido = sentido;
        this.img = new ImageIcon(getClass().getResource(img));
        this.high = 40;
        this.width = width;
        this.tipo = tipo;
        this.contadorMov = 0;
        contTronco = 0;
    }

    public String getColor() {
        return color;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public String getSentido() {
        return sentido;
    }

    public Integer getMovement() {
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

    public void setSentido(String sentido) {
        this.sentido = sentido;
    }

    public void setMovement(Integer movement) {
        this.movement = movement;
    }

    public void paint(Graphics graphic) {
        graphic.drawImage(img.getImage(), x, y, width, high, null);
    }

    public void move(int matrix[][]) {
        Integer modPos = 0;
        Integer modMap = 0;

        if (this.tipo == "auto") {
            modPos = 1;
            modMap = 0;
        } else {
            modPos = 2;
            modMap = 1;
            contTronco += 1;
        }
        if (sentido == "der") {
            if (((x / 40) >= 0) && ((x / 40) <= 22)) { //limite
                if (width == 80) {
                    matrix[y / 40][x / 40] = modMap; //nueva posicion
                    if (((x / 40) + 1) <= 22) {
                        matrix[y / 40][(x / 40) + 1] = modPos;
                    }
                    if (((x / 40) + 2) <= 22) {
                        matrix[y / 40][(x / 40) + 2] = modPos;
                    }
                } else {
                    if (((((x / 40) + 3) <= 22) && (this.tipo == "tronco") && (contTronco == 5)) || (((x / 40) + 3) <= 22) && (this.tipo == "auto")) {

                        matrix[y / 40][(x / 40)] = modMap;
                        if (((x / 40) + 1) <= 22) {
                            matrix[y / 40][((x / 40) + 1)] = modPos;
                        }
                        if (((x / 40) + 2) <= 22) {
                            matrix[y / 40][((x / 40) + 2)] = modPos;
                        }
                        if (((x / 40) + 3) <= 22) {
                            matrix[y / 40][((x / 40) + 3)] = modPos;
                        }
                    }
                }
            }
            if ((x / 40) == 22) {
                x = 0;
            } else {
                if (((this.tipo == "tronco") && (contTronco == 5)) || (this.tipo == "auto")) {
                    x += 1;
                    contTronco = 0;
                }
            }
        } else {//izq
            if (((x / 40) >= 0) && ((x / 40) <= 22)) {
                if (width == 80) {
                    if (((((x / 40) + 1) >= 0) && ((x / 40) <= 22))) { //nueva posicion
                        if (((x / 40) + 2) <= 22) {
                            matrix[y / 40][(x / 40) + 2] = modMap;
                        }
                        if (((x / 40) + 1) <= 22) {
                            matrix[y / 40][(x / 40) + 1] = modPos;
                        }
                        matrix[y / 40][(x / 40)] = modPos;
                    }
                } else {
                    if ((((x / 40) + 2) >= 0 && (this.tipo == "tronco") && (contTronco == 5)) || (((x / 40) + 3) <= 22) && (this.tipo == "auto")) {
                        matrix[y / 40][(x / 40)] = modPos;
                        if (((x / 40) + 1) <= 22) {
                            matrix[y / 40][((x / 40) + 1)] = modPos;
                        }
                        if (((x / 40) + 2) <= 22) {
                            matrix[y / 40][((x / 40) + 2)] = modPos;
                        }
                        if (((x / 40) + 3) <= 22) {
                            matrix[y / 40][((x / 40) + 3)] = modMap;
                        }
                    }
                }
            }
            if ((x / 40) == 0) {
                x = 800;
            } else {
                if (((this.tipo == "tronco") && (contTronco == 5)) || (this.tipo == "auto")) {
                    x -= 1;
                    contTronco = 0;
                }
            }
        }

    }
;
};
