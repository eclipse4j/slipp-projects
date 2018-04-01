package net.slipp

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@ComponentScan("net.slipp")
@SpringBootApplication
@EnableMongoRepositories
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
