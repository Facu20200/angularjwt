package com.yoprogramo.angularjwt.service.interfaces;

import com.yoprogramo.angularjwt.entity.Profile;
import java.util.List;


public interface IProfileDataService {
  
  public List<Profile> getProfiles();
  
  public void addProfile(Profile data);
  
  public void editProfile(Profile data);
  
  public void deleteProfile(Long id);
  
}
