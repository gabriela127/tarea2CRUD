package maven.gv.ConexionMariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManger {

 private static final String URL = "jdbc:mariadb://localhost:3307/bd_colegio";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "gabriela127";

    public static Connection getConnection() throws SQLException {
        try {
            // Cargar el controlador de MariaDB
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador de MariaDB: " + e.getMessage());
            return null;
        }
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }
}