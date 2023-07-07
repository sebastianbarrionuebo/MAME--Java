
package PingPong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class PuntuacionPong {

    private static int anchoPantalla;
    private static int altoPantalla;
    int jugador1, jugador2;
    
    
    public PuntuacionPong(int anchoPantalla, int altoPantalla){
        
            this.anchoPantalla = anchoPantalla;
            this.altoPantalla = altoPantalla;
            this.jugador1 = 0;
            this.jugador2 = 0;
        
    }
    
    public void dibujar(Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(new Font("DOUBLE",Font.PLAIN,60));
        
        g.setColor(Color.RED);
        g.drawString(String.valueOf(jugador1), (anchoPantalla/2)-55, 50);
        g.setColor(Color.BLUE);
        g.drawString(String.valueOf(jugador2), (anchoPantalla/2)+20, 50);        
        //RED   
        g.setColor(Color.WHITE);
        g.drawLine((anchoPantalla/2), 0, (anchoPantalla/2), altoPantalla);
    }
       
}
