# Slipp : Kotlin Study

https://www.slipp.net/wiki/pages/viewpage.action?pageId=28278790


# Kotlin 프로젝트에서 Spring Boot 2.0.0 으로 전환

build.gradle

```groovy

ext.spring_boot_version = '2.0.0.BUILD-SNAPSHOT'
...
repositories {
    maven {url 'https://repo.spring.io/libs-milestone'}
    maven {url 'https://repo.spring.io/libs-snapshot'}
    maven {url 'https://repo.spring.io/plugins-snapshot'}
}
...
apply plugin: 'io.spring.dependency-management'
apply plugin: 'org.springframework.boot'
...
testCompile("org.springframework.boot:spring-boot-starter-test")

compile("org.springframework.boot:spring-boot-starter")
compile("org.springframework.boot:spring-boot-starter-webflux")
...
```

아래를 포함 시키면 webflux의 라우트는 사용할 수 없다.

```
compile("org.springframework.boot:spring-boot-starter-web")
```


