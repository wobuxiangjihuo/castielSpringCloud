package com.xuhang.myrule;


import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancer;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

/**重写规则算法 依照原RandomRule  每个服务调用5次,进入下一个服务*/
public class RandomRule_XH extends AbstractLoadBalancerRule
{
    //当total==5 以后,下标才能往下走,并且index+1, 并且index 不能超过服务器数量(3)
    private int index=0;
    private int total=0;

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        else
        {
            Server server = null;

            while(server == null)
            {
                    if (Thread.interrupted())
                    {
                        return null;
                    }
                     //获取所有正常服务
                    List<Server> upList = lb.getReachableServers();
                    //获取所有服务
                    List<Server> allList = lb.getAllServers();
                    int serverCount = allList.size();
                    if (serverCount == 0)
                    {
                        return null;
                    }

                   if(total<5)
                   {
                       server=server = (Server)upList.get(index);
                       total++;
                   }
                   else
                   {
                       total=0;
                       index++;
                       if(index>=upList.size())
                       {
                           index=0;
                       }
                   }

                    if (server == null)
                    {
                        Thread.yield();
                    }
                    else
                    {
                        if (server.isAlive())
                        {
                            return server;
                        }
                        //如果server没有存活
                        server = null;
                        Thread.yield();
                    }
            }

            return server;
        }
    }
    @Override
    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }
    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
