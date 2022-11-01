package com.yoprogramo.angularjwt.repository;

import com.yoprogramo.angularjwt.entity.HardSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardSkillRepository extends JpaRepository<HardSkill, Long>{
  
}
