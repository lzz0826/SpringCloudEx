package org.tony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication()
@EnableEurekaClient //自動註冊Eureka服務端
@EnableDiscoveryClient // 启用服务发现功能，支持通过服务发现的方式与其他服务进行通信
public class SpringCloudEx_config_dept_client_8001 {

  //intellij idea 多台環境參數配置
// Add VM options: -Dserver.port=8003
// Override configuration properties: spring.datasource.url   jdbc:mysql://localhost:13307/clouddb02?useUnicode=true&characterEncoding=utf-8
//指定yml Environment variables: --spring.config.location=/Users/sai/Desktop/application.yml
  public static void main(String[] args) {
    SpringApplication.run(SpringCloudEx_config_dept_client_8001.class,args);

  }

}
