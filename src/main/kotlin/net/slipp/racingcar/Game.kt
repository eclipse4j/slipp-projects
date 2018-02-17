package net.slipp.racingcar

import java.util.*

class Game {

    fun inputPlayer(): ArrayList<Player> {
        var players = ArrayList<Player>()
        print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분) : ")
        var playerName:String = readLine()!!
        var playerNames = playerName.split(',')
        playerNames.forEach { o->players.add(Player(playerName = o, pos = 0)) }
        return players
    }

    fun inputGameCount() : Int{
        print("경기 수  : ")
        var gameCount:Int = readLine()!!.toInt()
        return gameCount
    }
}