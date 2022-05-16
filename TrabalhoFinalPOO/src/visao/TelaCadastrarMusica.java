/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.Controle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import modelo.Albun;
import modelo.Artista;
import modelo.Musica;
import util.Upload;

/**
 *
 * @author Gustavo
 */
public class TelaCadastrarMusica extends javax.swing.JFrame {

    Controle controle;
    List<Musica> listMusicasAtt;
    String path;
    Musica musica = new Musica();
    File file;

    /**
     * Creates new form TelaCadastrarMusica
     */
    public TelaCadastrarMusica(Controle controle) {
        initComponents();
        this.controle = controle;

        List<Artista> artistas = controle.buscarListaDeArtistas();
        DefaultComboBoxModel model = new DefaultComboBoxModel(artistas.toArray());
        jComboBoxArtistas.setModel(model);

        List<Albun> albuns = controle.consultarAlbuns();
        DefaultComboBoxModel model0 = new DefaultComboBoxModel(albuns.toArray());
        jComboBoxAlbuns.setModel(model0);
        this.atualizarTabela();

    }

    public void atualizarTabela() {

        String titulos[] = new String[5];
        titulos[0] = "Nome";
        titulos[1] = "Genero Principal";
        titulos[2] = "Caminho";
        titulos[3] = "Artista";
        titulos[4] = "Albun";

        List<Musica> musicas = controle.buscarListaDeMusicas();
        this.listMusicasAtt = musicas;

        String dados[][] = new String[musicas.size()][5];
        for (int i = 0; i < musicas.size(); i++) {
            dados[i][0] = musicas.get(i).getNome();
            dados[i][1] = musicas.get(i).getGenero();
            dados[i][2] = musicas.get(i).getCaminho();
            dados[i][3] = musicas.get(i).getArtista().getNome();
            dados[i][4] = musicas.get(i).getAlbun().getNome();
        }

        DefaultTableModel modeloTabela = new DefaultTableModel(dados, titulos);
        jTableMusicas.setModel(modeloTabela);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonProcurar = new javax.swing.JButton();
        jTextFieldProcurar = new javax.swing.JTextField();
        Arquivo = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonComfirmar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldGenero = new javax.swing.JTextField();
        jComboBoxArtistas = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxAlbuns = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMusicas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Musica");
        setBackground(new java.awt.Color(153, 255, 153));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonProcurar.setBackground(new java.awt.Color(51, 51, 51));
        jButtonProcurar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        jButtonProcurar.setForeground(new java.awt.Color(153, 255, 153));
        jButtonProcurar.setText("Procurar");
        jButtonProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProcurarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonProcurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, -1, -1));

        jTextFieldProcurar.setBackground(new java.awt.Color(240, 240, 240));
        jTextFieldProcurar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        jPanel1.add(jTextFieldProcurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 220, 450, -1));

        Arquivo.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        Arquivo.setText("Arquivo");
        jPanel1.add(Arquivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 219, -1, -1));

        jButtonCancelar.setBackground(new java.awt.Color(51, 51, 51));
        jButtonCancelar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        jButtonCancelar.setForeground(new java.awt.Color(153, 255, 153));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 260, -1, -1));

        jButtonComfirmar.setBackground(new java.awt.Color(51, 51, 51));
        jButtonComfirmar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        jButtonComfirmar.setForeground(new java.awt.Color(153, 255, 153));
        jButtonComfirmar.setText("Comfirmar");
        jButtonComfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonComfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, -1, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        jLabel2.setText("Nome");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 64, -1, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        jLabel3.setText("Genero");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 109, -1, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        jLabel4.setText("Artista");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jTextFieldNome.setBackground(new java.awt.Color(240, 240, 240));
        jTextFieldNome.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 61, 540, -1));

        jTextFieldGenero.setBackground(new java.awt.Color(240, 240, 240));
        jTextFieldGenero.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        jPanel1.add(jTextFieldGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 106, 540, -1));

        jComboBoxArtistas.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        jComboBoxArtistas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxArtistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxArtistasActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxArtistas, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 540, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        jLabel5.setText("Albun");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jComboBoxAlbuns.setBackground(new java.awt.Color(240, 240, 240));
        jComboBoxAlbuns.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        jComboBoxAlbuns.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBoxAlbuns, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 181, 540, -1));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 36)); // NOI18N
        jLabel1.setText("Gerenciar Musicas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonEditar.setBackground(new java.awt.Color(51, 51, 51));
        jButtonEditar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        jButtonEditar.setForeground(new java.awt.Color(153, 255, 153));
        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 410, -1, -1));

        jButtonExcluir.setBackground(new java.awt.Color(51, 51, 51));
        jButtonExcluir.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        jButtonExcluir.setForeground(new java.awt.Color(153, 255, 153));
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 410, -1, -1));

        jTableMusicas.setBackground(new java.awt.Color(240, 240, 240));
        jTableMusicas.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(jTableMusicas);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 653, 371));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        controle.fecharTelaCadastrarMusica();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        controle.fecharTelaCadastrarMusica();
    }//GEN-LAST:event_formWindowClosed

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jComboBoxArtistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxArtistasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxArtistasActionPerformed

    private void jButtonProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProcurarActionPerformed
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fc.showOpenDialog(this);
            this.file = fc.getSelectedFile();
            jTextFieldProcurar.setText(file.getPath());
            //this.path = file.getPath();
            this.path = "C:\\Users\\Gustavo\\Documents\\GitHub\\TRAB_FINAL_POOII\\TrabalhoFinalPOO\\src\\musicas/" + file.getName();
            
        
    }//GEN-LAST:event_jButtonProcurarActionPerformed

    private void jButtonComfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComfirmarActionPerformed
        InputStream inputStream = null;
        Artista artista = (Artista) jComboBoxArtistas.getSelectedItem();
        Albun albun = (Albun) jComboBoxAlbuns.getSelectedItem();
        if (this.musica.getIdMusica() == 0) {
            controle.cadastrarMusica(jTextFieldNome.getText(), jTextFieldGenero.getText(), this.path, artista, albun);
            this.atualizarTabela();
        } else {
            controle.atualizarMusica(musica.getIdMusica(), jTextFieldNome.getText(), jTextFieldGenero.getText(), this.path, artista, albun);
            this.musica = new Musica();
        }
        
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TelaCadastrarMusica.class.getName()).log(Level.SEVERE, null, ex);
        }
        Upload upload = new Upload();
        try {
            upload.upload("C:\\Users\\Gustavo\\Documents\\GitHub\\TRAB_FINAL_POOII\\TrabalhoFinalPOO\\src\\musicas/", file.getName(), inputStream);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TelaCadastrarMusica.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        jTextFieldNome.setText("");
        jTextFieldGenero.setText("");
        jTextFieldProcurar.setText("");
        this.path = "";
        this.atualizarTabela();
    }//GEN-LAST:event_jButtonComfirmarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        int i = jTableMusicas.getSelectedRow();
        this.musica = listMusicasAtt.get(i);
        this.path = this.musica.getCaminho();
        jTextFieldNome.setText(musica.getNome());
        jTextFieldGenero.setText(musica.getGenero());

        /*populando a lista de artistas e marcando selecionado*/
        List<Artista> artistas = controle.buscarListaDeArtistas();
        DefaultComboBoxModel model = new DefaultComboBoxModel(artistas.toArray());
        jComboBoxArtistas.setModel(model);
        for (int index = 0; index < artistas.size(); index++) {
            if (artistas.get(index).getIdArtista() == musica.getArtista().getIdArtista()) {
                jComboBoxArtistas.setSelectedIndex(index);
            }
        }

        /*populando a lista de albuns e marcando selecionado*/
        List<Albun> albuns = controle.consultarAlbuns();
        DefaultComboBoxModel model0 = new DefaultComboBoxModel(albuns.toArray());
        jComboBoxAlbuns.setModel(model0);
        for (int index = 0; index < albuns.size(); index++) {
            if (albuns.get(index).getIdAlbun() == musica.getAlbun().getIdAlbun()) {
                jComboBoxAlbuns.setSelectedIndex(index);
            }
        }

        jTextFieldProcurar.setText(musica.getCaminho());
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int i = jTableMusicas.getSelectedRow();
        controle.excluirMusica(listMusicasAtt.get(i));
        this.atualizarTabela();
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Arquivo;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonComfirmar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonProcurar;
    private javax.swing.JComboBox<String> jComboBoxAlbuns;
    private javax.swing.JComboBox<String> jComboBoxArtistas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMusicas;
    private javax.swing.JTextField jTextFieldGenero;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldProcurar;
    // End of variables declaration//GEN-END:variables
}
