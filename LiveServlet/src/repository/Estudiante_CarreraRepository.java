package repository;

import org.apache.commons.csv.CSVParser;

import entities.Estudiante_Carrera;

public interface Estudiante_CarreraRepository {

	Estudiante_Carrera getEstudianteCarreraById(Long id);
	Estudiante_Carrera saveEstudianteCarrera(Estudiante_Carrera ec);
	void deleteEstudianteCarrera(Estudiante_Carrera ec);
	void insertarDesdeCSV(CSVParser csv);
}
