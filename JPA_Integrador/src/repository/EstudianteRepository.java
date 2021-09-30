package repository;

import java.util.List;

import entities.Estudiante;

public interface EstudianteRepository {
	Estudiante getEstudianteById(Long id);
	Estudiante getEstudianteByNumeroLibreta(String numLibreta);
	Estudiante saveEstudiante(Estudiante c);
	void deleteEstudiante(Estudiante c);
	List<Estudiante> getEstudiantesOrdenados();
	List<Estudiante> getEstudiantesByGenero(char genero);
}
