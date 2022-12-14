package com.yoprogramo.angularjwt.controller;

import com.yoprogramo.angularjwt.DTO.Mensaje;
import com.yoprogramo.angularjwt.entity.Education;
import com.yoprogramo.angularjwt.entity.Project;
import com.yoprogramo.angularjwt.entity.Work;
import com.yoprogramo.angularjwt.service.interfaces.IEducationService;
import com.yoprogramo.angularjwt.service.interfaces.IImageService;
import com.yoprogramo.angularjwt.service.interfaces.IProyectoService;
import com.yoprogramo.angularjwt.service.interfaces.IWorkService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://angularjwtfront.web.app")
public class DataController {

  @Autowired
  private IImageService imgServ;

  @Autowired
  private IWorkService workServ;

  @Autowired
  private IEducationService educServ;

  @Autowired
  private IProyectoService projServ;

  @PostMapping("/image")
  public ResponseEntity<?> addImage(@RequestParam("file") MultipartFile image) {
    imgServ.saveImage(image);
    return new ResponseEntity(new Mensaje("Imagen Guardada"), HttpStatus.OK);
  }

  @GetMapping(path = {"/image/{name}"})
  public ResponseEntity<Resource> loadImage(@PathVariable("name") String name) {
    return imgServ.loadImage(name);
  }

  @DeleteMapping(path = {"/image/{name}"})
  public ResponseEntity<?> deleteImage(@PathVariable("name") String name) {
    imgServ.deleteImage(name);
    return new ResponseEntity(new Mensaje("Imagen Borrada"), HttpStatus.OK);
  }

  @GetMapping("/work")
  public ResponseEntity<List<Work>> getWorkList() {
    return new ResponseEntity(workServ.getWorkList(), HttpStatus.OK);
  }

  @GetMapping("/work/{id}")
  public ResponseEntity<Work> getWork(@PathVariable Long id) {
    return new ResponseEntity(workServ.getWork(id), HttpStatus.OK);
  }

  @PostMapping("/work")
  public ResponseEntity<?> addWork(@RequestBody Work data) {
    workServ.addWork(data);
    return new ResponseEntity(new Mensaje("Trabajo Agregado"), HttpStatus.OK);

  }

  @PutMapping("/work")
  public ResponseEntity<?> editWork(@RequestBody Work data) {
    workServ.editWork(data);
    return new ResponseEntity(new Mensaje("Trabajo actualizado"), HttpStatus.OK);
  }

  @DeleteMapping("work/{id}")
  public ResponseEntity<?> deleteWork(@PathVariable Long id) {
    workServ.deleteWork(id);
    return new ResponseEntity(new Mensaje("Trabajo borrado"), HttpStatus.OK);
  }

  @GetMapping("/education")
  public ResponseEntity<List<Education>> getEducationList() {
    return new ResponseEntity(educServ.getEducationList(), HttpStatus.OK);
  }

  @GetMapping("/education/{id}")
  public ResponseEntity<Education> getEducation(@PathVariable Long id) {
    return new ResponseEntity(educServ.getEducation(id), HttpStatus.OK);
  }

  @PostMapping("/education")
  public ResponseEntity<?> addEducation(@RequestBody Education data) {
    educServ.addEducation(data);
    return new ResponseEntity(new Mensaje("Educacion Agregada"), HttpStatus.OK);
  }

  @PutMapping("/education")
  public ResponseEntity<?> editEducation(@RequestBody Education data) {
    educServ.editEducation(data);
    return new ResponseEntity(new Mensaje("Educacion Editada"), HttpStatus.OK);
  }

  @DeleteMapping("/education/{id}")
  public ResponseEntity<?> deleteEducation(@PathVariable Long id) {
    educServ.deleteEducation(id);
    return new ResponseEntity(new Mensaje("Educacion Borrada"), HttpStatus.OK);
  }

  @GetMapping("/project")
  public ResponseEntity<List<Project>> getProjects() {
    return new ResponseEntity(projServ.getProjectList(), HttpStatus.OK);
  }

  @GetMapping("/project/{id}")
  public ResponseEntity<Project> getProject(@PathVariable Long id) {
    return new ResponseEntity(projServ.getProject(id), HttpStatus.OK);
  }

  @PostMapping("/project")
  public ResponseEntity<?> addProject(@RequestBody Project data) {
    projServ.addProject(data);
    return new ResponseEntity(new Mensaje("Proyecto Agregado"), HttpStatus.OK);
  }

  @PutMapping("/project")
  public ResponseEntity<?> editProject(@RequestBody Project data) {
    projServ.editProject(data);
    return new ResponseEntity(new Mensaje("Proyecto Editado"), HttpStatus.OK);
  }

  @DeleteMapping("/project/{id}")
  public ResponseEntity<?> deleteProject(@PathVariable Long id) {
    projServ.deleteProject(id);
    return new ResponseEntity(new Mensaje("Proyecto Borrado"), HttpStatus.OK);
  }
  
}
