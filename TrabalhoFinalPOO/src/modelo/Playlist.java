package modelo;

import java.util.ArrayList;
import java.util.List;


public class Playlist {
   private int idPlaylist;
   private String nome;
   private List<Musica> listaMusicas;
   private Usuario usuario;
   

    public Playlist(String nome, Usuario usuario) {
        this.nome         = nome;
        this.usuario      = usuario;
        this.listaMusicas = new ArrayList<>();
    }
    
     public Playlist(int idPlaylist, String nome, Usuario usuario) {
        this.idPlaylist = idPlaylist;
        this.nome         = nome;
        this.usuario      = usuario;
        this.listaMusicas = new ArrayList<>();
    }
    
    public boolean adicionarMusica(Musica musica){
        boolean existe = false;
        for(Musica m: getListaMusicas()){
            if(m.getNome().equals(musica.getNome())){
                existe = true; 
            }
        }
        if(!existe){
            getListaMusicas().add(musica);
            return true;
        }else{
            return false;
        }
        
    }
    
    public boolean removerMusica(Musica musica){
        boolean existe = false;
        for(Musica m: getListaMusicas()){
            if(m.getNome().equals(musica.getNome())){
                existe = true; 
            }
        }
        if(existe){
            getListaMusicas().remove(musica);
            return true;
        }else{
            return false;
        }
    }

    /**
     * @return the idPlaylist
     */
    public int getIdPlaylist() {
        return idPlaylist;
    }

    /**
     * @param idPlaylist the idPlaylist to set
     */
    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the listaMusicas
     */
    public List<Musica> getListaMusicas() {
        return listaMusicas;
    }

    /**
     * @param listaMusicas the listaMusicas to set
     */
    public void setListaMusicas(List<Musica> listaMusicas) {
        this.listaMusicas = listaMusicas;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
