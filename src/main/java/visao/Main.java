/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

/**
 *
 * @author paula
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        menu = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        miFuncionario = new javax.swing.JMenuItem();
        miFerias = new javax.swing.JMenuItem();
        miHorarios = new javax.swing.JMenuItem();
        menuFrequencias = new javax.swing.JMenu();
        miFrequencias = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setBackground(new java.awt.Color(0, 0, 0));
        lblTitulo.setFont(new java.awt.Font("Bodoni MT", 3, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Gestão de Frequências ");
        lblTitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnRegistrar.setBackground(java.awt.SystemColor.activeCaption);
        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrar.setText("Registrar Ponto");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnSair.setBackground(new java.awt.Color(255, 51, 51));
        btnSair.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        btnSair.setForeground(new java.awt.Color(0, 0, 0));
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        menuCadastro.setText("Cadastro");
        menuCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroActionPerformed(evt);
            }
        });

        miFuncionario.setText("Funcionário");
        miFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFuncionarioActionPerformed(evt);
            }
        });
        menuCadastro.add(miFuncionario);

        miFerias.setText("Férias");
        miFerias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFeriasActionPerformed(evt);
            }
        });
        menuCadastro.add(miFerias);

        miHorarios.setText("Horários");
        miHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miHorariosActionPerformed(evt);
            }
        });
        menuCadastro.add(miHorarios);

        menu.add(menuCadastro);

        menuFrequencias.setText("Frequências");

        miFrequencias.setText("Frequências registradas");
        miFrequencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFrequenciasActionPerformed(evt);
            }
        });
        menuFrequencias.add(miFrequencias);

        menu.add(menuFrequencias);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(btnRegistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnSair))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        TelaCadastroPonto telaCadastroP = new TelaCadastroPonto();
        telaCadastroP.setVisible(true);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void menuCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuCadastroActionPerformed

    private void miFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFuncionarioActionPerformed
        TelaFuncionario telaFuncionario = new TelaFuncionario();
        telaFuncionario.setVisible(true);
    }//GEN-LAST:event_miFuncionarioActionPerformed

    private void miFrequenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFrequenciasActionPerformed
       TelaPonto telaPonto = new TelaPonto();
        telaPonto.setVisible(true);
    }//GEN-LAST:event_miFrequenciasActionPerformed

    private void miFeriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFeriasActionPerformed
        TelaFerias telaFerias = new TelaFerias();
        telaFerias.setVisible(true);
    }//GEN-LAST:event_miFeriasActionPerformed

    private void miHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miHorariosActionPerformed
        TelaHorarios telaHorarios = new TelaHorarios();
        telaHorarios.setVisible(true);
    }//GEN-LAST:event_miHorariosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuFrequencias;
    private javax.swing.JMenuItem miFerias;
    private javax.swing.JMenuItem miFrequencias;
    private javax.swing.JMenuItem miFuncionario;
    private javax.swing.JMenuItem miHorarios;
    // End of variables declaration//GEN-END:variables
}