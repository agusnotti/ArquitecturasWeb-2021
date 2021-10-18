package repository;

import entities.Carrera;
import entities.Estudiante;
import org.apache.commons.csv.CSVParser;

import java.util.List;

public interface EstudianteRepository {
	Estudiante getEstudianteById(Long id);
	Estudiante getEstudianteByNumeroLibreta(int numLibreta);
	Estudiante saveEstudiante(Estudiante c);
	void deleteEstudiante(Estudiante c);
	List<Estudiante> getEstudiantesOrdenadosPorEdad();
	List<Estudiante> getEstudiantesByGenero(char genero);
	void insertarDesdeCSV(CSVParser csv);
	List<Estudiante> getEstudiantesDeCarreraYciudad(Carrera c, String ciudad);
}
