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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMusicas = new javax.swing.JTable();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Musica");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jButtonProcurar.setText("Procurar");
        jButtonProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProcurarActionPerformed(evt);
            }
        });

        Arquivo.setText("Arquivo");

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonComfirmar.setText("Comfirmar");
        jButtonComfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComfirmarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome");

        jLabel3.setText("Genero");

        jLabel4.setText("Artista");

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });

        jComboBoxArtistas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxArtistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxArtistasActionPerformed(evt);
            }
        });

        jLabel5.setText("Albun");

        jComboBoxAlbuns.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Gerenciar Musicas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Arquivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jComboBoxArtistas, 0, 294, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextFieldGenero))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldNome)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxAlbuns, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonProcurar)
                .addGap(0, 84, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonComfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCancelar)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(110, 110, 110))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxArtistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxAlbuns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonProcurar))
                    .addComponent(Arquivo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonComfirmar)
                    .addComponent(jButtonCancelar)))
        );

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(jTableMusicas);

        jButtonEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(458, 458, 458))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonEditar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonExcluir)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            /*JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fc.showOpenDialog(this);
            File f = fc.getSelectedFile();
            jTextFieldProcurar.setText(f.getPath());
            this.path = f.getPath();
            *//*
            InputStream inputStream = null;
            
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fc.showOpenDialog(this);
            File file = fc.getSelectedFile();
            inputStream = new FileInputStream(file);
            jTextFieldProcurar.setText(file.getPath());
            
            Upload upload = new Upload();
            upload.upload("C:\\Users\\Gustavo\\Documents\\NetBeansProjects\\teste\\src\\mp3", file.getName(), inputStream);
            } catch (FileNotFoundException ex) {
            Logger.getLogger(TelaCadastrarMusica.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
            */
            
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fc.showOpenDialog(this);
            this.file = fc.getSelectedFile();
            jTextFieldProcurar.setText(file.getPath());
            //this.path = file.getPath();
            this.path = "/musicas/"+ file.getName();
            
        
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
            upload.upload("C:\\Users\\Gustavo\\Documents\\GitHub\\TRAB_FINAL_POOII\\TrabalhoFinalPOO\\src\\musicas", file.getName(), inputStream);
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
