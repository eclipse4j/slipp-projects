package net.slipp.utils

fun String.repeatWith(n: Int) : String  {
    var that = this
    (0..n).forEach { that += this }
    return that
}