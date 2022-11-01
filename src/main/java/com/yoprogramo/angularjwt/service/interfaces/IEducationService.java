package com.yoprogramo.angularjwt.service.interfaces;

import com.yoprogramo.angularjwt.entity.Education;
import java.util.List;



public interface IEducationService {

  public List<Education> getEducationList();

  public Education getEducation(Long id);

  public void addEducation(Education educ);

  public void editEducation(Education educ);

  public void deleteEducation(Long id);

}
