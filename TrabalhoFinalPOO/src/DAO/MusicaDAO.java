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
import modelo.Musica;

public class MusicaDAO implements IMusicaDAO{

    @Override
    public void inserir(Musica m) throws PersistenceException {
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps
                    = con.prepareStatement("INSERT INTO musica(nome, genero, caminho, idartista) VALUES (?, ?, ?, ?)",
                            PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, m.getNome());
            ps.setString(2, m.getGenero());
            ps.setString(3, m.getCaminho());
            ps.setInt(4, m.getArtista().getIdArtista());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                m.setIdMusica(rs.getInt(1));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            throw new PersistenceException("Banco de dados inacessível");
        }
    }

    @Override
    public void alterar(Musica m) throws PersistenceException {
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps
                    = con.prepareStatement("UPDATE musica SET nome=?, genero=?, caminho=?, idartista=? WHERE idmusica=?");
            ps.setString(1, m.getNome());
            ps.setString(2, m.getGenero());
            ps.setString(3, m.getCaminho());
            ps.setInt(4, m.getArtista().getIdArtista());
            ps.setInt(5, m.getIdMusica());
            ps.execute();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            throw new PersistenceException("Banco de dados inacessível");
        }
    }

    @Override
    public boolean excluir(Musica m) throws PersistenceException {
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps
                    = con.prepareStatement("DELETE FROM musica WHERE idmusica = ?");
            ps.setInt(1, m.getIdMusica());
            ps.execute();
            ps.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            throw new PersistenceException("Banco de dados inacessível");
        }
    }

    @Override
    public Musica consultar(int id) throws PersistenceException {
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps = con.prepareStatement("SELECT idmusica, nome, genero, caminho, idartista, idalbun FROM musica WHERE idmusica = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ArtistaDAO artistaDAO = new ArtistaDAO(); 
                Artista a = artistaDAO.consultar(rs.getInt("idartista"));
                AlbunDAO albunDAO = new AlbunDAO(); 
                Albun ab = albunDAO.consultar(rs.getInt("idalbun"));
                Musica m = new Musica(rs.getInt("idmusica"), rs.getString("nome"), rs.getString("genero"), rs.getString("caminho"), a,ab);
                rs.close();
                ps.close();
                con.close();
                return m;
            } else {
                throw new PersistenceException("Musica não localizada.");
            }

        } catch (SQLException ex) {
            throw new PersistenceException("Banco de dados inacessível");
        }

    }
    
    @Override
    public List<Musica> consultarTodas() throws PersistenceException {
        List<Musica> musicas = new ArrayList<>();
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps = con.prepareStatement("SELECT idmusica, nome, genero, caminho, idartista, idalbun FROM musica");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ArtistaDAO artistaDAO = new ArtistaDAO(); 
                Artista a = artistaDAO.consultar(rs.getInt("idartista"));
                AlbunDAO albunDAO = new AlbunDAO(); 
                Albun ab = albunDAO.consultar(rs.getInt("idalbun"));
                Musica m = new Musica(rs.getInt("idmusica"), rs.getString("nome"), rs.getString("genero"), rs.getString("caminho"), a, ab);
                musicas.add(m);
            }
            rs.close();
            ps.close();
            con.close();
            return musicas;
        } catch (SQLException ex) {
            throw new PersistenceException("Banco de dados inacessível");
        }
    }
    
}
