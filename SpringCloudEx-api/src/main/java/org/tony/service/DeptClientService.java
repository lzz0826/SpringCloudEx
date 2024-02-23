package org.tony.service;


import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.tony.entities.Dept;

//@FeignClient(value = "SPRINGCLOUDEX-DEPT")//value 服務名

//fallbackFactory配置 Hystrix服務降級 這街口所有的熔斷處理都找DeptClientServiceFallbackFactory
@FeignClient(value = "SPRINGCLOUDEX-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)//value 服務名
public interface DeptClientService {


  @PostMapping("/dept/add")
  public boolean add(Dept dept);

  @GetMapping("/dept/get/{id}")
  public Dept get(@PathVariable("id")  Long id);

  @GetMapping("/dept/list")
  public List<Dept> list();


}
