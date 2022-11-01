package com.yoprogramo.angularjwt.service.interfaces;

import com.yoprogramo.angularjwt.entity.SoftSkill;
import java.util.List;


public interface ISoftSkillService {
  
  public List<SoftSkill> getSkillList();
  
  public SoftSkill getSkill(Long id);
  
  public void addSkill(SoftSkill skill);
  
  public void editSkill(SoftSkill skill);
  
  public void deleteSkill(Long id);
  
}
