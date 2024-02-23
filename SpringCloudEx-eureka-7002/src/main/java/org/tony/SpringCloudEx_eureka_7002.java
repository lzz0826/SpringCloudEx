package org.tony;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEx_eureka_7002 {

  public static void main(String[] args) {
    SpringApplication.run(SpringCloudEx_eureka_7002.class,args);
  }

}
