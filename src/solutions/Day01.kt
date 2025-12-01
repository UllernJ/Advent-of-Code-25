package solutions

import utils.readInput

private val input = readInput("Day01")
private const val START = 50
private var current = START
private var result: Int = 0

fun solvePart1(value: String) {
    val (direction, value) = value.splitAtIndex(1)
    if (direction == "L") {
        current -= value.toInt()
    } else if (direction == "R") {
        current += value.toInt()
    }
    current %= 100

    if (current == 0) {
        result++
    }
}

fun main() {
    input.forEach { solvePart1(it)}
    println(result)
}

fun String.splitAtIndex(index: Int) = require(index in 0..length).let {
    take(index) to substring(index)
}
