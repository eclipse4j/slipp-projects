package net.slipp.racingcar

class GamePlay(var count:Int = 0, var players: ArrayList<Player>){

    fun printResult(){
        var winnerPosition = players.maxBy { it.pos }!!.pos
        var winnerPlayers = players.filter { p -> p.pos ==  winnerPosition}
        var winners = winnerPlayers.joinToString(",") {it.name}
        println("최종 승리자는 ${winners} 입니다.")

    }

    fun play(){
        for ( i in 0..(count-1) ) {
            for (p in players ) {
                p.move()
                p.display()
            }
            println()
        }

    }
}