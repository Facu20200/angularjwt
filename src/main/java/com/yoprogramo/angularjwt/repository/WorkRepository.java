package com.yoprogramo.angularjwt.repository;

import com.yoprogramo.angularjwt.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends JpaRepository<Work, Long> {

}
