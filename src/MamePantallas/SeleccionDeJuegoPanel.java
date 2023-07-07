
package MamePantallas;

import Usuario.Usuario;
import javax.swing.JFrame;


public class SeleccionDeJuegoPanel extends javax.swing.JPanel {
    
    private MameFrame mame;
   
    public SeleccionDeJuegoPanel(JFrame frame) {
        mame = (MameFrame) frame;
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSnake = new javax.swing.JButton();
        jButtonFrog = new javax.swing.JButton();
        jButtonPong = new javax.swing.JButton();
        jButtonMario = new javax.swing.JButton();
        jButtonRegresar = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(930, 560));

        jButtonSnake.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenBotones/BotonSnake.jpg"))); // NOI18N
        jButtonSnake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSnakeActionPerformed(evt);
            }
        });

        jButtonFrog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenBotones/BotonFrog.jpeg"))); // NOI18N
        jButtonFrog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFrogActionPerformed(evt);
            }
        });

        jButtonPong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenBotones/BotonPong.png"))); // NOI18N
        jButtonPong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPongActionPerformed(evt);
            }
        });

        jButtonMario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenBotones/BotonMario.jpg"))); // NOI18N
        jButtonMario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMarioActionPerformed(evt);
            }
        });

        jButtonRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenBotones/ea3c3491d5c3dd5.png"))); // NOI18N
        jButtonRegresar.setToolTipText("");
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(202, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonFrog, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSnake, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(132, 132, 132)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonMario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPong, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(196, 196, 196))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonMario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSnake, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonPong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFrog, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSnakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSnakeActionPerformed
        this.mame.deSeleccionJuegoToSnake();
    }//GEN-LAST:event_jButtonSnakeActionPerformed

    private void jButtonMarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMarioActionPerformed
        this.mame.inicMarioGame();
    }//GEN-LAST:event_jButtonMarioActionPerformed

    private void jButtonFrogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFrogActionPerformed
        this.mame.inicFrogGame();
    }//GEN-LAST:event_jButtonFrogActionPerformed

    private void jButtonPongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPongActionPerformed
        this.mame.deSeleccionJuegoToPong();
    }//GEN-LAST:event_jButtonPongActionPerformed

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        
        if(mame.getUserActivo().getTipo() == 1){
            this.mame.deSeleccionJuegoToLobyAdmin();
        }else{
            this.mame.deSeleccionJuegoToLobyUsuario();
        }
    }//GEN-LAST:event_jButtonRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFrog;
    private javax.swing.JButton jButtonMario;
    private javax.swing.JButton jButtonPong;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JButton jButtonSnake;
    // End of variables declaration//GEN-END:variables
}
