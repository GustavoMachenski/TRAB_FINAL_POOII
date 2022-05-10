package DAO;

import conecxao.Conexao;
import exceptions.PersistenceException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Albun;
import modelo.Artista;

public class ArtistaDAO implements IArtistaDAO{

    @Override
    public void inserir(Artista a) throws PersistenceException {
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps
                    = con.prepareStatement("INSERT INTO artista(nome, generoprincipal) VALUES (?,?)",
                            PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, a.getNome());
            ps.setString(2, a.getGeneroPrincipal());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                a.setIdArtista(rs.getInt(1));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            throw new PersistenceException("Banco de dados inacessível");
        }
    }

    @Override
    public void alterar(Artista a) throws PersistenceException {
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps
                    = con.prepareStatement("UPDATE artista SET nome=?, generoprincipal=? WHERE idartista=?");
            ps.setString(1, a.getNome());
            ps.setString(2, a.getGeneroPrincipal());
            ps.setInt(3, a.getIdArtista());
            ps.execute();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            throw new PersistenceException("Banco de dados inacessível");
        }
    }

    @Override
    public boolean excluir(Artista a) throws PersistenceException {
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            MusicaDAO musicaDAO = new MusicaDAO();
            musicaDAO.excluirPorIdArtista(a.getIdArtista());
            AlbunDAO albunDAO = new AlbunDAO();
            albunDAO.excluirPorIdArtista(a.getIdArtista());
            PreparedStatement ps = con.prepareStatement("DELETE FROM artista WHERE idartista = ?");
            ps.setInt(1, a.getIdArtista());
            ps.execute();
            ps.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            throw new PersistenceException("Banco de dados inacessível");
        }
    }

    @Override
    public Artista consultar(int id) throws PersistenceException {
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps = con.prepareStatement("SELECT idartista, nome, generoprincipal FROM artista WHERE idartista = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery(); 
            if (rs.next()) {
                Artista a = new Artista(rs.getInt("idartista"), rs.getString("nome"), rs.getString("generoprincipal"));
                rs.close();
                ps.close();
                con.close();
                return a;
            } else {
                throw new PersistenceException("Artista não localizado.");
            }

        } catch (SQLException ex) {
            throw new PersistenceException("Banco de dados inacessível");
        }

    }
    
    @Override
    public List<Artista> consultarTodos() throws PersistenceException {
        List<Artista> artistas = new ArrayList<>();
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps = con.prepareStatement("SELECT idartista, nome, generoprincipal FROM artista");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Artista a = new Artista(rs.getInt("idartista"), rs.getString("nome"), rs.getString("generoprincipal"));
                artistas.add(a);
            }
            rs.close();
            ps.close();
            con.close();
            return artistas;
        } catch (SQLException ex) {
            System.out.println(ex);
            throw new PersistenceException("Banco de dados inacessível");
            
        }
    }
}
