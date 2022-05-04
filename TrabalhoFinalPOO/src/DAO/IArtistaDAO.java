package DAO;

import exceptions.PersistenceException;
import java.util.List;
import modelo.Artista;

public interface IArtistaDAO {
    
    public void inserir(Artista a) throws PersistenceException;
    
    public void alterar(Artista a) throws PersistenceException;
    
    public boolean excluir(Artista a) throws PersistenceException;
    
    public Artista consultar(int id) throws PersistenceException;
    
    public List<Artista> consultarTodos() throws PersistenceException;
}
