
package LaberintoPantallas;

import MamePantallas.MameFrame;
import Usuario.Usuario;
import com.sun.tools.javac.Main;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MuertoPanel extends JPanel implements MouseListener {
    
    private ImageIcon fondo = new ImageIcon(getClass().getResource("/ImgsLaberinto/PantallaMuerto.png"));
    private ImageIcon replayBoton = new ImageIcon(getClass().getResource("/ImgsLaberinto/ReplayBoton.png"));
    private ImageIcon salirBoton = new ImageIcon(getClass().getResource("/ImgsLaberinto/ExitBoton.png"));
    private int alto = 930;
    private int ancho = 560;
    private MameFrame frame;
    private Usuario user = new Usuario();

    
     public MuertoPanel(JFrame frame) {
        this.frame = (MameFrame) frame;
        System.out.println("Morto dambre");
        this.setVisible(false);
        this.setPreferredSize(new Dimension(930,560));
        this.setLocation(300,200);
        addMouseListener(this);
    }
    
    public String getName() {
        return "morto";
    }
    
    @Override
    public void paintComponent(Graphics grafico){
        System.out.println("Pinta Morto dambre");
        //super.paintComponent(grafico);
        grafico.drawImage(fondo.getImage(), 0, 0, alto, ancho, null);
        grafico.drawImage(replayBoton.getImage(), 600, 320, 200, 40, null);
        grafico.drawImage(salirBoton.getImage(), 600, 380, 200, 40, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
         Point p = e.getPoint();
         if (p.x > 602 && p.x < 796
             && p.y > 323 && p.y < 356){
            this.frame.replayJuegoLab(false);
         } else if (p.x > 602 && p.x < 796
             && p.y > 382 && p.y < 414) {
            this.frame.onExitLab(false);
         }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
