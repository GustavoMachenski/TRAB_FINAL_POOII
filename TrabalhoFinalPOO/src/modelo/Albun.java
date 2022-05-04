package modelo;

import java.util.ArrayList;
import java.util.List;

public class Albun {
    private int idAlbun;
    private String nome;
    private Artista artista;
    private List<Musica> listaMusicas;
    
    public Albun(int idAlbun, String nome, Artista artista) {
        this.idAlbun      = idAlbun;
        this.nome         = nome;
        this.artista      = artista ;
        this.listaMusicas = new ArrayList<>();
    }

    public Albun(String nome,Artista artista) {
        this.nome         = nome;
        this.artista      = artista ;
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
     * @return the idAlbun
     */
    public int getIdAlbun() {
        return idAlbun;
    }

    /**
     * @param idAlbun the idAlbun to set
     */
    public void setIdAlbun(int idAlbun) {
        this.idAlbun = idAlbun;
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
     * @return the artista
     */
    public Artista getArtista() {
        return artista;
    }

    /**
     * @param artista the artista to set
     */
    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    /**
     * @return the listaMusicas
     */
    public List<Musica> getListaMusicas() {
        return listaMusicas;
    }
}
