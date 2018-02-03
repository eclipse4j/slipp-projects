package net.slipp.racingcar

import java.util.concurrent.ThreadLocalRandom

class Player(var name:String, var pos:Int = 0) {

    private fun ClosedRange<Int>.random() = ThreadLocalRandom.current().nextInt(endInclusive - start) + start

    fun display(){
        print("$name : ")
        for ( i in 1..pos )
            print("-")
        println()

    }

    fun move(){
        var rd = (0..10).random()
        if (canIMove(rd)){
            pos = ( rd + pos )
        }
    }

    private fun canIMove(rd: Int) = rd >= 4

}

fun String.repeatWith(n: Int) : String  {
    var that = this
    (0..n).forEach { that += this }
    return that
}

fun main(args: Array<String>) {
    var s = "-".repeatWith(9)
    println(s)
}