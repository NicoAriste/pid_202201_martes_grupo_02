package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto.entity.Departamento;



public interface DepartamentoRepository extends JpaRepository<Departamento ,Integer> {

}
