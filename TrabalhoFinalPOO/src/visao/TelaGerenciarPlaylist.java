/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

import controle.Controle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Musica;
import modelo.Playlist;

/**
 *
 * @author Aluno
 */
public class TelaGerenciarPlaylist extends javax.swing.JFrame {

    private Controle controle;
    private Playlist playlist;
    private int id;
    List<Musica> listMusicaPlaylist;
    List<Musica> listMusicas;

    /**
     * Creates new form TelaGerenciarPlaylist
     */
    public TelaGerenciarPlaylist(Controle controle) {
        initComponents();
        this.controle = controle;
        this.id = controle.getId();
        this.playlist = controle.getPlaylist();
        atualizarTabela();

    }

    public void atualizarTabela() {

        String titulos[] = new String[4];
        titulos[0] = "Nome";
        titulos[1] = "Genero Principal";
        titulos[2] = "Artista";
        titulos[3] = "Albun";

        List<Musica> musicas = controle.buscarListaDeMusicas();
        List<Musica> musicasPlaylist = controle.buscarMusicasPlaylist(playlist.getIdPlaylist());
        this.listMusicaPlaylist = musicasPlaylist;

        for (int i = 0; i < musicas.size(); i++) {
            for (int i1 = 0; i1 < musicasPlaylist.size(); i1++) {
                if (musicas.get(i).getIdMusica() == musicasPlaylist.get(i1).getIdMusica()) {
                    musicas.remove(musicas.get(i));
                }
            }
        }

        String dados[][] = new String[musicas.size()][4];
        for (int i = 0; i < musicas.size(); i++) {
            dados[i][0] = musicas.get(i).getNome();
            dados[i][1] = musicas.get(i).getGenero();
            dados[i][2] = musicas.get(i).getArtista().getNome();
            dados[i][3] = musicas.get(i).getAlbun().getNome();
        }

        DefaultTableModel modeloTabela = new DefaultTableModel(dados, titulos);
        jTableMusicas.setModel(modeloTabela);

        this.listMusicas = musicas;

        String dados1[][] = new String[musicasPlaylist.size()][4];
        for (int i = 0; i < musicasPlaylist.size(); i++) {
            dados1[i][0] = musicasPlaylist.get(i).getNome();
            dados1[i][1] = musicasPlaylist.get(i).getGenero();
            dados1[i][2] = musicasPlaylist.get(i).getArtista().getNome();
            dados1[i][3] = musicasPlaylist.get(i).getAlbun().getNome();
        }

        DefaultTableModel modeloTabela1 = new DefaultTableModel(dados1, titulos);
        jTableMusicaPlaylist.setModel(modeloTabela1);
        this.listMusicaPlaylist = musicasPlaylist;

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMusicaPlaylist = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMusicas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableMusicaPlaylist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableMusicaPlaylist);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 330, -1));

        jTableMusicas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableMusicas);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 340, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        controle.fecharTelaGerenciarPlaylist();
    }//GEN-LAST:event_formWindowClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableMusicaPlaylist;
    private javax.swing.JTable jTableMusicas;
    // End of variables declaration//GEN-END:variables
}
