/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conecxao.Conexao;
import exceptions.PersistenceException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Albun;
import modelo.Artista;

/**
 *
 * @author Aluno
 */
public class AlbunDAO implements IAlbunDAO {

    @Override
    public void inserir(Albun a) throws PersistenceException {
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps= con.prepareStatement("INSERT INTO albun(nome, idartista) VALUES (?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, a.getNome());
            ps.setInt(2, a.getArtista().getIdArtista());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                a.setIdAlbun(rs.getInt(1));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            throw new PersistenceException("Banco de dados inacessível");
        }
    }

    @Override
    public void alterar(Albun a) throws PersistenceException {
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps
                    = con.prepareStatement("UPDATE albun SET nome=?, idartista=? WHERE idalbun = ?");
            ps.setString(1, a.getNome());
            ps.setInt(2, a.getArtista().getIdArtista());
            ps.setInt(3, a.getIdAlbun());
            ps.execute();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            throw new PersistenceException("Banco de dados inacessível");
        }
    }
    @Override
    public boolean excluir(Albun a) throws PersistenceException {
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps = con.prepareStatement("DELETE FROM albun WHERE idalbun = ?");
            ps.setInt(1, a.getIdAlbun());
            ps.execute();
            ps.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            throw new PersistenceException("Banco de dados inacessível");
        }
    }

    @Override
    public Albun consultar(int id) throws PersistenceException {
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.conectar();
            PreparedStatement ps = con.prepareStatement("SELECT idalbun, nome, idartista FROM albun WHERE idalbun = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ArtistaDAO artistaDAO = new ArtistaDAO(); 
                Artista artista = artistaDAO.consultar(rs.getInt("idartista"));
                Albun a = new Albun(rs.getInt("idalbun"), rs.getString("nome"), artista);
                rs.close();
                ps.close();
                con.close();
                return a;
            } else {
                throw new PersistenceException("Playlist não localizada.");
            }

        } catch (SQLException ex) {
            throw new PersistenceException("Banco de dados inacessível");
        }
    }

}
