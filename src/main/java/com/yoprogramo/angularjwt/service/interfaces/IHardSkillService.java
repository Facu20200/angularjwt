package com.yoprogramo.angularjwt.service.interfaces;

import com.yoprogramo.angularjwt.entity.HardSkill;
import java.util.List;


public interface IHardSkillService {
  
  public List<HardSkill> getSkillList();
  
  public HardSkill getSkill(Long id);
  
  public void addSkill(HardSkill skill);
  
  public void editSkill(HardSkill skill);
  
  public void deleteSkill(Long id);
  
}
