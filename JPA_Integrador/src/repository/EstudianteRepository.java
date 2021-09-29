package repository;

import entities.Estudiante;

public interface EstudianteRepository {
	Estudiante getEstudianteById(Long id);
	Estudiante getEstudianteByNumeroLibreta(String numLibreta);
	Estudiante saveEstudiante(Estudiante c);
	void deleteEstudiante(Estudiante c);
}
