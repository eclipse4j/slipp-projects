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

    fun sepa(playersName: String):ArrayList<Player>{
        var players = ArrayList<Player>()
        var playerNames = playersName.split(',')
        playerNames.forEach { o->players.add(Player(playerName = o, pos = 0)) }
        return players
    }

    fun play(req: ServerRequest): Mono<ServerResponse> {
        return req.bodyToMono(RacingPlayer::class.java).flatMap { m ->
            var gamePlay = GamePlay(5, sepa(m.playersName))
            var winnners = gamePlay.getGamePlayAndResult()
            ServerResponse.status(HttpStatus.ACCEPTED).body(BodyInserters.fromObject(RacingResult(winnners)))
                    .switchIfEmpty(ServerResponse.status(HttpStatus.NOT_FOUND).build())
        }
    }
}