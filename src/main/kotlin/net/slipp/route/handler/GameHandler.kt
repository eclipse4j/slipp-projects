package net.slipp.route.handler

import net.slipp.racingcar.model.RacingPlayer
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyExtractor
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono

@Component
class GameHandler  {
    fun index() : Mono<String> {
        return Mono.just("Hello World")
    }

    fun play(req: ServerRequest): Mono<ServerResponse> {
        return req.bodyToMono(RacingPlayer::class.java).flatMap { m ->
            ServerResponse.status(HttpStatus.ACCEPTED).body(BodyInserters.fromObject(m))
        }.flatMap { ServerResponse.ok().render("play", it) }
    }

}