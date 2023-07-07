
package LaberintoModels;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Mario {
    private Laberinto lab;
    private ImageIcon img;
    private int x;
    private int y;
    private boolean caminando;
    private boolean direccion;
    private final int ancho;
    private final int alto;
    private final int movimiento;
    private static Boolean muerto = false;

    public Mario(Laberinto labo) {
        this.lab = labo;
        this.img = new ImageIcon(getClass().getResource("/ImgsLaberinto/Mario3D.png"));
        this.x = 40;
        this.y = 40;
        this.caminando = true;
        this.direccion = true;
        this.ancho = 40;
        this.alto = 40;
        this.movimiento = 40;
    }

    public void paintComponent(Graphics grafico) {
        grafico.drawImage(img.getImage(), x, y, ancho, alto, null);
    }

    public static Boolean getMuerto() {
        return muerto;
    }

    public static void setMuerto(Boolean muerto) {
        Mario.muerto = muerto;
    }

    
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void teclaTocada(KeyEvent evento) {
        int[][] laverinto = lab.obtenerLaberinto(lab.obtenerNivel());
        if (evento.getKeyCode() == 37) { ///Izquierda
            if (laverinto[y / 40][(x / 40) - 1] != 1) {
                x = x - movimiento;
            }
            if (caminando) {
                ImageIcon imgI = new ImageIcon(getClass().getResource("/ImgsLaberinto/Mario3I.png"));
                img = imgI;
                caminando = false;
            } else {
                ImageIcon imgIC = new ImageIcon(getClass().getResource("/ImgsLaberinto/Mario3IC.png"));
                img = imgIC;
                caminando = true;
            }
            direccion = false;
        }
        if (evento.getKeyCode() == 39) { ///Derecha
            if (laverinto[y / 40][(x / 40) + 1] != 1) {
                x = x + movimiento;
            }
            if (caminando) {
                ImageIcon imgD = new ImageIcon(getClass().getResource("/ImgsLaberinto/Mario3D.png"));
                img = imgD;
                caminando = false;
            } else {
                ImageIcon imgDC = new ImageIcon(getClass().getResource("/ImgsLaberinto/Mario3DC.png"));
                img = imgDC;
                caminando = true;
            }
            direccion = true;
        }
        if (evento.getKeyCode() == 40) { ///Abajo
            if (laverinto[(y / 40) + 1][x / 40] != 1) {
                y = y + movimiento;
            }
            if (direccion) {
                if (caminando) {
                    ImageIcon imgD = new ImageIcon(getClass().getResource("/ImgsLaberinto/Mario3D.png"));
                    img = imgD;
                    caminando = false;
                } else {
                    ImageIcon imgDC = new ImageIcon(getClass().getResource("/ImgsLaberinto/Mario3DC.png"));
                    img = imgDC;
                    caminando = true;
                }
            } else {
                if (caminando) {
                    ImageIcon imgI = new ImageIcon(getClass().getResource("/ImgsLaberinto/Mario3I.png"));
                    img = imgI;
                    caminando = false;
                } else {
                    ImageIcon imgIC = new ImageIcon(getClass().getResource("/ImgsLaberinto/Mario3IC.png"));
                    img = imgIC;
                    caminando = true;
                }
            }
        }
        if (evento.getKeyCode() == 38) { ///Arriba
            if (laverinto[(y / 40) - 1][x / 40] != 1) {
                y = y - movimiento;
            }
            if (direccion) {
                if (caminando) {
                    ImageIcon imgD = new ImageIcon(getClass().getResource("/ImgsLaberinto/Mario3D.png"));
                    img = imgD;
                    caminando = false;
                } else {
                    ImageIcon imgDC = new ImageIcon(getClass().getResource("/ImgsLaberinto/Mario3DC.png"));
                    img = imgDC;
                    caminando = true;
                }
            } else {
                if (caminando) {
                    ImageIcon imgI = new ImageIcon(getClass().getResource("/ImgsLaberinto/Mario3I.png"));
                    img = imgI;
                    caminando = false;
                } else {
                    ImageIcon imgIC = new ImageIcon(getClass().getResource("/ImgsLaberinto/Mario3IC.png"));
                    img = imgIC;
                    caminando = true;
                }
            }
        }
        if (lab.obtenerNivel() == 1) {
            if (x == 840 && y == 440) {
                lab.siguienteNivel();
                x = 40;
                y = 40;
            }
        } else if (lab.obtenerNivel() == 2) {
            if (x == 720 && y == 40) {
                lab.siguienteNivel();
                x = 40;
                y = 40;
            }
        } else if (lab.obtenerNivel() == 3) {
            if (x == 440 && y == 240) {
                lab.siguienteNivel();
                x = 40;
                y = 40;
            }
        }
    }
}
