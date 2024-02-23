package org.tony.service;

import feign.hystrix.FallbackFactory;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.tony.entities.Dept;


@Component//**必須要加上
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

  @Override
  public DeptClientService create(Throwable throwable) {
    return new DeptClientService() {
      @Override
      public boolean add(Dept dept) {
        return false;
      }

      @Override // @PathVariable("id") **記得
      public Dept get(@PathVariable("id") Long id) {
        return new Dept().setDeptno(id).setDname("該ID: "+ id + "沒有對應訊息,Consumer客戶端提供的降級 此時的Provider已經關閉")
            .setDb_source("no this database in MySql");
      }

      @Override
      public List<Dept> list() {
        return null;
      }
    };
  }
}
