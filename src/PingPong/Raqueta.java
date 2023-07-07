package PingPong;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Raqueta extends Rectangle {

    private int id;
    private int yVelocidad;
    private int velocidad = 5;

    public Raqueta(int x, int y, int anchoPaleta, int altoPaleta, int id) {
        super(x, y, anchoPaleta, altoPaleta);
        this.id = id;
    }

    public void teclaPrecionada(KeyEvent e) {

        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setMovimientoEnY(-this.velocidad);
                    movimiento();
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    setMovimientoEnY(this.velocidad);
                    movimiento();
                }
                break;

            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setMovimientoEnY(-this.velocidad);
                    movimiento();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setMovimientoEnY(this.velocidad);
                    movimiento();
                }
                break;
        }
    }

    public void teclaSoltada(KeyEvent e) {

        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setMovimientoEnY(0);
                    movimiento();
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    setMovimientoEnY(0);
                    movimiento();
                }
                break;

            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setMovimientoEnY(0);
                    movimiento();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setMovimientoEnY(0);
                    movimiento();
                }
                break;
        }
    }

    public void setMovimientoEnY(int direccionY) {
        this.yVelocidad = direccionY;
    }

    public void movimiento() {
        y += yVelocidad;
    }

    public void dibujar(Graphics g) {
        if (id == 1) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.BLUE);
        }
        g.fillRect(x, y, width, height);
    }

}
