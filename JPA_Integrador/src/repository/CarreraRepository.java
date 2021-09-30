package repository;

import entities.Carrera;

import java.util.List;

public interface CarreraRepository {
	Carrera getCarreraById(Long id);
	Carrera getCarreraByName(String name);
	Carrera saveCarrera(Carrera c);
	void deleteCarrera(Carrera c);
	List<Carrera> getCarrerasConEstudiantes();
}
