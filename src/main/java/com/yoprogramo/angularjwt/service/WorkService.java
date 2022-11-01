package com.yoprogramo.angularjwt.service;

import com.yoprogramo.angularjwt.service.interfaces.IWorkService;
import com.yoprogramo.angularjwt.entity.Work;
import com.yoprogramo.angularjwt.repository.WorkRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkService implements IWorkService {

  @Autowired
  public WorkRepository workRepo;

  @Override
  public List<Work> getWorkList() {
    return workRepo.findAll();
  }

  @Override
  public Work getWork(Long id) {
    return workRepo.findById(id).orElse(null);
  }

  @Override
  public void addWork(Work work) {
    workRepo.save(work);
  }

  @Override
  public void editWork(Work work) {
    workRepo.save(work);
  }

  @Override
  public void deleteWork(Long id) {
    workRepo.deleteById(id);
  }

}
