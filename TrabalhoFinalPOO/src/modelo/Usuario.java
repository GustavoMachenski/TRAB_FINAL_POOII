package modelo;

public class Usuario{
    protected int idUsuario;
    protected String nome;
    protected String email;
    protected String senha;
    protected String permissao;
    

    public Usuario(String nome, String email, String senha, String permissao) {
        this.nome      = nome;
        this.email     = email;
        this.senha     = senha;
        this.permissao = permissao;
    }
    
    public Usuario(int idUsuario,String nome, String email, String senha, String permissao) {
        this.idUsuario = idUsuario;
        this.nome      = nome;
        this.email     = email;
        this.senha     = senha;
        this.permissao = permissao;
    }
    
    public Usuario(int idUsuario,String nome, String email, String permissao) {
        this.idUsuario = idUsuario;
        this.nome      = nome;
        this.email     = email;
        this.senha     = "";
        this.permissao = permissao;
    }

    public Usuario() {
        this.idUsuario  = 0;
        this.nome       = "";
        this.email      = "";
        this.senha      = "";
        this. permissao = "";
        
    }
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome(){
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSenha() {
        return this.senha;
    }
    
    public String getPermissao() {
        return permissao;
    }
    
    public boolean fazerLogin(String email, String senha){
        
        return true;
    }

    public boolean alterarSenha(String senhaAtual, String senhaNova) {
        this.senha = senhaNova;
        return true;
    }

    public boolean criarPlaylist(String nome, Usuario usuario){
        Playlist playlist = new Playlist(nome, usuario);
        return true;
    
    }
    public boolean excluirPlaylist(int idPlaylist){
        
        return true;
    }

}
