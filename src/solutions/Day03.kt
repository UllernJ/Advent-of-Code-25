package solutions

import utils.readInput

val input = readInput("Day03")
    .map { it -> it.split("")
    .filter { !it.isEmpty() }
    .map(String::toInt) }

fun maxTwoDigitNumber(digits: List<Int>): Int {
    var best = 0
    for (i in digits.indices) {
        val a = digits[i]
        for (j in i+1 until digits.size) {
            val b = digits[j]
            best = maxOf(best, a * 10 + b)
        }
    }
    return best
}

fun main() {
    val sum = input.sumOf {
        maxTwoDigitNumber(it)
    }
    println(sum)
}