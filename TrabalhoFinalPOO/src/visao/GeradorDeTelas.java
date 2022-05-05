/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.Controle;
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
        } else if (nome.equals("telacadastrarartista")) {
            frame = new TelaCadastrarArtista(controle);
        } else if (nome.equals("telaplayer")) {
            frame = new TelaPlayer(controle);
        } else if (nome.equals("telaadicionaralbun")) {
            frame = new TelaAdicionarAlbun(controle);
        } else if (nome.equals("telaexcluiralbun")) {
            frame = new TelaExcluirAlbun(controle);

        } else {
            frame = new JFrame();
        }
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        return frame;
    }

}
