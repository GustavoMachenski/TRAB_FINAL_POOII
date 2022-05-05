/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import exceptions.PersistenceException;
import java.util.List;
import modelo.Albun;
import modelo.Artista;


/**
 *
 * @author Aluno
 */
public interface IAlbunDAO {
    
     public void inserir(Albun a) throws PersistenceException;
    
    public void alterar(Albun a) throws PersistenceException;
    
    public boolean excluir(Albun a) throws PersistenceException;
    
    public Albun consultar(int id) throws PersistenceException;
    
    public List<Albun> consultarTodos() throws PersistenceException;
}
