package com.yoprogramo.angularjwt.repository;

import com.yoprogramo.angularjwt.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Project, Long> {

}