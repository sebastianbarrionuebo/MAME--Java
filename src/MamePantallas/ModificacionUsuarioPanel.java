
package MamePantallas;

import Usuario.ListaDeUsuarios;
import Usuario.Usuario;


public class ModificacionUsuarioPanel extends javax.swing.JPanel {
    private MameFrame mame;
    private Usuario userOn;

    public ModificacionUsuarioPanel(MameFrame frame, Usuario user) {
        initComponents();
        this.mame = frame;
        this.userOn = user;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CartelBienvenido = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NuevoNombre = new javax.swing.JTextField();
        NuevaPass = new javax.swing.JPasswordField();
        btnGuardarNombre = new javax.swing.JButton();
        btnGuardarPass = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        CartelBienvenido.setFont(new java.awt.Font("Playbill", 1, 48)); // NOI18N
        CartelBienvenido.setForeground(new java.awt.Color(255, 255, 255));
        CartelBienvenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CartelBienvenido.setText("Modificacion");
        CartelBienvenido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setText("Contraseña:");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel2.setText("Nombre:");

        NuevoNombre.setText("Nuevo nombre");
        NuevoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoNombreActionPerformed(evt);
            }
        });

        NuevaPass.setText("jPasswordField1");
        NuevaPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevaPassActionPerformed(evt);
            }
        });

        btnGuardarNombre.setText("Guardar Nombre");
        btnGuardarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarNombreActionPerformed(evt);
            }
        });

        btnGuardarPass.setText("Guardar pass");
        btnGuardarPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPassActionPerformed(evt);
            }
        });

        btnExit.setText("Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(CartelBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(237, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(148, 148, 148))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(NuevoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NuevaPass, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(btnGuardarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardarPass, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(390, 390, 390))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(CartelBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NuevoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NuevaPass, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(209, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardarPass, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 560));
    }// </editor-fold>//GEN-END:initComponents

    private void NuevoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NuevoNombreActionPerformed

    private void NuevaPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevaPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NuevaPassActionPerformed

    private void btnGuardarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarNombreActionPerformed
        //Validar nuevo usuario
        ListaDeUsuarios lista = this.mame.getListaUsuarios();
        String nombreNuevo = NuevoNombre.getText();
        Usuario user = lista.getUsuario(nombreNuevo);
        System.out.println(user);
        if( user == null ){
            System.out.println("HOLAAAAA");
            System.out.println(userOn.getNombre());
            lista.getLista().remove(userOn.getNombre());
            userOn.setNombre(nombreNuevo);
            lista.agregarUsuario(userOn);
        }else{
            System.out.println("USER existente");
        }
    }//GEN-LAST:event_btnGuardarNombreActionPerformed

    private void btnGuardarPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPassActionPerformed
        //Validar nuevo usuario
        String pass = new String(NuevaPass.getPassword());
        userOn.setClave(pass);
    }//GEN-LAST:event_btnGuardarPassActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        mame.deModificacionAPerfil();
    }//GEN-LAST:event_btnExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CartelBienvenido;
    private javax.swing.JPasswordField NuevaPass;
    private javax.swing.JTextField NuevoNombre;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGuardarNombre;
    private javax.swing.JButton btnGuardarPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
