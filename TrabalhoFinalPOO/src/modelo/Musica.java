package modelo;

public class Musica {

    private int idMusica;
    private String nome;
    private String genero;
    private String caminho;
    private Artista artista;
    private Albun albun;

    public Musica(int idMusica, String nome, String genero, String caminho, Artista artista, Albun albun) {
        this.idMusica = idMusica;
        this.nome    = nome;
        this.genero  = genero;
        this.caminho = caminho;
        this.artista = artista;
        this.albun = albun;
    }
    
    public Musica(String nome, String genero, String caminho, Artista artista, Albun albun) {
        this.nome    = nome;
        this.genero  = genero;
        this.caminho = caminho;
        this.artista = artista;
        this.albun = albun;
    }

    public Musica() {
        this.idMusica = 0;
        this.nome    = "";
        this.genero  = "";
        this.caminho = "";
        this.artista = new Artista();
        this.albun = new Albun();
    }

    /**
     * @return the idMusica
     */
    public int getIdMusica() {
        return idMusica;
    }

    /**
     * @param idMusica the idMusica to set
     */
    public void setIdMusica(int idMusica) {
        this.idMusica = idMusica;
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
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the caminho
     */
    public String getCaminho() {
        return caminho;
    }

    /**
     * @param caminho the caminho to set
     */
    public void setCaminho(String caminho) {
        this.caminho = caminho;
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
    
    public Albun getAlbun() {
        return albun;
    }

    public void setAlbun(Albun albun) {
        this.albun = albun;
    }
    
   
    

}
