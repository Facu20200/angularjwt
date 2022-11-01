package com.yoprogramo.angularjwt.controller;

import com.yoprogramo.angularjwt.DTO.Mensaje;
import com.yoprogramo.angularjwt.entity.Profile;
import com.yoprogramo.angularjwt.service.interfaces.IProfileDataService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProfileDataController {

  @Autowired
  private IProfileDataService dataServ;

  @GetMapping("/init")
  public ResponseEntity<?> initApi() {
    return new ResponseEntity(new Mensaje("Api iniciada"), HttpStatus.OK);
  }

  @GetMapping("/profile")
  public ResponseEntity<List<Profile>> getProfile() {
    return new ResponseEntity(dataServ.getProfiles(), HttpStatus.OK);
  }

  @PostMapping("/profile")
  public ResponseEntity<?> postProfile(Profile prof) {
    dataServ.addProfile(prof);
    return new ResponseEntity(new Mensaje("Perfil Creado"), HttpStatus.OK);
  }

  @PutMapping("/profile")
  public ResponseEntity<?> editProfile(Profile prof) {
    dataServ.editProfile(prof);
    return new ResponseEntity(new Mensaje("Perfil Editado"), HttpStatus.OK);
  }

  @DeleteMapping("/profile/{id}")
  public ResponseEntity<?> deleteProfile(@PathVariable Long id) {
    dataServ.deleteProfile(id);
    return new ResponseEntity(new Mensaje("Perfil borrado"), HttpStatus.OK);
  }

}
