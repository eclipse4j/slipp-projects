package net.slipp.controller

import net.slipp.racingcar.Player
import net.slipp.service.GameService
import net.slipp.racingcar.model.RacingPlayer
import reactor.core.publisher.Flux
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RestController
import java.time.Duration
import java.util.stream.Stream



/**
 * curl -H "Content-Type: application/json" -X GET -d '{"playersName" : "kim,dfe"}' http://localhost:8080/game/play
 */
@RestController
internal class StockTransactionController(val gameService: GameService) {

    @GetMapping(value ="/game/play-stream", produces = arrayOf( MediaType.TEXT_EVENT_STREAM_VALUE ))
    fun play(racingPlayer: RacingPlayer): Flux<List<Player>> {
        var playCount = racingPlayer.playCount
        val interval = Flux.interval(Duration.ofSeconds(1)).take(playCount)
        val stockTransactionFlux = Flux.fromStream(Stream.generate<List<Player>> { gameService.getOneGameResult(racingPlayer) })
        var streamWinners = Flux.zip(interval, stockTransactionFlux).map { it.t2 }
        return streamWinners
    }

    @GetMapping(value ="/game/play-score")
    fun scores() = gameService.findAllPlayerScore()

}