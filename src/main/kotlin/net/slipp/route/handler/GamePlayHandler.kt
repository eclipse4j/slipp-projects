package net.slipp.route.handler

import net.slipp.racingcar.mongodb.model.PlayerScore
import net.slipp.racingcar.mongodb.repository.PlayerScoreRepository
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class GamePlayHandler (private val playerScoreRepository: PlayerScoreRepository) {

    fun savePlayerScore(req: ServerRequest) = req.bodyToMono(PlayerScore::class.java).flatMap {
        var playerScore = PlayerScore(name = it.name, score = it.score)
        playerScoreRepository.save(playerScore)
        ServerResponse.ok().build()
    }

    fun findAllPlayerScore()  =
         playerScoreRepository.findAll()
}