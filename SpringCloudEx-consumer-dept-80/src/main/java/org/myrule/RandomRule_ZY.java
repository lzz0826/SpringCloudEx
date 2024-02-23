package org.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

//自定義(用官方git上的改):輪詢 - 每服務調用五次才換下一個
public class RandomRule_ZY extends AbstractLoadBalancerRule {


  // total = 0 當前total==5後 指針才能往下
  // index = 0 當前對外提供的服務的服務器地址
  // total需要重置歸零 但是已經達到過一個5次 我們index = 1
  // 分析 我們5次  但是服務只有三台 三台後需要回到第一台

  private int total = 0;//總共被調用數 目前每台要求5次
  public int currentIndex = 0;//當前提供服務的機器好

  public Server choose(ILoadBalancer lb, Object key) {
    if (lb == null) {
      return null;
    }
    Server server = null;

    while (server == null) {
      if (Thread.interrupted()) {
        return null;
      }
      List<Server> upList = lb.getReachableServers();
      List<Server> allList = lb.getAllServers();

      int serverCount = allList.size();
      if (serverCount == 0) {
        /*
         * No servers. End regardless of pass, because subsequent passes
         * only get more restrictive.
         */
        return null;
      }

//      修改的
//      int index = chooseRandomInt(serverCount);
//      server = upList.get(index);

      if(total < 5){
        server = upList.get(currentIndex);
        total++;
      }else {
        total = 0;
        currentIndex++;
        if(currentIndex >= upList.size()){
          currentIndex = 0;
        }
      }



      if (server == null) {
        /*
         * The only time this should happen is if the server list were
         * somehow trimmed. This is a transient condition. Retry after
         * yielding.
         */
        Thread.yield();
        continue;
      }

      if (server.isAlive()) {
        return (server);
      }

      // Shouldn't actually happen.. but must be transient or a bug.
      server = null;
      Thread.yield();
    }

    return server;

  }

  protected int chooseRandomInt(int serverCount) {
    return ThreadLocalRandom.current().nextInt(serverCount);
  }

  @Override
  public Server choose(Object key) {
    return choose(getLoadBalancer(), key);
  }

  @Override
  public void initWithNiwsConfig(IClientConfig iClientConfig) {

  }
}
