package org.tony.controller;


import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.tony.entities.Dept;

//Ribbon+RestTemplate
@RestController
public class DeptController_Consumer {
  //DeptController_Consumer 不會使用到server層 只會掉用其他服務

  //單機
//  private static final String REST_URL_PREFIX = "http://127.0.0.1:8001";

  //配合Eureka 使用動態(微服務名) 不用再關心端口
  private static final String REST_URL_PREFIX = "http://SPRINGCLOUDEX-DEPT";


  //(url,requestMap,ResponseBen.class)
  @Resource
  private RestTemplate restTemplate;

  @GetMapping("/consumer/dept/discovery")
  public Object discover(){
    return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery",Object.class);
  }

  @PostMapping("/consumer/dept/add")
  public boolean add(Dept dept){
    return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept, Boolean.class);
  }

  @GetMapping("/consumer/dept/get/{id}")
  public Dept get(@PathVariable("id") Long id){
    return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
  };


  @GetMapping("/consumer/dept/list")
  public List<Dept> list(){
    return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
  };

}
