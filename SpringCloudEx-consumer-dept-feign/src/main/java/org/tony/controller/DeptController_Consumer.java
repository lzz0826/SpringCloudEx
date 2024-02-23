package org.tony.controller;


import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tony.entities.Dept;
import org.tony.service.DeptClientService;

//直接使用 Feign 找到服務街口 融合了 Ribbon 也支持附載均衡
@RestController
public class DeptController_Consumer {

  @Resource
  private DeptClientService deptClientService;


  @PostMapping("/consumer/feign/dept/add")
  public boolean add(Dept dept){
    return deptClientService.add(dept);
  }

  @GetMapping("/consumer/feign/dept/get/{id}")
  public Dept get(@PathVariable("id") Long id){
    return deptClientService.get(id);
  };


  @GetMapping("/consumer/feign/dept/list")
  public List<Dept> list(){
    return deptClientService.list();
  };

}
