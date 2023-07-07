
package MamePantallas;

import Usuario.Usuario;
import javax.swing.JFrame;



public class UsuarioEncontrado extends javax.swing.JPanel {
    MameFrame mame;
    Usuario encontrado;
    
    public UsuarioEncontrado(JFrame frame, Usuario encontrado) {
        this.mame = (MameFrame) frame;
        this.mame.add(this);
        initComponents();
        this.encontrado = encontrado;
        areaDeTexto.setText(encontrado.toString());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        areaDeTexto = new javax.swing.JTextArea();
        Exit = new javax.swing.JButton();
        ModificarEstado = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));

        areaDeTexto.setEditable(false);
        areaDeTexto.setColumns(20);
        areaDeTexto.setFont(new java.awt.Font("Poor Richard", 0, 24)); // NOI18N
        areaDeTexto.setRows(5);
        jScrollPane1.setViewportView(areaDeTexto);

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        ModificarEstado.setText("Modificar Estado");
        ModificarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ModificarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(153, 153, 153))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ModificarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139)
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        this.setVisible(false);
        this.mame.deBuscarUserALobyAdmin();
    }//GEN-LAST:event_ExitActionPerformed

    private void ModificarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarEstadoActionPerformed
        if(this.encontrado.getActivo() == 1){
            this.encontrado.setActivo(0);
        }else{
            this.encontrado.setActivo(1);
        }
        this.repaint();
    }//GEN-LAST:event_ModificarEstadoActionPerformed
  
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit;
    private javax.swing.JButton ModificarEstado;
    private javax.swing.JTextArea areaDeTexto;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    
}
