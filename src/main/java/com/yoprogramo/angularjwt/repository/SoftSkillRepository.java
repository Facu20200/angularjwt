package com.yoprogramo.angularjwt.repository;

import com.yoprogramo.angularjwt.entity.SoftSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftSkillRepository extends JpaRepository<SoftSkill, Long>{
  
}
