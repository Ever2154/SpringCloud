package com.atguigu.springcloud.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassNameMyLB
 * @Description
 * @Author 黄皓
 * @Date2020/6/15 14:45
 **/
@Component
public class MyLB implements LoadBalancer {
    private AtomicInteger atomicInteger=new AtomicInteger(0);
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        if(serviceInstances==null||serviceInstances.size()==0)
            return null;
        int index=getAndIncrement()%serviceInstances.size();
        return serviceInstances.get(index);
    }
    private final int getAndIncrement(){
        int current;
        int next;
        do{
            current = atomicInteger.get();
            next = current==2147483647?0:current+1;
        }while(!atomicInteger.compareAndSet(current,next));
        System.out.println("第几次访问服务: "+next);
        return next;
    }
}
