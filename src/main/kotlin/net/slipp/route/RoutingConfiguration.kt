package net.slipp.route


import net.slipp.route.handler.GamePlayHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router




@Configuration
class RoutingConfiguration {


    @Bean
    fun routeFunctionIntro(handler: GamePlayHandler) : RouterFunction<ServerResponse> = router {
        ("/").nest {
            GET("/game/wait") { req ->
                ServerResponse.ok().render("role")
            }
            POST("/game/play-score", handler::savePlayerScore)
        }
    }

}