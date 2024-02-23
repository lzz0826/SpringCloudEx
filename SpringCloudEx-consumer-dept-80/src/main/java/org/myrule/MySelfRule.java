package org.myrule;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//給Ribbo自定附載均衡的累 不能跟主啟動或之下目錄 @ComponentScan之下不行
@Configuration
public class MySelfRule {

  @Bean
  public IRule myRule(){
//    return new RandomRule(); // 使用隨機（Random）規則
    return new RandomRule_ZY(); // 自定義的
  }
}
