package org.tony.cfgbeans;


import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
//boot -->spring applicationContext.xml --- @Configuration配製  ConfigBean = applicationContext.xml
public class ConfigBean {


  @Bean
  @LoadBalanced//Spring Cloud Ribbon是基於Netflix Ribbon實現的一套客戶端 附載衡的工具
  public RestTemplate getRestTemplate(){
    return new RestTemplate();
  }

  //顯示聲明規則 用來指定附載均衡規則
  @Bean
  public IRule myRule(){
     return new RoundRobinRule();  // 輪詢（Round Robin）規則，按照輪詢的方式依次選擇服務實例
    // return new AvailabilityFilteringRule();  // 可用性過濾（Availability Filtering）規則，忽略掉一些因為連接故障而過時的服務實例，選擇其中一個可用的服務實例
    // return new WeightedResponseTimeRule();  // 加權響應時間（Weighted Response Time）規則，根據服務實例的響應時間和加權選擇服務實例
//     return new RetryRule();  // 重試（Retry）規則，先按照輪詢的方式選擇服務實例，如果選擇失敗，則會在指定的時間內進行重試
    // return new BestAvailableRule();  // 最佳可用性（Best Available）規則，選擇其中一個可用的服務實例，如果所有實例都不可用，則會選擇一個錯誤的實例
    // return new ZoneAvoidanceRule();  // 區域避免（Zone Avoidance）規則，根據服務實例的區域信息，避免選擇到相同區域內的服務實例，從而實現高可用性和容錯性

//    return new RandomRule(); // 使用隨機（Random）規則

  }


}

//  @Bean
//  public UserService getUserService(){
//    return new UserServiceImpl();
//  }
// applicationContext.xml == ConfigBen(@Configuration)
//<bean id ="userService" class="com.atguigu.tmall.UserviceImpl">