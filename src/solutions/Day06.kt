package solutions

import utils.readInput

private val input = readInput("Day06").map { it -> it.split(" ").filter { it.isNotEmpty() } }

fun main() {
    solvePart1()
}

private fun solvePart1() {
    val map = mutableMapOf<Int, MutableList<Int>>()
    var sum = 0L
    input.forEach { it ->
        it.forEachIndexed { indexY, num ->
            if (num.toIntOrNull() == null) {
                sum += calculateList(map[indexY], num)
            } else {
                map.getOrPut(indexY) { mutableListOf() }.add(num.toInt())
            }
        }
    }
    println(sum)
}

private fun calculateList(list: MutableList<Int>?, operator: String): Long {
    var sum = 0L
    when (operator) {
        "+" -> {
            list?.forEach {
                sum += it
            }
        }
        "*" -> {
            sum = 1
            list?.forEach {
                sum *= it
            }
        }
    }
    return sum
}