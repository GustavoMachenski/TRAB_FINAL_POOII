/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.AlbunDAO;
import DAO.ArtistaDAO;
import DAO.DAOgeral;
import DAO.UsuarioDAO;
import exceptions.HashGenerationException;
import exceptions.PersistenceException;
import modelo.Administrador;
import modelo.Usuario;
import visao.GeradorDeTelas;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Albun;
import modelo.Artista;
import util.Digest;

/**
 *
 * @author Gustavo
 */
public class Controle {

    private GeradorDeTelas fabrica;
    private Map<String, JFrame> telas;
    protected Usuario usuario;
    private Administrador adm;
    DAOgeral daogeral = new DAOgeral();

    // contrutor
    public Controle() {
        fabrica = new GeradorDeTelas();
        telas = new HashMap<>();
    }

    //função de inicio
    public void iniciarAplicacao() {
        telas.put("telalogin", fabrica.criarTela("telalogin", this));
        telas.get("telalogin").setVisible(true);
        this.usuario = new Usuario();
        this.adm = new Administrador();
    }

    // metodo main
    public static void main(String[] args) {

        Controle controle = new Controle();
        controle.iniciarAplicacao();
    }

    // abertura de telas
    public void abrirTelaAutoCadastro() {
        telas.put("telaautocadastro", fabrica.criarTela("telaautocadastro", this));
        telas.get("telaautocadastro").setVisible(true);
        telas.get("telalogin").setVisible(false);
    }

    public boolean abrirTelaPrincipal(String email, String senha) throws HashGenerationException {

        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuario = usuarioDAO.consultarLogin(email, Digest.hashString(senha, "SHA-256"));

            if (usuario.getIdUsuario() == 0) {
                return false;
            } else {
                if (usuario.getPermissao().equals("adm")) {
                    adm = new Administrador(usuario.getIdUsuario(), usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getPermissao());
                }

                telas.put("telaprincipal", fabrica.criarTela("telaprincipal", this));
                telas.get("telaprincipal").setVisible(true);
                telas.get("telalogin").dispose();

                return true;
            }
        } catch (PersistenceException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void abrirTelaCadastrarMusica() {
        telas.put("telacadastrarmusica", fabrica.criarTela("telacadastrarmusica", this));
        telas.get("telacadastrarmusica").setVisible(true);
        telas.get("telaprincipal").setVisible(false);
    }

    public void abrirTelaCadastrarArtista() {
        telas.put("telacadastrarartista", fabrica.criarTela("telacadastrarartista", this));
        telas.get("telacadastrarartista").setVisible(true);
        telas.get("telaprincipal").setVisible(false);
    }

    public void abrirTelaAdicionarAlbun() {
        telas.put("telaadicionaralbun", fabrica.criarTela("telaadicionaralbun", this));
        telas.get("telaadicionaralbun").setVisible(true);
        telas.get("telaprincipal").setVisible(false);
    }

    public void abrirTelasPlayer() {
        telas.put("telaplayer", fabrica.criarTela("telaplayer", this));
        telas.get("telaplayer").setVisible(true);
        telas.get("telaprincipal").setVisible(false);
    }
    
    public void abrirTelasExcluirAlbun() {
        telas.put("telaexcluiralbun", fabrica.criarTela("telaexcluiralbun", this));
        telas.get("telaexcluiralbun").setVisible(true);
        telas.get("telaprincipal").setVisible(false);
    }
    
    

    //fechamento de telas
    public void fecharTelaAutoCadastro() {
        telas.get("telaautocadastro").dispose();
        telas.get("telalogin").setVisible(true);
    }

    public void fecharTelaPrincipalAdiministrador() {
        this.adm = new Administrador();
        telas.get("telaprincipal").dispose();
        telas.get("telalogin").setVisible(true);
    }

    public void fecharTelaPrincipalUsuario() {
        this.usuario = new Usuario();
        telas.get("telaprincipal").dispose();
        telas.get("telalogin").setVisible(true);
    }

    public void fecharTelaCadastrarArtista() {
        telas.get("telacadastrarartista").dispose();
        telas.get("telaprincipal").setVisible(true);
    }

    public void fecharTelaCadastrarMusica() {
        telas.get("telacadastrarmusica").dispose();
        telas.get("telaprincipal").setVisible(true);
    }

    public void fecharTelaPlayer() {
        telas.get("telaplayer").dispose();
        telas.get("telaprincipal").setVisible(true);
    }

    public void fecharTelaAdicionarAlbun() {
        telas.get("telaadicionaralbun").dispose();
        telas.get("telaprincipal").setVisible(true);
    }
    
    public void fecharTelaExcluirAlbun() {
        telas.get("telaexcluiralbun").dispose();
        telas.get("telaprincipal").setVisible(true);
    }

    // validações e outros
    public Usuario getUsuario() {
        return this.usuario;
    }

    public Administrador getAdiministrador() {
        return this.adm;
    }

    public boolean comfirmarAutoCadastro(String nome, String email, String senha) throws HashGenerationException {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();

            Usuario u = new Usuario(nome, email, Digest.hashString(senha,"SHA-256"), "usr");

            if (usuarioDAO.inserir(u)) {
                telas.get("telaautocadastro").dispose();
                telas.get("telalogin").setVisible(true);
                return true;
            } else {
                return false;
            }
        } catch (PersistenceException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean comferirSenha(String senha, String senhaconf) {
        if (senha.equals(senhaconf)) {
            return true;
        } else {
            return false;
        }
    }

    public void inserirArtista(String nome, String generoPrincipal) {
        try {
            ArtistaDAO artistaDAO = new ArtistaDAO();
            Artista a = new Artista(nome, generoPrincipal);
            artistaDAO.inserir(a);
            telas.get("telacadastrarartista").dispose();
            telas.get("telaprincipal").setVisible(true);
        } catch (PersistenceException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Artista> buscarListaDeArtistas() {
        try {
            ArtistaDAO artistaDAO = new ArtistaDAO();
            List<Artista> listaArtistas = artistaDAO.consultarTodos();
            return listaArtistas;
        } catch (PersistenceException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void cadastrarAlbun(String nome, Artista artista) {
        try {
            AlbunDAO albundao = new AlbunDAO();
            Albun a = new Albun(nome, artista);
            albundao.inserir(a);
            telas.get("telaadicionaralbun").dispose();
            telas.get("telaprincipal").setVisible(true);
            JOptionPane.showMessageDialog(null,"Cadastrado com sucesso!!","Servidor",JOptionPane.PLAIN_MESSAGE);
        } catch (PersistenceException ex) {
            JOptionPane.showMessageDialog(null, "Erro", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
    }

    public List<Albun> consultarAlbuns() {
        try {
            AlbunDAO albunDAO = new AlbunDAO();
            List<Albun> albuns = albunDAO.consultarTodos();
            return albuns ;
        } catch (PersistenceException ex) {
            JOptionPane.showMessageDialog(null, "Erro", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public void exlcuirAlbun(Albun albun) {
        try {
            AlbunDAO albunDAO = new AlbunDAO();
            albunDAO.excluir(albun);
            telas.get("telaexcluiralbun").dispose();
            telas.get("telaprincipal").setVisible(true);
            JOptionPane.showMessageDialog(null,"Albun excluido!!","Servidor",JOptionPane.PLAIN_MESSAGE);
        } catch (PersistenceException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
