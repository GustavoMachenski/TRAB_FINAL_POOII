package conecxao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/poo_spotify";
            String usuario = "root";
            String senha = "mysql";
            
            return DriverManager.getConnection(url, usuario, senha);
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Não encontrei o Driver");
            System.out.println(ex);
            System.exit(0);
        } catch (SQLException ex) {
            System.out.println("Não conectou com o banco de dados. Verifique os parâmetros de conexão.");
            System.out.println(ex);
        }
        return null;
    }
    
}
