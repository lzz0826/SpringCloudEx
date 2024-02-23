package org.tony;


import org.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient//#Ribbon必須配合 eureka
@EnableFeignClients//Feign
//Feign 可以搭配RibbonClient自訂附載均衡
//@RibbonClient(name = "SPRINGCLOUDEX-DEPT",configuration = MySelfRule.class)
//@EnableFeignClients(basePackages = {"org.tony"})//Feign
//@ComponentScan("org.tony")

public class SpringCloudEx_consumer_dept_feign {

  public static void main(String[] args) {
    SpringApplication.run(SpringCloudEx_consumer_dept_feign.class,args);
  }

}
