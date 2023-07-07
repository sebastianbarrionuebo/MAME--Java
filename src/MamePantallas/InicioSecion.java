package MamePantallas;

import Usuario.ListaDeUsuarios;
import Usuario.Usuario;
import javax.swing.JOptionPane;


public class InicioSecion extends javax.swing.JPanel{
    private MameFrame mame;
    private ListaDeUsuarios ListaUsuarios;

    
    public InicioSecion(MameFrame frame) {
        initComponents();
        mame = (MameFrame)frame;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UsuarioString = new javax.swing.JTextField();
        CrearUsuario = new javax.swing.JButton();
        Inicio = new javax.swing.JButton();
        ContraseniaString = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(930, 560));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UsuarioString.setText("Usuario");
        UsuarioString.setPreferredSize(new java.awt.Dimension(100, 50));
        UsuarioString.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioStringActionPerformed(evt);
            }
        });
        add(UsuarioString, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 170, 30));

        CrearUsuario.setText("Crear usuario");
        CrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearUsuarioActionPerformed(evt);
            }
        });
        add(CrearUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 190, 40));

        Inicio.setText("Iniciar");
        Inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicioActionPerformed(evt);
            }
        });
        add(Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 190, 40));

        ContraseniaString.setText("jPasswordField1");
        ContraseniaString.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContraseniaStringActionPerformed(evt);
            }
        });
        add(ContraseniaString, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 170, 30));

        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, 190, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgsLaberinto/Logo-mame.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 800, 300));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgsLaberinto/FondoInicioEspacio.gif"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(930, 560));
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 560));
    }// </editor-fold>//GEN-END:initComponents

    private void UsuarioStringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioStringActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioStringActionPerformed

    private void CrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearUsuarioActionPerformed
        this.mame.deInicioDeSecionACrearUser();
    }//GEN-LAST:event_CrearUsuarioActionPerformed

    private void InicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioActionPerformed
        ///Inicio
        String pass = new String(ContraseniaString.getPassword());
        Usuario user = this.mame.validarUsuario( UsuarioString.getText() , pass);
        if( user != null ){
            if(user.getTipo() == 1){
                this.mame.deInicioSecionALobyAdmin();
                this.mame.setUser(user);
            }else{
                if(user.getActivo() == 1){
                    this.mame.deInicSecionALoby();
                    this.mame.setUser(user);
                }else{
                    JOptionPane.showMessageDialog(null, "\tUSUARIO INACTIVO COMUNIQUESE CON UN ADMI");
                }
            }
        }else{
           this.mame.deInicioSecionAUserInvalid();
        }
        
    }//GEN-LAST:event_InicioActionPerformed

    private void ContraseniaStringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContraseniaStringActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContraseniaStringActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField ContraseniaString;
    private javax.swing.JButton CrearUsuario;
    private javax.swing.JButton Inicio;
    private javax.swing.JTextField UsuarioString;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    
}
