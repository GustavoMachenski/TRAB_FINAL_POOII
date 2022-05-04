package DAO;

import conecxao.Conexao;
import modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOgeral {
    private Connection con;

    public DAOgeral() {
        Conexao conexao = new Conexao();
        this.con = conexao.conectar();
    }
    
    public boolean cadastrarUsuario(Usuario usuario){
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO usuario (nome, email, senha, permissao) VALUES(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getEmail());
            pst.setString(3, usuario.getSenha());
            pst.setString(4, usuario.getPermissao());
            pst.execute();
            ResultSet rs = pst.getGeneratedKeys();
            rs.next();
            usuario.setIdUsuario(rs.getInt(1));
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOgeral.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Usuario comfirmarLogin(String email, String senha) {
        Usuario usuario = new Usuario();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT idusuario, nome, email, senha, permissao FROM usuario WHERE email = ? AND senha = ?");
            pst.setString(1, email);
            pst.setString(2, senha);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                usuario = new Usuario(rs.getInt("idusuario"),rs.getString("nome"),rs.getString("email"),rs.getString("senha"), rs.getString("permissao"));
                 return usuario;
            }else{
                return usuario;
            }   
        } catch (SQLException ex) {
            Logger.getLogger(DAOgeral.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
    
    
}
