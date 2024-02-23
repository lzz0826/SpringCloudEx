package org.tony.service;

import org.springframework.stereotype.Service;
import org.tony.dao.TestCglibDao;
import org.tony.factory.ProxyFactory;

@Service
public class CGlibService {

  private static volatile TestCglibDao proxyFactory;
  public TestCglibDao getTestCglibDaoProxy() {

    if (proxyFactory == null) {
      synchronized (CGlibService.class){
        if(proxyFactory == null){
          TestCglibDao dao = new TestCglibDao();
          this.proxyFactory = (TestCglibDao) new ProxyFactory(dao).getProxyInstance();
        }
      }
    }
    return proxyFactory;
  }
}