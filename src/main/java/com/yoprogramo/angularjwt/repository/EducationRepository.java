package com.yoprogramo.angularjwt.repository;

import com.yoprogramo.angularjwt.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {

}
