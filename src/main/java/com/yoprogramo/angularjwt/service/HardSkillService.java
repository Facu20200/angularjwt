package com.yoprogramo.angularjwt.service;

import com.yoprogramo.angularjwt.entity.HardSkill;
import com.yoprogramo.angularjwt.repository.HardSkillRepository;
import com.yoprogramo.angularjwt.service.interfaces.IHardSkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HardSkillService implements IHardSkillService {

  
  @Autowired
  public HardSkillRepository skillRepo;
          
  @Override
  public List<HardSkill> getSkillList() {
    return skillRepo.findAll();
  }

  @Override
  public HardSkill getSkill(Long id) {
    return skillRepo.findById(id).orElse(null);
  }

  @Override
  public void addSkill(HardSkill skill) {
    skillRepo.save(skill);
  }

  @Override
  public void editSkill(HardSkill skill) {
    skillRepo.save(skill);
  }

  @Override
  public void deleteSkill(Long id) {
    skillRepo.deleteById(id);
  }
  
}
