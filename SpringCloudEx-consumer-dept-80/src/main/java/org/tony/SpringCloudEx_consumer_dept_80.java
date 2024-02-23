package org.tony;


import org.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient//#Ribbon必須配合 eureka

//啟動自定義Ribboon附載均衡規則 在啟動該服務的時候就能去加載自定義的Ribboon配置類 *不能在SpringBootApplication目錄 或之下
@RibbonClient(name = "SPRINGCLOUDEX-DEPT",configuration = MySelfRule.class)
public class SpringCloudEx_consumer_dept_80 {

  public static void main(String[] args) {
    SpringApplication.run(SpringCloudEx_consumer_dept_80.class,args);
  }

}
