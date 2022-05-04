package modelo;

public class Artista{
    private int idArtista;
    private String nome;
    private String generoPrincipal;
    
    public Artista(int idArtista, String nome, String generoPrinciapal) {
        this.idArtista       = idArtista;
        this.nome            = nome;
        this.generoPrincipal = generoPrinciapal;
    }
    
    public Artista(String nome, String generoPrinciapal) {
        this.nome            = nome;
        this.generoPrincipal = generoPrinciapal;
    }

    /**
     * @return the idArtista
     */
    public int getIdArtista() {
        return idArtista;
    }

    /**
     * @param idArtista the idArtista to set
     */
    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
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
     * @return the generoPrincipal
     */
    public String getGeneroPrincipal() {
        return generoPrincipal;
    }

    /**
     * @param generoPrincipal the generoPrincipal to set
     */
    public void setGeneroPrincipal(String generoPrincipal) {
        this.generoPrincipal = generoPrincipal;
    }
    
    

 
}
