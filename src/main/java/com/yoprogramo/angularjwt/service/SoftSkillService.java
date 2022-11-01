package com.yoprogramo.angularjwt.service;

import com.yoprogramo.angularjwt.entity.SoftSkill;
import com.yoprogramo.angularjwt.repository.SoftSkillRepository;
import com.yoprogramo.angularjwt.service.interfaces.ISoftSkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoftSkillService implements ISoftSkillService {

  
  @Autowired
  public SoftSkillRepository skillRepo;
  
  @Override
  public List<SoftSkill> getSkillList() {
   return skillRepo.findAll(); 
  }

  @Override
  public SoftSkill getSkill(Long id) {
    return skillRepo.findById(id).orElse(null);
  }

  @Override
  public void addSkill(SoftSkill skill) {
    skillRepo.save(skill);
  }

  @Override
  public void editSkill(SoftSkill skill) {
    skillRepo.save(skill);
  }

  @Override
  public void deleteSkill(Long id) {
    skillRepo.deleteById(id);
  }
  
}
