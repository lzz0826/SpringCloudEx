package org.tony.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
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


  @GetMapping("/dept/get/{id}")
  //@HystrixCommand 可以在DeptService實現使用FallbackFactory<> 可以做到切面統一管理
  //@HystrixCommand 如要監控必須添加
  @HystrixCommand(fallbackMethod = "processGetHystrix")
  public Dept get(@PathVariable("id") Long id){

    Dept dept = deptService.get(id);
    if(dept == null){
      throw new RuntimeException("該ID: "+ id + "沒有對應訊息");
    }
    return dept;
  }

  public Dept processGetHystrix(@PathVariable("id") Long id){

    return new Dept().setDeptno(id).setDname("該ID: "+ id + "沒有對應訊息,null--HystrixCommand")
        .setDb_source("no this database in MySql");
  }



}










