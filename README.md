https://www.bilibili.com/video/av22613028?from=search&seid=6300526865129092736  学习网站
 
https://github.com/ZeroVV/microservicecloud/blob/master/microservicecloud-api/pom.xml  github辅助类

                                           SpringCloud:

                         微服务优点:
每个服务足够内聚,足够小,代码容易理解这样能聚集一个指定的业务功能或业务需求
开发简单、开发效率提高: 一个服务可能就是专一的只干一件事
微服务能够被小团队单独开发,这个小团队是2到5人的开发人员组成
减耦,不参与静态资源页面编写

                         微服务缺点:
部署麻烦
开发人员要处理分布式系统的复杂性
运维压力大,服务间通信成本,数据一致性,性能监控


                         springCloud技术栈:

服务治理   服务注册  服务调用  服务监控  服务负载均衡
相应的技术纬度与落地技术:
服务开发: springboot  spring  springMVC
服务配置与管理:Netflix公司的Archaius、阿里的Diamond等
服务注册与发现:Eureka  consul  Zookeeper等
服务调用:REST RPC gRPC
服务熔断器:Hystrix、Envoy
负载均衡:Ribbon、Nginx等
服务接口调用:Feign
消息队列:Kafka  RabbitMQ  ActiveMQ
服务配置中心管理: springCloudConfig  chef
服务路由:zuul等
服务监控:Zabbix  nagios metrics
全链路跟踪:zipkin Brave Dapper
服务部署:Docker  OpenStack  Kubernetes
数据流操作开发包:springCloud Stream
事件消息总线:springCloudBus

Springboot 与 SpringCloud:
SrpingBoot   专注于快速、方便 开发单个个体微服务
SpringCloud  专注于全局的服务治理框架
SpringCloud必然依赖Springboot 

Dubbo 与 SpringCloud:
SpringCloud抛弃了Dubbo的RPC通信,采用的是基于HTTP的REST方式
社区支持更新力度

项目的打包类型：pom、jar、war
packing默认是jar类型，
<packaging>pom</packaging>      --------->   父类型都为pom类型
<packaging>jar</packaging>      --------->   内部调用或者是作服务使用
<packaging>war</packaging>      --------->   需要部署的项目

Eureka服务注册与发现  
    Eureka Server:服务注册中心,Eureka Client:一个JAVA客户端
    Service Provider服务提供方将自身服务注册到Eureka,从而使服务消费方能够找到
    Service Consumer服务消费方从Eureka获取注册服务列表,从而能够进行服务消费
    
Eureka自我保护机制的工作机制是(可以手动禁掉,但是不推荐,在eureka service端 yml文件配置)：
    如果在15分钟内超过85%的客户端节点都没有正常的心跳，
    那么Eureka就认为客户端与注册中心出现了网络故障，Eureka Server自动进入自我保护机制，此时会出现以下几种情况：
    1.Eureka Server不再从注册列表中移除因为长时间没收到心跳而应该过期的服务。
    2.Eureka Server仍然能够接受新服务的注册和查询请求，但是不会被同步到其它节点上，保证当前节点依然可用。
    3.当网络稳定时，当前Eureka Server新的注册信息会被同步到其它节点中。
    因此Eureka Server可以很好的应对因网络故障导致部分节点失联的情况，而不会像ZK那样如果有一半不可用的情况会导致整个集群不可用而变成瘫痪。
    
Eureka集群:
 本地IP集群映射    C:\Windows\System32\drivers\etc\host    
                              127.0.0.1 eureka7001.com  
                              127.0.0.1 eureka7002.com    
                              127.0.0.1 eureka7003.com
           
Eureka比Zookeeper好在哪里
zookeeper 保证的是CP(数据一致性)       Eureka  保证的是AP(高可用性)
zookeeper集群 master节点宕机后,其他剩余存活点重写进行leader选举,整个过程需要30~120秒,期间整个注册服务瘫痪
Eureka集群  各个节点平等无主次之分,某个节点宕机后,剩余节点依旧可以提供注册和查询服务
  
Ribbon:
       是Netflix Ribbon实现的一套客户端  负载均衡工具
          