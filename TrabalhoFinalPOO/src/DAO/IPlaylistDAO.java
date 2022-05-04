package DAO;

import exceptions.PersistenceException;
import java.util.List;
import modelo.Playlist;


public interface IPlaylistDAO {
    
    public void inserir(Playlist p) throws PersistenceException;
    
    public void alterar(Playlist p) throws PersistenceException;
    
    public boolean excluir(Playlist p) throws PersistenceException;
    
    public Playlist consultar(int id) throws PersistenceException;
    
    public List<Playlist> consultarTodas() throws PersistenceException;
}
