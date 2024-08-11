package EjercicioCrud;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import maven.gv.ConexionMariadb.ConnectionManger;

public class EliminarEstudiante {
	 public static void DeleteEstudiante(int id) {
	        String sql = "DELETE FROM estudiantes WHERE id=?";
	        
	        try (Connection conn = ConnectionManger.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            
	            pstmt.setInt(1, id);
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
}
