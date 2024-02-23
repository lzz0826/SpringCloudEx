package org.tony;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCloudEx_config_client_3355 {

  //原本的3355會被8201 8202替換 bootstrap大於application (hosts:client-config.com 127.0.0.01)
//  http://client-config.com:8201/getConfig
//  http://client-config.com:8202/getConfig

  public static void main(String[] args) {
    SpringApplication.run(SpringCloudEx_config_client_3355.class,args);
  }

}
