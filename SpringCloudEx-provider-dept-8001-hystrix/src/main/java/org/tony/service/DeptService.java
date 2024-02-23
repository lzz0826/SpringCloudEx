package org.tony.service;

import java.util.List;
import org.tony.entities.Dept;

public interface DeptService {

  public boolean add(Dept dept);

  public Dept get(Long id);

  public List<Dept> list();

}
