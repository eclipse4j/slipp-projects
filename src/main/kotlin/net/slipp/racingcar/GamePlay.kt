package net.slipp.racingcar


class GamePlay(var count:Int = 0, var players: ArrayList<Player>){

    fun getGamePlayAndResult():List<Player>{
        this.play()
        return players
    }

    fun play(){
        for ( i in 0..(count-1) ) {
            for (p in players ) {
                p.move()
            }
        }

    }
}