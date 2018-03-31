package net.slipp.service

import net.slipp.racingcar.GamePlay
import net.slipp.racingcar.Player
import net.slipp.racingcar.model.RacingPlayer
import org.springframework.stereotype.Component
import java.util.ArrayList

@Component
class GameService  {
    fun separatePlayer(playersName: String): ArrayList<Player> {
        var players = playersName.split(',').asSequence().map { o-> Player(playerName = o, pos = 0) }.toList()
        return ArrayList(players)
    }

    fun getOneGameResult(racingPlayer: RacingPlayer): List<Player>{
        var gamePlay = GamePlay(1, separatePlayer(racingPlayer.playersName))
        var winnners = gamePlay.getGamePlayAndResult()
        return winnners
    }
}