
package LaberintoModels;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;


public class Laberinto {
    private int fila;
    private int columna;
    private final int numFilas;
    private final int numCol;
    private final int anchoBloque;
    private final int altoBloque;
    private static int nivel;
    
    public Laberinto(){
        this.fila = 0;
        this.columna = 0;
        this.numFilas = 14;
        this.numCol = 23;
        this.anchoBloque = 40;
        this.altoBloque = 40;
        this.nivel = 1;
    }
    
    public void paintComponent(Graphics grafico){
        int[][]laberinto = obtenerLaberinto(nivel);
        
        for(fila = 0; fila< numFilas; fila++){
            for(columna = 0; columna< numCol; columna++){
                if(laberinto[fila][columna] == 1){
                    ImageIcon Img = new ImageIcon(getClass().getResource("/ImgsLaberinto/Bloques.png"));
                    grafico.drawImage(Img.getImage(), columna*40, fila*40, anchoBloque, altoBloque, null);
                   
                }
                if(laberinto[fila][columna] == 0){
                    grafico.setColor(Color.LIGHT_GRAY);
                    grafico.fillRect(columna*40, fila*40, anchoBloque, altoBloque);
                }
                if(laberinto[fila][columna] == 2){
                    grafico.setColor(Color.LIGHT_GRAY);
                    grafico.fillRect(columna*40, fila*40, anchoBloque, altoBloque);
                    ImageIcon Img = new ImageIcon(getClass().getResource("/ImgsLaberinto/Hongo.png"));
                    grafico.drawImage(Img.getImage(), columna*40, fila*40, anchoBloque, altoBloque, null);
                }
            }
        }
    }
    
    public static void siguienteNivel(){
        Laberinto.nivel = Laberinto.nivel + 1;
    }

    public static void setNivel(int nivel) {
        Laberinto.nivel = nivel;
    }
    
    public int obtenerNivel(){
        return nivel;
    }
    
    public int[][] obtenerLaberinto(int nivel){
        int lab[][] = new int[14][23];
        if(nivel == 1){
            int laberinto[][] =
            {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                { 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                { 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
                { 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1},
                { 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1},
                { 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1},
                { 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1},
                { 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1},
                { 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1},
                { 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                { 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1},
                { 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 2, 1},
                { 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
            };
            lab = laberinto;
        }else if (nivel == 2){
                int laberinto [][]=
                {
                    { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                    { 1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,2,0,0,1,1},
                    { 1,0,1,0,1,0,1,0,0,1,1,0,0,0,1,1,1,1,1,1,0,1,1},
                    { 1,0,0,0,1,0,1,0,1,1,0,0,1,0,1,1,0,0,0,1,0,1,1},
                    { 1,1,0,1,1,0,1,0,1,0,0,1,1,0,1,0,0,1,0,1,0,1,1},
                    { 1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,1,1,0,1,0,1,1},
                    { 1,1,1,0,1,0,1,0,1,1,0,0,0,0,1,0,1,1,0,1,0,1,1},
                    { 1,1,0,0,1,0,0,0,0,1,0,1,1,1,0,0,1,0,0,1,0,1,1},
                    { 1,0,0,1,1,0,0,1,0,1,0,0,0,0,0,1,0,0,1,1,0,1,1},
                    { 1,0,1,1,0,0,1,1,0,1,0,1,1,0,1,0,0,1,0,0,0,1,1},
                    { 1,0,0,0,0,1,1,1,0,1,0,0,0,0,1,0,0,0,0,1,0,0,1},
                    { 1,1,0,1,0,0,0,0,0,0,0,1,1,0,1,1,0,0,0,1,0,0,1},
                    { 1,1,0,0,0,1,1,1,1,0,0,0,0,0,1,1,1,1,1,1,1,1,1},
                    { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                };
                lab = laberinto;
        }else if(nivel == 3){
                int laberinto [][]=
                {
                    { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                    { 1,0,0,0,0,1,1,0,0,0,0,0,1,1,1,1,0,0,0,0,0,1,1},
                    { 1,0,0,0,0,1,1,0,1,1,1,0,0,0,0,0,0,1,1,1,0,1,1},
                    { 1,1,0,1,0,1,1,0,1,1,0,0,1,0,1,1,0,0,0,0,0,1,1},
                    { 1,1,0,1,0,0,1,0,1,0,0,1,1,0,0,0,0,1,0,1,1,1,1},
                    { 1,1,0,1,0,0,1,0,0,0,1,0,0,1,1,1,1,1,0,0,1,1,1},
                    { 1,0,0,1,1,1,1,0,0,1,1,2,0,0,1,0,0,1,1,0,0,1,1},
                    { 1,0,0,1,1,1,1,0,0,1,1,1,1,0,1,0,0,0,0,0,0,1,1},
                    { 1,1,0,0,0,1,1,0,0,1,0,0,1,0,1,1,1,0,1,1,0,1,1},
                    { 1,0,0,1,0,0,1,1,0,1,0,0,1,0,1,1,0,0,1,1,0,1,1},
                    { 1,0,1,1,1,0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,1},
                    { 1,0,0,1,0,0,0,1,0,0,0,1,1,1,0,0,0,0,0,0,0,1,1},
                    { 1,1,0,0,0,1,0,0,0,0,1,1,1,1,1,1,1,1,0,0,1,1,1},
                    { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                };
                lab = laberinto;
        }
        return lab;
    };
}

