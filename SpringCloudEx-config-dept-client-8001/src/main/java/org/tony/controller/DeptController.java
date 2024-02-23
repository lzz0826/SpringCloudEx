package org.tony.controller;


import java.util.List;
import javax.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tony.entities.Dept;
import org.tony.service.DeptService;

@RestController
public class DeptController {

  @Resource
  private DeptService deptService;

  @Resource
  private DiscoveryClient client;



  @GetMapping("/dept/discovery")
  public Object discovery(){
    List<String> services = client.getServices();
    System.out.println("***"+services);

    List<ServiceInstance> instances = client.getInstances("SPRINGCLOUDEX-DEPT");
    for (ServiceInstance instance : instances) {
      System.out.println(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"
      +instance.getUri());
    }
    return this.client;

  }



  @PostMapping("/dept/add")
  public boolean add(@RequestBody Dept dept){
    return deptService.add(dept);
  };

  @GetMapping("/dept/get/{id}")
  public Dept get(@PathVariable("id") Long id){
    return deptService.get(id);
  };


  @GetMapping("/dept/list")
  public List<Dept> list(){
    return deptService.list();
  };



}
