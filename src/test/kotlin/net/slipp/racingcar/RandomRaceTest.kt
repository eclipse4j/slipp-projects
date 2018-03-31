package net.slipp.racingcar

import org.junit.Test

class RandomRaceTest {
    @Test
    fun test_game_play(){
        var players = arrayListOf<Player>(Player(playerName = "kkk", pos = 5))
        var gamePlay = GamePlay(count = 1, players = players)
        assert(gamePlay.count == 1)
    }
}