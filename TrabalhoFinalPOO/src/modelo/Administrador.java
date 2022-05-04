package modelo;


public class Administrador extends Usuario{
    
    public Administrador() {
        this.idUsuario  = 0;
        this.nome       = "";
        this.email      = "";
        this.senha      = "";
        this. permissao = "";
    }

    public Administrador(String nome, String email, String senha, String permissao) {
        this.nome      = nome;
        this.email     = email;
        this.senha     = senha;
        this.permissao = permissao;
    }
    
    public Administrador(int idUsuario,String nome, String email, String senha, String permissao) {
        this.idUsuario = idUsuario;
        this.nome      = nome;
        this.email     = email;
        this.senha     = senha;
        this.permissao = permissao;
    }
    
    public boolean adicionarMusica(Musica musica){
        
        return true;
    }
    
    public boolean excluirMusica(int idMusica){
        
        return true;
    }
    
    public boolean adicionarAlbun(Albun albun){
    
        return true;
    }
    
    public boolean excluirAlbum(int idAlbun){
    
        return true;
    }
    
    public boolean adicionarArtista(Artista artista){
    
        return true;
    }
    
    public boolean excluirArtista(int idArtista){
     
        return true;
    }
    
    
    
}
