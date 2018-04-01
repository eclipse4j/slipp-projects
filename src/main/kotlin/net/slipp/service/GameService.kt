package net.slipp.service

import net.slipp.racingcar.GamePlay
import net.slipp.racingcar.Player
import net.slipp.racingcar.model.RacingPlayer
import net.slipp.racingcar.mongodb.repository.PlayerScoreRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Component
import java.util.ArrayList

@Component
class GameService(private val playerScoreRepository: PlayerScoreRepository)  {
    fun separatePlayer(playersName: String): ArrayList<Player> {
        var players = playersName.split(',').asSequence().map { o-> Player(playerName = o, pos = 0) }.toList()
        return ArrayList(players)
    }

    fun getOneGameResult(racingPlayer: RacingPlayer): List<Player>{
        var gamePlay = GamePlay(1, separatePlayer(racingPlayer.playersName))
        var winnners = gamePlay.getGamePlayAndResult()
        return winnners
    }

    fun findAllPlayerScore()  =
            playerScoreRepository.findAll(PageRequest.of(0, 10, Sort.Direction.DESC, "score")).content
}