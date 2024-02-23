package org.tony;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEx_config_eureka_client_7001 {

  public static void main(String[] args) {
    SpringApplication.run(SpringCloudEx_config_eureka_client_7001.class,args);
  }

}
