package DAO;

import conecxao.Conexao;
import exceptions.PersistenceException;
import modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements IUsuarioDAO {

    @Override
    public boolean inserir(Usuario u) throws PersistenceException {
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps
                    = con.prepareStatement("INSERT INTO usuario (nome, email, senha, permissao) VALUES (?,?,?,?)",
                            PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getSenha());
            ps.setString(4, u.getPermissao());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                u.setIdUsuario(rs.getInt(1));
            }
            rs.close();
            ps.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            throw new PersistenceException("Banco de dados inacessível");
            
        }
    }

    @Override
    public void alterar(Usuario u) throws PersistenceException {
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps
                    = con.prepareStatement("UPDATE usuario SET nome=?, email=?, senha=?, permissao=? WHERE idusuario=?");
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getSenha());
            ps.setString(4, u.getPermissao());
            ps.setInt(5, u.getIdUsuario());
            ps.execute();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            throw new PersistenceException("Banco de dados inacessível");
        }
    }

    @Override
    public boolean excluir(Usuario u) throws PersistenceException {
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps
                    = con.prepareStatement("DELETE FROM usuario WHERE idusuario = ?");
            ps.setInt(1, u.getIdUsuario());
            ps.execute();
            ps.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            throw new PersistenceException("Banco de dados inacessível");
        }
    }

    /**
     *
     * @param id
     * @return
     * @throws PersistenceException
     */
    @Override
    public Usuario consultar(int id) throws PersistenceException {
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps = con.prepareStatement("SELECT idusuario, nome, email, senha, permissao FROM usuario WHERE idusuario = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario u = new Usuario(rs.getInt("idusuario"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"), rs.getString("permissao"));
                rs.close();
                ps.close();
                con.close();
                return u;
            } else {
                throw new PersistenceException("Usuario não localizado.");
            }

        } catch (SQLException ex) {
            throw new PersistenceException("Banco de dados inacessível");
        }

    }
    
    @Override
    public Usuario consultarLogin(String email, String senha) throws PersistenceException {
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps = con.prepareStatement("SELECT idusuario, nome, email, senha, permissao FROM usuario WHERE email = ? AND senha = ?");
            ps.setString(1, email);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery(); 
            if (rs.next()) {
                Usuario u = new Usuario(rs.getInt("idusuario"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"), rs.getString("permissao"));
                rs.close();
                ps.close();
                con.close();
                return u;
            } else {
                return new Usuario();
            }

        } catch (SQLException ex) {
            throw new PersistenceException("Banco de dados inacessível");
        }

    }

}
