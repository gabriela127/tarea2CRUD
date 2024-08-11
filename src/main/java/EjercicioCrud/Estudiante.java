package EjercicioCrud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import maven.gv.ConexionMariadb.ConnectionManger;

public class Estudiante {
	
	public static void CreatEstudiante(String nombre, String apellido, String fechaNacimiento, String genero,
            String direccion, String telefono, String correoElectronico, String grado, String fechaInscripcion) {
String sql = "INSERT INTO estudiantes (nombre, apellido, fecha_nacimiento, genero, direccion, telefono, correo_electronico, grado, fecha_inscripcion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	try (Connection conn = ConnectionManger.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {

		pstmt.setString(1, nombre);
			pstmt.setString(2, apellido);
			pstmt.setString(3, fechaNacimiento); // Directamente como String
			pstmt.setString(4, genero);
			pstmt.setString(5, direccion);
			pstmt.setString(6, telefono);
			pstmt.setString(7, correoElectronico);
			pstmt.setString(8, grado);
			pstmt.setString(9, fechaInscripcion); // Directamente como String

			pstmt.executeUpdate();
			System.out.println("Estudiante creado exitosamente.");
	} catch (SQLException e) {
		System.out.println("Error al crear el estudiante: " + e.getMessage());
}
}


}
