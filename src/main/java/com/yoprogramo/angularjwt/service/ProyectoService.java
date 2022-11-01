package com.yoprogramo.angularjwt.service;

import com.yoprogramo.angularjwt.service.interfaces.IProyectoService;
import com.yoprogramo.angularjwt.entity.Project;
import com.yoprogramo.angularjwt.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService {

    @Autowired
    public ProyectoRepository projRepo;

    @Override
    public List<Project> getProjectList() {
        return projRepo.findAll();
    }

    @Override
    public Project getProject(Long id) {
        return projRepo.findById(id).orElse(null);
    }

    @Override
    public void addProject(Project proj) {
        projRepo.save(proj);
    }

    @Override
    public void editProject(Project proj) {
        projRepo.save(proj);
    }

    @Override
    public void deleteProject(Long id) {
        projRepo.deleteById(id);
    }

}
