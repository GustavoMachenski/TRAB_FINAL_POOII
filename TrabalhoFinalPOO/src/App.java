
import DAO.ArtistaDAO;
import exceptions.PersistenceException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Artista;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gustavo
 */
public class App {
    public static void main(String[] args) {
        try {
            ArtistaDAO a = new ArtistaDAO();
            List<Artista> lista = a.consultarTodos();
            
            for(Artista b: lista){
                System.out.println(b.getNome());
        }
        } catch (PersistenceException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
}
