# spring cloud alibaba

sca 的练习例子

## 环境依赖

- jdk8
- docker
- intellij idea

## nacos、sentinel dashboard启动

1. nacos

```
cd nacos-docker-dashboard
docker-compose -f example/standalone-mysql-8.yaml up
```
> 配置请自行修改： nacos-docker-dashboard/build/conf

- 访问:
http://localhost:8848/
- 账号: nacos/nacos

2. sentinel

```
cd sentinel-docker-dashboard
docker-compose up
```

- 访问：http://localhost:8081/
- 账号：admin/admin

## 教程

学习视频教程，百度尚硅谷spring cloud2020课程，找到spring cloud alibaba（第18节），开始学习