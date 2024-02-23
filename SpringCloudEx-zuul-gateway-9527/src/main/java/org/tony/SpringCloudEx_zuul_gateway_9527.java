package org.tony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication()
//啟用Zuul gateway
@EnableZuulProxy
public class SpringCloudEx_zuul_gateway_9527 {
  //通過zuul訪問8001服務API myzuul.com(127.0.0.1 hosts改) springcloudex-dept(eureka上註冊的服務)
  // dept/get/1(URI)
  //http://myzuul.com:9527/springcloudex-dept/dept/get/1

  //加上前綴 與 自訂隱藏真實服務名
//  http://myzuul.com:9527/tony/mydept/dept/get/1
  public static void main(String[] args) {
    SpringApplication.run(SpringCloudEx_zuul_gateway_9527.class,args);

  }

}
