package EjercicioCrud;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import maven.gv.ConexionMariadb.ConnectionManger;

public class ActualizarEstudiantes {
	 
	 public static void updateEstudiante(int id, String nombre, String apellido, String fechaNacimiento, String genero, String direccion, String telefono, String correo, String grado, String fechaInscripcion) {
	        String sql = "UPDATE estudiantes SET nombre=?, apellido=?, fecha_nacimiento=?, genero=?, direccion=?, telefono=?, correo_electronico=?, grado=?, fecha_inscripcion=? WHERE id=?";
	        
	        try (Connection conn = ConnectionManger.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            
	            pstmt.setString(1, nombre);
	            pstmt.setString(2, apellido);
	            pstmt.setDate(3, java.sql.Date.valueOf(fechaNacimiento));
	            pstmt.setString(4, genero);
	            pstmt.setString(5, direccion);
	            pstmt.setString(6, telefono);
	            pstmt.setString(7, correo);
	            pstmt.setString(8, grado);
	            pstmt.setDate(9, java.sql.Date.valueOf(fechaInscripcion));
	            pstmt.setInt(10, id);

	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
}
