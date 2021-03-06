package DAO;

import conecxao.Conexao;
import exceptions.PersistenceException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Albun;
import modelo.Artista;
import modelo.Musica;
import modelo.Playlist;

public class MusicaDAO implements IMusicaDAO{

    @Override
    public void inserir(Musica m) throws PersistenceException {
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps
                    = con.prepareStatement("INSERT INTO musica(nome, genero, caminho, idartista,idalbun) VALUES (?, ?, ?, ?, ?)",
                            PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, m.getNome());
            ps.setString(2, m.getGenero());
            ps.setString(3, m.getCaminho());
            ps.setInt(4, m.getArtista().getIdArtista());
            ps.setInt(5, m.getAlbun().getIdAlbun());
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
                    = con.prepareStatement("UPDATE musica SET nome=?, genero=?, caminho=?, idartista=?, idalbun=? WHERE idmusica=?");
            ps.setString(1, m.getNome());
            ps.setString(2, m.getGenero());
            ps.setString(3, m.getCaminho());
            ps.setInt(4, m.getArtista().getIdArtista());
            ps.setInt(5, m.getAlbun().getIdAlbun());
            ps.setInt(6, m.getIdMusica());
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
    public boolean excluirPorIdArtista(int id) throws PersistenceException {
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps
                    = con.prepareStatement("DELETE FROM musica WHERE idartista = ?");
            ps.setInt(1, id);
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

    @Override
    public List<Musica> consultarPorIdPlaylist(int id) throws PersistenceException {
        List<Musica> musicas = new ArrayList<>();
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM musica INNER JOIN playlist_musica ON musica.idmusica = playlist_musica.idmusica WHERE playlist_musica.idplaylist = ?");
            ps.setInt(1, id);
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

    @Override
    public void vincularMusicaPlaylist(Musica m, Playlist p) throws PersistenceException {
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps = con.prepareStatement("INSERT INTO playlist_musica (idplaylist, idmusica) VALUES (?,?)");
            ps.setInt(1, p.getIdPlaylist());
            ps.setInt(2, m.getIdMusica());
            ps.execute();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            throw new PersistenceException("Banco de dados inacessível");
        }
    }

    @Override
    public List<Musica> buscarListaDeMusicasExcetoPlaylist(Playlist p) throws PersistenceException {
        List<Musica> musicas = new ArrayList<>();
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps = con.prepareStatement("select * from musica where idmusica not in (select idmusica from playlist_musica where idplaylist = ?)");
            ps.setInt(1, p.getIdPlaylist());
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

    @Override
    public void removerMusicaPlaylist(Musica m, Playlist p) throws PersistenceException {
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps = con.prepareStatement("DELETE FROM playlist_musica WHERE idplaylist = ? AND idmusica = ?");
            ps.setInt(1, p.getIdPlaylist());
            ps.setInt(2, m.getIdMusica());
            ps.execute();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MusicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
