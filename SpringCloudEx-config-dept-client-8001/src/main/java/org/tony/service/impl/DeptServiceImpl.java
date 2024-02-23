package org.tony.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.tony.dao.DeptDao;
import org.tony.entities.Dept;
import org.tony.service.DeptService;
//import org.tony.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

  @Resource
  private DeptDao dao;

  @Override
  public boolean add(Dept dept) {
    return dao.addDept(dept);
  }

  @Override
  public Dept get(Long id) {
    return dao.findById(id);
  }

  @Override
  public List<Dept> list() {
    return dao.findAll();
  }
}
