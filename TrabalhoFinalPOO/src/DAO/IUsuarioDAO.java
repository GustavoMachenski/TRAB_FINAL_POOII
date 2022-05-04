package DAO;

import exceptions.PersistenceException;
import modelo.Usuario;

public interface IUsuarioDAO {
    
    public boolean inserir(Usuario u) throws PersistenceException;
    
    public void alterar(Usuario u) throws PersistenceException;
    
    public boolean excluir(Usuario u) throws PersistenceException;
    
    public Usuario consultar(int id) throws PersistenceException;
    
    public Usuario consultarLogin(String email, String senha) throws PersistenceException;
    
}
