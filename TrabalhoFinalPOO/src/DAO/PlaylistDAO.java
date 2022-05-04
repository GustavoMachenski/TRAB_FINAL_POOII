package DAO;

import conecxao.Conexao;
import exceptions.PersistenceException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Playlist;
import modelo.Usuario;


public class PlaylistDAO implements IPlaylistDAO{

    @Override
    public void inserir(Playlist p) throws PersistenceException {
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps
                    = con.prepareStatement("INSERT INTO playlist (nome, idusuario) VALUES (?, ?)",
                            PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getNome());
            ps.setInt(2, p.getUsuario().getIdUsuario());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                p.setIdPlaylist(rs.getInt(1));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            throw new PersistenceException("Banco de dados inacessível");
        }
    }

    @Override
    public void alterar(Playlist p) throws PersistenceException {
       try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps
                    = con.prepareStatement("UPDATE playlist SET nome=? WHERE idplaylist=?");
            ps.setString(1, p.getNome());
            ps.execute();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            throw new PersistenceException("Banco de dados inacessível");
        }
    }

    @Override
    public boolean excluir(Playlist p) throws PersistenceException {
       try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps
                    = con.prepareStatement("DELETE FROM playlist WHERE idplaylist = ?");
            ps.setInt(1, p.getIdPlaylist());
            ps.execute();
            ps.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            throw new PersistenceException("Banco de dados inacessível");
        }
    }

    @Override
    public Playlist consultar(int id) throws PersistenceException {
      try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps = con.prepareStatement("SELECT idplaylist, nome, idusuario FROM playlist WHERE idplaylist = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                UsuarioDAO usuarioDAO = new UsuarioDAO(); 
                Usuario u = usuarioDAO.consultar(rs.getInt("idusuario"));
                Playlist p = new Playlist(rs.getInt("idplaylist"), rs.getString("nome"), u);
                rs.close();
                ps.close();
                con.close();
                return p;
            } else {
                throw new PersistenceException("Playlist não localizada.");
            }

        } catch (SQLException ex) {
            throw new PersistenceException("Banco de dados inacessível");
        }

    }

    @Override
    public List<Playlist> consultarTodas() throws PersistenceException {
      List<Playlist> playlists = new ArrayList<>();
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps = con.prepareStatement("SELECT idplaylist, nome, idusuario FROM playlist");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UsuarioDAO usuarioDAO = new UsuarioDAO(); 
                Usuario u = usuarioDAO.consultar(rs.getInt("idusuario"));
                Playlist p = new Playlist(rs.getInt("idplaylist"), rs.getString("nome"), u);
                playlists.add(p);
            }
            rs.close();
            ps.close();
            con.close();
            return playlists;
        } catch (SQLException ex) {
            throw new PersistenceException("Banco de dados inacessível");
        }
    }
    
}
