package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

//自己实现负载均衡算法
public interface LoadBalancer {
  ServiceInstance instance(List<ServiceInstance> serviceInstances) ;
}
