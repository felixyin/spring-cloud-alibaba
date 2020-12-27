# spring cloud alibaba

sca 的练习例子

## 环境依赖

- jdk8
- docker
- intellij idea
- lazydocker（可选）

## nacos、sentinel dashboard启动

### nacos 单点

```
cd nacos-docker-dashboard
docker-compose -f example/standalone-mysql-8.yaml up # 单点
```
> 配置请自行修改： nacos-docker-dashboard/build/conf

- 访问:
http://localhost:8848/nacos
- 账号: nacos/nacos

### nacos 集群

1. 修改docker内存为7G以上

注意事项：docker内存至少7G，一个节点2G * 3个节点 + mysql数据库

2. example/cluster-hostname.yaml 自行修改配置

可使配置用宿主机的mysql。。。

3. 启动：
```
docker-compose -f example/cluster-hostname.yaml up
```

> 注意：如果启动失败，请删除mysql目录（docker虚拟机挂在的mysql数据存储的目录），注意，这可能导致你的数据丢失。

- 访问:
http://localhost:8848/nacos
- 账号: nacos/nacos
- 集群管理 --》 节点列表 ，可以看到3个节点

2. sentinel

```
cd sentinel-docker-dashboard
docker-compose up
```

- 访问：http://localhost:8081/
- 账号：admin/admin

## 教程

学习视频教程，百度尚硅谷spring cloud2020课程，找到spring cloud alibaba（第18节），开始学习