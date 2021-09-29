package repository;

import entities.Carrera;

public interface CarreraRepository {
	Carrera getCarreraById(Long id);
	Carrera getCarreraByName(String name);
	Carrera saveCarrera(Carrera c);
	void deleteCarrera(Carrera c);
}
