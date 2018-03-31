package net.slipp.route


import net.slipp.route.handler.GamePageHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router




@Configuration
class RoutingConfiguration {

    @Bean
    fun routeFunctionIntro(handler: GamePageHandler) : RouterFunction<ServerResponse> = router {
        ("/").nest {
            GET("/game/wait") { req ->
                ServerResponse.ok().render("role")
            }
        }
    }

}