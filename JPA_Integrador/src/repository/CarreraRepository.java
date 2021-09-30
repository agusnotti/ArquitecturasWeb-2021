package repository;

import org.apache.commons.csv.CSVParser;

import entities.Carrera;

import java.util.List;

public interface CarreraRepository {
	Carrera getCarreraById(Long id);
	Carrera getCarreraByName(String name);
	Carrera saveCarrera(Carrera c);
	void deleteCarrera(Carrera c);
	void insertarDesdeCSV(CSVParser csv);
	List<Carrera> getCarrerasConEstudiantes();

}
