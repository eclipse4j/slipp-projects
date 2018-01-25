package net.slipp.racingcar

import org.junit.Test

fun main(args: Array<String>) {
    var game = Game()
    var gamePlayers = game.inputPlayer()
    var gameCount = game.inputGameCount()
    var gamePlay = GamePlay(count = gameCount, players = gamePlayers)

    gamePlay.play()
    gamePlay.printResult()
}