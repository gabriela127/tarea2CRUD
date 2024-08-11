package EjercicioCrud;

import java.sql.SQLException;

public class main extends Estudiante{
	 public static void main(String[] args) throws SQLException {
				 
	 
	        // Crear un nuevo estudiante.
	 Estudiante.CreatEstudiante("Ana", "González", "2001-05-21", "F", "Zona 12, 9a avenida, Ciudad de Guatemala", "4444-5678", "ana.gonzalez@example.com", "", "2024-08-01");
	 Estudiante.CreatEstudiante("Javier", "Ramírez", "1999-11-03", "M", "Zona 4, 6a calle, Mixco", "5678-1234", "javier.ramirez@example.com", "", "2024-08-02");
	 Estudiante.CreatEstudiante("María", "Fernández", "2003-09-18", "F", "Zona 7, 5a avenida, Villa Nueva", "7894-2345", "maria.fernandez@example.com", "", "2024-08-03");
	 Estudiante.CreatEstudiante("Sofía", "Martínez", "2000-12-25", "F", "Zona 1, 4a calle, Ciudad de Guatemala", "3456-7890", "sofia.martinez@example.com", "", "2024-08-04");
	 Estudiante.CreatEstudiante("Ricardo", "López", "2002-04-10", "M", "Zona 5, 8a avenida, San José Pinula", "6543-2109", "ricardo.lopez@example.com", "", "2024-08-05");
	 Estudiante.CreatEstudiante("Daniela", "Rojas", "2004-07-07", "F", "Zona 13, 7a calle, Ciudad de Guatemala", "4321-6789", "daniela.rojas@example.com", "", "2024-08-06");
	 Estudiante.CreatEstudiante("Carlos", "Lopez", "1990-03-11", "M", "Zona 1, 4a Calle 5, Ciudad de Guatemala", "5535-1244", "clopez@gmail.com", "", "2024-02-22");
	 Estudiante.CreatEstudiante("Karla", "Castillo", "2000-07-06", "F", "Mixco Zona 3, 7a Avenida Calle 3", "1245-7894", "CastilloK@gmail.com", "", "2024-07-31");
	 Estudiante.CreatEstudiante("Alfredo", "Evezt", "2001-12-16", "M", "Villa Nueva Zona 4, 3a Avenida 5 Calle", "0912-4562", "Eveztal@gmail.com", "", "2024-07-31");
	 Estudiante.CreatEstudiante("Luis", "Martini", "2005-12-24", "M", "5a Avenida 7 Calle, San José Pinula", "2354-9032", "LuisM@gmail.com", "", "2024-07-31");
	 Estudiante.CreatEstudiante("Luisa", "Castellena", "2002-08-22", "F", "Zona 10, 12a Avenida 7 Calle, Ciudad de Guatemala", "8912-3489", "CastillaLui@gmail.com", "", "2024-07-31");

	 
       leerEstudiantes.selectEstudiantes();

       // Actualizar un estudiante
       ActualizarEstudiantes.updateEstudiante(2, "Juan", "Perez", "2000-01-01", "M", "Calle Falsa 456", "555-5678", "juan.perez@nuevoemail.com", "11", "2024-07-31");

       // Eliminar un estudiante
       EliminarEstudiante.DeleteEstudiante(1);
       
       leerEstudiantes.selectEstudiantes();
	 }
   }	