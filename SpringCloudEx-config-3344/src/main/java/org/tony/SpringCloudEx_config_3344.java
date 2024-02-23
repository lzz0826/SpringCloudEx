package org.tony;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
//開啟配置中心
@EnableConfigServer
public class SpringCloudEx_config_3344 {

  //config-3344.com(hosts上127.0.0.1)

  //http://config-3344.com:3344/application-dev.yml
  //http://config-3344.com:3344/application-test.yml
//  對應/SpringCloudEx/SpringCloudEx-config-3344/src/main/configTxt裡的yml *放在github上

  /*規則
  * /{application}/{profile}[/{label}]
  * /{application}-{profile}.yml
  * /{label}/{application}-{profile}.yml
  * /{application}/{profile}.properties
  * /{label}/{application}-{profile}.properties
  * */

  public static void main(String[] args) {
    SpringApplication.run(SpringCloudEx_config_3344.class,args);
  }

}
