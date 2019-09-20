package com.personal.proyecto.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.personal.proyecto.entidades.Estudiante;

@Repository
public interface IEstudianteRepository extends CrudRepository<Estudiante, Integer>{

}
