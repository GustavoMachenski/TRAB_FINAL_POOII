package DAO;

import exceptions.PersistenceException;
import java.util.List;
import modelo.Musica;

public interface IMusicaDAO {
    
    public void inserir(Musica m) throws PersistenceException;
    
    public void alterar(Musica m) throws PersistenceException;
    
    public boolean excluir(Musica m) throws PersistenceException;
    
    public boolean excluirPorIdArtista(int id) throws PersistenceException;
    
    public Musica consultar(int id) throws PersistenceException;
    
    public List<Musica> consultarTodas() throws PersistenceException;
}
