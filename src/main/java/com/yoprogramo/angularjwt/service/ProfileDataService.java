package com.yoprogramo.angularjwt.service;

import com.yoprogramo.angularjwt.entity.Profile;
import com.yoprogramo.angularjwt.repository.ProfileDataRepository;
import com.yoprogramo.angularjwt.service.interfaces.IProfileDataService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileDataService implements IProfileDataService {
  
  @Autowired
  ProfileDataRepository dataRepo;

  @Override
  public List<Profile> getProfiles() {
    return dataRepo.findAll();
  }

  @Override
  public void addProfile(Profile data) {
    dataRepo.save(data);
  }

  @Override
  public void editProfile(Profile data) {
    dataRepo.save(data);
  }

  @Override
  public void deleteProfile(Long id) {
    dataRepo.deleteById(id);
  }
  
}
