package net.slipp.route.handler

import net.slipp.racingcar.GamePlay
import net.slipp.racingcar.Player
import net.slipp.racingcar.model.RacingPlayer
import net.slipp.racingcar.model.RacingResult
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import java.util.ArrayList

@Component
class GameHandler  {
    fun index() : Mono<String> {
        return Mono.just("Hello World")
    }

//    fun play(req: ServerRequest): Mono<ServerResponse> {
//        return req.bodyToMono(RacingPlayer::class.java).flatMap { m ->
//            ServerResponse.status(HttpStatus.ACCEPTED).body(BodyInserters.fromObject(m))
//        }.flatMap { ServerResponse.ok().render("play", it) }
//    }

    fun play(req: ServerRequest): Mono<ServerResponse> {
        var players = ArrayList<Player>()
        return req.bodyToMono(RacingPlayer::class.java).flatMap { m ->
            var playerNames = m.playersName.split(',')
            playerNames.forEach { o->players.add(Player(playerName = o, pos = 0)) }
            var gamePlay = GamePlay(5, players)
            gamePlay.play()
            var winnners = gamePlay.getGameResult()
            var racingWinner = RacingResult(winnners)
            ServerResponse.status(HttpStatus.ACCEPTED).body(BodyInserters.fromObject(racingWinner))
                    .switchIfEmpty(ServerResponse.status(HttpStatus.NOT_FOUND).build())
        }
    }
}