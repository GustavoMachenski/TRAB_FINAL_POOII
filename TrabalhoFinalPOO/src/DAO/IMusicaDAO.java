package DAO;

import exceptions.PersistenceException;
import java.util.List;
import modelo.Musica;
import modelo.Playlist;

public interface IMusicaDAO {
    
    public void inserir(Musica m) throws PersistenceException;
    
    public void alterar(Musica m) throws PersistenceException;
    
    public boolean excluir(Musica m) throws PersistenceException;
    
    public boolean excluirPorIdArtista(int id) throws PersistenceException;
    
    public Musica consultar(int id) throws PersistenceException;
    
    public List<Musica> consultarPorIdPlaylist(int id) throws PersistenceException;
    
    public List<Musica> consultarTodas() throws PersistenceException;
    
    public void vincularMusicaPlaylist(Musica m, Playlist p) throws PersistenceException;
    
    public List<Musica> buscarListaDeMusicasExcetoPlaylist(Playlist p) throws PersistenceException;
    
    public void removerMusicaPlaylist(Musica m, Playlist p) throws PersistenceException;
}
