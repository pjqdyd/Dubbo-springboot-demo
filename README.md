### Dubbo-springboot-demo
(dubbo+springboot整合实现微服务的案例demo项目)


 开发环境:</br>
   >Jdk8</br>
   >Maven 3.5.4</br>
   >Docker version 18.09.2 [Docker Desktop for Windows]</br>
   >IntelliJ IDEA

#### 如何运行:

 1.先下载好zookeeper的镜像`docker pull zookeeper`.
 
 2.在docker-componse.yml文件所在目录下运行`docker-componse up -d`启动三个zookeeper容器.
 
 3.将项目导入到IDEA中, 根据pom下载好所有的依赖.
 
 4.在hello-dubbo-service-user-api模块下运行`mvn claen install`将接口模块安装进本地仓库,方便在提供者模块实现接口和消费者模块注入使用接口服务.

 5.先运行提供者provider的启动类启动提供者服务, 再运行消费者consumer的启动类启动消费者, 访问localhost:9090/user/hi接口测试服务.
 
 #### 提示:
 
   1.可以使用官方提供的dubbo-admin管理控制台来监控服务.
