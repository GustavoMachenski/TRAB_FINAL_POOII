package modelo;

public class Artista {

    private int idArtista;
    private String nome;
    private String generoPrincipal;

    public Artista(int idArtista, String nome, String generoPrinciapal) {
        this.idArtista = idArtista;
        this.nome = nome;
        this.generoPrincipal = generoPrinciapal;
    }

    public Artista(String nome, String generoPrinciapal) {
        this.nome = nome;
        this.generoPrincipal = generoPrinciapal;
    }

    public Artista() {
        this.idArtista = 0;
        this.nome = "";
        this.generoPrincipal = "";
    }

    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGeneroPrincipal() {
        return generoPrincipal;
    }

    public void setGeneroPrincipal(String generoPrincipal) {
        this.generoPrincipal = generoPrincipal;
    }

    @Override
    public String toString() {
        return this.nome;
    }

}
