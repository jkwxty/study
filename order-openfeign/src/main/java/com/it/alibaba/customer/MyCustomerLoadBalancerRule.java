package com.it.alibaba.customer;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.Server.MetaInfo;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 *
 * @author JiangKangWei
 * @create 2022/8/19 9:16
 */
public class MyCustomerLoadBalancerRule extends AbstractLoadBalancerRule {

  @Override
  public void initWithNiwsConfig(IClientConfig iClientConfig) {

  }

  @Override
  public Server choose(Object o) {
    ILoadBalancer loadBalancer = this.getLoadBalancer();
    List<Server> allServers = loadBalancer.getAllServers();
    Map<Integer, MetaInfo> serverMap = allServers.stream()
        .collect(Collectors.toMap(Server::getPort, Server::getMetaInfo));
    if(serverMap!=null&&serverMap.size()>0){
      serverMap.forEach((key,value)->{
        System.out.println("端口："+key+"==="+"服务名:"+value.getAppName());
      });
    }
    int i = ThreadLocalRandom.current().nextInt(allServers.size());
    return allServers.get(i);
  }
}
