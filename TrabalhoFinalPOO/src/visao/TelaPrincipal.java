/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.Controle;
import modelo.Administrador;
import modelo.Usuario;

/**
 *
 * @author Gustavo
 */
public class TelaPrincipal extends javax.swing.JFrame {
    Controle controle;
    Usuario usuario;
    Administrador adm;
    /**
     * Creates new form TelaPrincipalUsuario
     */
    public TelaPrincipal(Controle controle) {
        initComponents();
        this.controle = controle;
        jMenuBar.add(jMenuPrincipal);
        jMenuBar.add(jMenuAdministrador);
        if(controle.getUsuario().getPermissao().equals("usr")){
            this.usuario = controle.getUsuario();
            jTextField2.setText(usuario.getNome());
            jMenuBar.remove(jMenuAdministrador);
        } else {
            this.adm = controle.getAdiministrador();
            jTextField2.setText(adm.getNome());
            
        }
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListMusicas = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButtonTocarMusica = new javax.swing.JButton();
        jButtonTocarColecao = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonTocarTodas = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuPrincipal = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItemSair = new javax.swing.JMenuItem();
        jMenuAdministrador = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItemCadastrarMusica = new javax.swing.JMenuItem();
        jMenuAlbun = new javax.swing.JMenu();
        jMenuItemCadastrarAlbun = new javax.swing.JMenuItem();
        jMenuItemExcluirAlbun = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Player");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jListMusicas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListMusicasFocusGained(evt);
            }
        });
        jListMusicas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListMusicasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListMusicas);

        jLabel1.setText("Musicas");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButtonTocarMusica.setText("Tocar");
        jButtonTocarMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTocarMusicaActionPerformed(evt);
            }
        });

        jButtonTocarColecao.setText("Tocar");
        jButtonTocarColecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTocarColecaoActionPerformed(evt);
            }
        });

        jLabel2.setText("Coleções");

        jButtonTocarTodas.setText("Tocar todas");
        jButtonTocarTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTocarTodasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButtonTocarTodas)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonTocarMusica))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonTocarColecao, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(28, 28, 28))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonTocarMusica)
                    .addComponent(jButtonTocarColecao)
                    .addComponent(jButtonTocarTodas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 3, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 250));

        jMenuPrincipal.setText("Menu");

        jMenuItem1.setText("Playlists");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuPrincipal.add(jMenuItem1);

        jMenuItem2.setText("Músicas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuPrincipal.add(jMenuItem2);

        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenuPrincipal.add(jMenuItemSair);

        jMenuBar.add(jMenuPrincipal);

        jMenuAdministrador.setText("Cadastros");

        jMenuItem5.setText("Música");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenuAdministrador.add(jMenuItem5);

        jMenuItemCadastrarMusica.setText("Artista");
        jMenuItemCadastrarMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarMusicaActionPerformed(evt);
            }
        });
        jMenuAdministrador.add(jMenuItemCadastrarMusica);

        jMenuAlbun.setText("Albun");

        jMenuItemCadastrarAlbun.setText("Cadastrar");
        jMenuItemCadastrarAlbun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarAlbunActionPerformed(evt);
            }
        });
        jMenuAlbun.add(jMenuItemCadastrarAlbun);

        jMenuItemExcluirAlbun.setText("Excluir");
        jMenuItemExcluirAlbun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExcluirAlbunActionPerformed(evt);
            }
        });
        jMenuAlbun.add(jMenuItemExcluirAlbun);

        jMenuAdministrador.add(jMenuAlbun);

        jMenuBar.add(jMenuAdministrador);

        setJMenuBar(jMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        controle.fecharTelaPrincipalUsuario();
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        controle.fecharTelaPrincipalUsuario();
    }//GEN-LAST:event_formWindowClosed

    private void jListMusicasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListMusicasMouseClicked
       jTextField2.setText(jListMusicas.getSelectedValue());
    }//GEN-LAST:event_jListMusicasMouseClicked

    private void jListMusicasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListMusicasFocusGained
       
    }//GEN-LAST:event_jListMusicasFocusGained

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        jTextField2.setText(jList1.getSelectedValue());
    }//GEN-LAST:event_jList1MouseClicked

    private void jButtonTocarTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTocarTodasActionPerformed
        controle.abrirTelasPlayer();
    }//GEN-LAST:event_jButtonTocarTodasActionPerformed

    private void jButtonTocarMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTocarMusicaActionPerformed
         controle.abrirTelasPlayer();
    }//GEN-LAST:event_jButtonTocarMusicaActionPerformed

    private void jButtonTocarColecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTocarColecaoActionPerformed
         controle.abrirTelasPlayer();
    }//GEN-LAST:event_jButtonTocarColecaoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        controle.abrirTelaCadastrarMusica();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItemExcluirAlbunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExcluirAlbunActionPerformed
        controle.abrirTelasExcluirAlbun();
    }//GEN-LAST:event_jMenuItemExcluirAlbunActionPerformed

    private void jMenuItemCadastrarAlbunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarAlbunActionPerformed
        controle.abrirTelaAdicionarAlbun();
    }//GEN-LAST:event_jMenuItemCadastrarAlbunActionPerformed

    private void jMenuItemCadastrarMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarMusicaActionPerformed
        controle.abrirTelaGerenciarArtista();
    }//GEN-LAST:event_jMenuItemCadastrarMusicaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonTocarColecao;
    private javax.swing.JButton jButtonTocarMusica;
    private javax.swing.JButton jButtonTocarTodas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jListMusicas;
    private javax.swing.JMenu jMenuAdministrador;
    private javax.swing.JMenu jMenuAlbun;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItemCadastrarAlbun;
    private javax.swing.JMenuItem jMenuItemCadastrarMusica;
    private javax.swing.JMenuItem jMenuItemExcluirAlbun;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenu jMenuPrincipal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
