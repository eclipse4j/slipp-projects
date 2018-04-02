# Slipp : Kotlin Study

https://www.slipp.net/wiki/pages/viewpage.action?pageId=28278790


# Kotlin 프로젝트에서 Spring Boot 2.0.0 으로 전환

build.gradle

```groovy

ext.spring_boot_version = '2.0.0.BUILD-SNAPSHOT'

```

mongoDB를 local 사용할수 있도록 Docker Compose를 사용한다.

$ docker-compose up -d


아래를 포함 시키면 webflux의 라우트는 사용할 수 없다.

```
compile("org.springframework.boot:spring-boot-starter-web")
```


