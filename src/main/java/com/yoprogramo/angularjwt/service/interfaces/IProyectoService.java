package com.yoprogramo.angularjwt.service.interfaces;

import com.yoprogramo.angularjwt.entity.Project;
import java.util.List;

public interface IProyectoService {

    public List<Project> getProjectList();

    public Project getProject(Long id);

    public void addProject(Project proj);

    public void editProject(Project proj);

    public void deleteProject(Long id);

}
