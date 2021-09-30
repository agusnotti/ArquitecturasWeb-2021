package repository;

import java.util.List;

import org.apache.commons.csv.CSVParser;

import entities.Estudiante;

public interface EstudianteRepository {
	Estudiante getEstudianteById(Long id);
	Estudiante getEstudianteByNumeroLibreta(int numLibreta);
	Estudiante saveEstudiante(Estudiante c);
	void deleteEstudiante(Estudiante c);
	List<Estudiante> getEstudiantesOrdenadosPorEdad();
	List<Estudiante> getEstudiantesByGenero(char genero);
	void insertarDesdeCSV(CSVParser csv);
}
