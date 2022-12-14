package com.yoprogramo.angularjwt.service;

import com.yoprogramo.angularjwt.service.interfaces.IEducationService;
import com.yoprogramo.angularjwt.entity.Education;
import com.yoprogramo.angularjwt.repository.EducationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EducationService implements IEducationService {

  @Autowired
  public EducationRepository educRepo;

  @Override
  public List<Education> getEducationList() {
    return educRepo.findAll();
  }

  @Override
  public Education getEducation(Long id) {
    return educRepo.findById(id).orElse(null);
  }

  @Override
  public void addEducation(Education educ) {
    educRepo.save(educ);
  }

  @Override
  public void editEducation(Education educ) {
    educRepo.save(educ);
  }

  @Override
  public void deleteEducation(Long id) {
    educRepo.deleteById(id);
  }

}
