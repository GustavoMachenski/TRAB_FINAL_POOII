/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.AlbunDAO;
import DAO.ArtistaDAO;
import DAO.DAOgeral;
import DAO.MusicaDAO;
import DAO.PlaylistDAO;
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
import javax.swing.JTextField;
import modelo.Albun;
import modelo.Artista;
import modelo.Musica;
import modelo.Playlist;
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
    private int id = 0;
    private Playlist playlist;
    

    // construtor
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

    public void abrirTelaGerenciarArtista() {
        telas.put("telagerenciarartista", fabrica.criarTela("telagerenciarartista", this));
        telas.get("telagerenciarartista").setVisible(true);
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
    
    public void abrirTelaGerenciarAlbuns() {
        telas.put("telagerenciaralbuns", fabrica.criarTela("telagerenciaralbuns", this));
        telas.get("telagerenciaralbuns").setVisible(true);
        telas.get("telaprincipal").setVisible(false);
    }
    
    public void abrirTelaGerenciarPlaylist() {
        telas.put("telagerenciarplaylist", fabrica.criarTela("telagerenciarplaylist", this));
        telas.get("telagerenciarplaylist").setVisible(true);
        telas.get("telaprincipal").setVisible(false);
    }
    
    public void abrirTelaCadastrarPlaylist() {
        telas.put("telacadastrarplaylist", fabrica.criarTela("telacadastrarplaylist", this));
        telas.get("telacadastrarplaylist").setVisible(true);
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

    public void fecharTelaGerenciarArtista() {
        telas.get("telagerenciarartista").dispose();
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
    
     public void fecharTelaGerenciarAlbun() {
        telas.get("telagerenciaralbuns").dispose();
        telas.get("telaprincipal").setVisible(true);
    }
    
    public void fecharTelaExcluirArtista() {
        telas.get("telaexcluirartista").dispose();
        telas.get("telaprincipal").setVisible(true);
    }
    
    public void fecharTelaGerenciarPlaylist() {
        telas.get("telagerenciarplaylist").dispose();
        telas.get("telaprincipal").setVisible(true);
    }
    
    public void fecharTelaCadastrarPlaylist() {
        telas.get("telacadastrarplaylist").dispose();
        telas.get("telaprincipal").setVisible(true);
        this.id = 0;
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
    ////////metodos de artista//////////
    public void inserirArtista(String nome, String generoPrincipal) {
        try {
            ArtistaDAO artistaDAO = new ArtistaDAO();
            Artista a = new Artista(nome, generoPrincipal);
            artistaDAO.inserir(a);
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
    
    public void excluirArtista(Artista artista) {
        try {
            ArtistaDAO artistaDAO = new ArtistaDAO();
            artistaDAO.excluir(artista);
            JOptionPane.showMessageDialog(null,"Artista excluido!!","Servidor",JOptionPane.PLAIN_MESSAGE);
        } catch (PersistenceException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atulizarArtista(int idArtista, String nome, String generoPrincipal) {
        try {
            Artista a = new Artista(idArtista, nome, generoPrincipal);
            ArtistaDAO artistaDAO = new ArtistaDAO();
            artistaDAO.alterar(a);
            JOptionPane.showMessageDialog(null,"Artista editado!!","Servidor",JOptionPane.PLAIN_MESSAGE);
        } catch (PersistenceException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //// metodos de albuns ////////
    public void cadastrarAlbun(String nome, Artista artista) {
        try {
            AlbunDAO albundao = new AlbunDAO();
            Albun a = new Albun(nome, artista);
            albundao.inserir(a);
            JOptionPane.showMessageDialog(null,"Cadastrado com sucesso!!","Servidor",JOptionPane.PLAIN_MESSAGE);
        } catch (PersistenceException ex) {
            JOptionPane.showMessageDialog(null, "Erro", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void atualizarAlbun(int id, String nome, Artista artista){
        try {
            Albun a = new Albun(id, nome, artista);
            AlbunDAO albunDAO = new AlbunDAO();
            albunDAO.alterar(a);
            JOptionPane.showMessageDialog(null,"Albun editado!!","Servidor",JOptionPane.PLAIN_MESSAGE);
        } catch (PersistenceException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
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
            JOptionPane.showMessageDialog(null,"Albun excluido!!","Servidor",JOptionPane.PLAIN_MESSAGE);
        } catch (PersistenceException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /// metodos de musicas///

    public List<Musica> buscarListaDeMusicas() {
        try {
            MusicaDAO musicaDAO = new MusicaDAO();
            List<Musica> musicas = musicaDAO.consultarTodas();
            return musicas;
        } catch (PersistenceException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void cadastrarMusica(String nome, String genero, String path,Artista artista, Albun albun) {
        try {
            MusicaDAO musicaDAO = new MusicaDAO();
            Musica m =  new Musica(nome, genero, path, artista, albun);
            musicaDAO.inserir(m);
        } catch (PersistenceException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atualizarMusica(int idmusica, String nome, String genero, String path, Artista artista, Albun albun) {
        try {
            MusicaDAO musicaDAO = new MusicaDAO();
            Musica m =  new Musica(idmusica, nome, genero, path, artista, albun);
            musicaDAO.alterar(m);
        } catch (PersistenceException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluirMusica(Musica musica) {
        try {
            MusicaDAO musicaDAO = new MusicaDAO();
            musicaDAO.excluir(musica);
        } catch (PersistenceException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public List<Playlist> consultarPlaylists(int id) {
        try {
            PlaylistDAO playlistDAO = new PlaylistDAO();
            List<Playlist> playlists = playlistDAO.consultarPorIdUsuario(id);
            return playlists;
        } catch (PersistenceException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void excluirPlaylist(Playlist playlist) {
        try {
            PlaylistDAO playlistDAO = new PlaylistDAO();
            playlistDAO.excluir(playlist);
        } catch (PersistenceException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void cadastrarPlaylist(String nome, int id) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario u = usuarioDAO.consultar(id);
            Playlist p = new Playlist(nome, u);
            PlaylistDAO playlistDAO = new PlaylistDAO();
            playlistDAO.inserir(p);
            fecharTelaCadastrarPlaylist();
        } catch (PersistenceException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setPlayslist(Playlist playlist) {
       this.playlist = playlist;
    }

    public Playlist getPlaylist() {
        return this.playlist;
    }

    public List<Musica> buscarMusicasPlaylist(int id) {
        try {
            MusicaDAO musicaDAO = new MusicaDAO();
            List<Musica> musicas = musicaDAO.consultarPorIdPlaylist(id);
            return musicas;
        } catch (PersistenceException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    

    

    

    

}
