package cglib;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tony.SpringCloudEx_provider_dept_8001;
import org.tony.dao.TestCglibDao;
import org.tony.factory.ProxyFactory;
import org.tony.service.CGlibService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringCloudEx_provider_dept_8001.class})
public class TestCGlib {


  @Resource
  public CGlibService cGlibService;

  @Test
  public void testCGlibServer(){
    TestCglibDao testCglibDaoProxy = cGlibService.getTestCglibDaoProxy();
    testCglibDaoProxy.test();
    String s = testCglibDaoProxy.testReturn();
    System.out.println(s);

  }

  @Test
  public void testCGlib(){
    //創建目標對象
    TestCglibDao target = new TestCglibDao();
    //獲取到代理對象 並且將目標對象傳遞給代理對象
    TestCglibDao proxyInstance = (TestCglibDao) new ProxyFactory(target).getProxyInstance();
    //執行代理對象方法 觸發intecept 方法實現對目標對象的調用
    proxyInstance.test();
    //返回
    String s = proxyInstance.testReturn();
    System.out.println(s);

  }

}
