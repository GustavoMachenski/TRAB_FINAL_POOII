/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.Controle;
import java.awt.Color;
import java.awt.Toolkit;
import java.net.URL;
import modelo.Usuario;
import javax.swing.JFrame;

/**
 *
 * @author Gustavo
 */
public class GeradorDeTelas {

    public JFrame criarTela(String nome, Controle controle) {
        JFrame frame;
        if (nome.equals("telalogin")) {
            frame = new TelaLogin(controle);
        } else if (nome.equals("telaautocadastro")) {
            frame = new TelaAutoCadastro(controle);
        } else if (nome.equals("telaprincipal")) {
            frame = new TelaPrincipal(controle);
        } else if (nome.equals("telacadastrarmusica")) {
            frame = new TelaCadastrarMusica(controle);
        } else if (nome.equals("telagerenciarartista")) {
            frame = new TelaGerenciarArtista(controle);
        } else if (nome.equals("telaplayer")) {
            frame = new TelaPlayer(controle);
        } else if (nome.equals("telagerenciaralbuns")) {
            frame = new TelaGerenciarAlbuns(controle);
        } else if (nome.equals("telagerenciarplaylist")) {
            frame = new TelaGerenciarPlaylist(controle);
        } else if (nome.equals("telacadastrarplaylist")) {
            frame = new TelaCadastrarPlaylist(controle);
        } else if (nome.equals("telasobre")) {
            frame = new TelaSobre(controle);
        } else if (nome.equals("telausuarios")) {
            frame = new TelaUsuarios(controle);
        } else {
            frame = new JFrame();
        }
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/icones/icon.png"));
        return frame;
    }

}
