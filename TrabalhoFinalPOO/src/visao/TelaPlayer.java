/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.Controle;
import java.io.InputStream;
import modelo.Musica;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import modelo.Playlist;

/**
 *
 * @author Gustavo
 */
public class TelaPlayer extends javax.swing.JFrame {
    Controle controle;
    private Playlist playlist;
    private Player ply;
    private boolean estaExecutando;
    private int cont =0;
    private List<Musica> musicasList;
    //private String[] musicas = new String [5];
    
    //List<Musica> listmusicas = new ArrayList<>();
    /**
     * Creates new form TelaPlayer
     */
    public TelaPlayer(Controle controle) {
        initComponents();
        this.controle = controle;
        jButtonPause.setEnabled(false);
        jButtonAvancar.setEnabled(false);
        jButtonVoltar.setEnabled(false);
        this.playlist = controle.getPlaylist();
        this.musicasList = controle.buscarMusicasPlaylist(this.playlist.getIdPlaylist());
        jLabelMusica.setText(musicasList.get(cont).getNome());
       
        //controle.getListMusica(); vai pegar a lista enviada da tela principal usuario para o controle e puxar para tocar(recebe retorno list musica)
    }
    
    class Musicas extends Thread {
        public void run(){
            try {
                InputStream input = this.getClass().getResourceAsStream(musicasList.get(cont).getCaminho());
                ply = new Player(input);
                ply.play();
            } catch (JavaLayerException ex) {
                Logger.getLogger(TelaPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        jPanel1 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButtonAvancar = new javax.swing.JButton();
        jButtonPlay = new javax.swing.JButton();
        jButtonPause = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabelMusica = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Player de Musicas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton6.setText("Rep. play");

        jButtonAvancar.setText(">>");
        jButtonAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAvancarActionPerformed(evt);
            }
        });

        jButtonPlay.setText("Play");
        jButtonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayActionPerformed(evt);
            }
        });

        jButtonPause.setText("Pause");
        jButtonPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPauseActionPerformed(evt);
            }
        });

        jButtonVoltar.setText("<<");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButton4.setText("Rep. Mus");

        jLabelMusica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMusica.setText("m");

        jButton8.setText("Aleatorio");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButton6)
                .addGap(48, 48, 48)
                .addComponent(jButtonVoltar)
                .addGap(57, 57, 57)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jButtonAvancar)
                .addGap(27, 27, 27)
                .addComponent(jButton4)
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(jButtonPlay)
                .addGap(33, 33, 33)
                .addComponent(jButtonPause)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jLabelMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPlay)
                    .addComponent(jButtonPause))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButtonAvancar)
                    .addComponent(jButton4)
                    .addComponent(jButton8)
                    .addComponent(jButtonVoltar))
                .addGap(46, 46, 46))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayActionPerformed
        Musicas mp3 = new Musicas();
        mp3.start();
        jButtonPlay.setEnabled(false);
        jButtonPause.setEnabled(true);
        jButtonAvancar.setEnabled(true);
        
    }//GEN-LAST:event_jButtonPlayActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        controle.fecharTelaPlayer();
    }//GEN-LAST:event_formWindowClosed

    private void jButtonPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPauseActionPerformed
        ply.close();
        estaExecutando = false;
        jButtonPlay.setEnabled(true);
    }//GEN-LAST:event_jButtonPauseActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        cont--;
        jLabelMusica.setText(musicasList.get(cont).getNome());
        if(estaExecutando = true){
            ply.close();
            Musicas mp3 = new Musicas();
            mp3.start();
        }
        if(cont < musicasList.size()-1){
            jButtonAvancar.setEnabled(true);
        }
        if(cont == 0){
            jButtonVoltar.setEnabled(false);
        }
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAvancarActionPerformed
        cont++;
        jButtonVoltar.setEnabled(true);
       jLabelMusica.setText(musicasList.get(cont).getNome());
        if(estaExecutando = true){
            ply.close();
            Musicas mp3 = new Musicas();
            mp3.start();
        }
        if(cont == musicasList.size()-1){
            jButtonAvancar.setEnabled(false);
        }
    }//GEN-LAST:event_jButtonAvancarActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButtonAvancar;
    private javax.swing.JButton jButtonPause;
    private javax.swing.JButton jButtonPlay;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabelMusica;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
