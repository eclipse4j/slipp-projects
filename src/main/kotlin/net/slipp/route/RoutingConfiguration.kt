package net.slipp.route


import net.slipp.racingcar.model.RacingPlayer
import net.slipp.route.handler.GameHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.BodyExtractors
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Mono




@Configuration
class RoutingConfiguration {

    @Bean
    fun routeFunction(handler: GameHandler) : RouterFunction<ServerResponse> = router {
        ("/").nest {
            GET("/reactive/index") { req ->
                ServerResponse.ok().body(
                        handler.index()
                )
            }
            GET("/reactive/role") { req ->
                ServerResponse.ok().render("role")
            }
            POST("/reactive/play", handler::play)
        }
    }

}