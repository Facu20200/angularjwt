package com.yoprogramo.angularjwt.repository;

import com.yoprogramo.angularjwt.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileDataRepository extends JpaRepository<Profile, Long>{
  
}
