package EjercicioCrud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import maven.gv.ConexionMariadb.ConnectionManger;

import java.sql.SQLException;

public class leerEstudiantes {
  
    public static void selectEstudiantes() {
        String sql = "SELECT * FROM estudiantes";
        
        try (Connection conn = ConnectionManger.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Apellido: " + rs.getString("apellido"));
                System.out.println("Fecha de Nacimiento: " + rs.getDate("fecha_nacimiento"));
                System.out.println("Género: " + rs.getString("genero"));
                System.out.println("Dirección: " + rs.getString("direccion"));
                System.out.println("Teléfono: " + rs.getString("telefono"));
                System.out.println("Correo Electrónico: " + rs.getString("correo_electronico"));
                System.out.println("Grado: " + rs.getString("grado"));
                System.out.println("Fecha de Inscripción: " + rs.getDate("fecha_inscripcion"));
                System.out.println("-------------------------------");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}