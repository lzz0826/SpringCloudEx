package org.tony;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
//開啟服務監控 http://localhost:9001/hystrix
@EnableHystrixDashboard
public class SpringCloudEx_consumer_hystrix_dashboard {

  public static void main(String[] args) {
    SpringApplication.run(SpringCloudEx_consumer_hystrix_dashboard.class,args);
  }

}
