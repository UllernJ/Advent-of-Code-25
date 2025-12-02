package solutions

import utils.readInput

fun solvePart1(input: List<String>): Long {
    var sum = 0L
    input.forEach {
        val (val1, val2) = it.split("-").map(String::toLong)
        for(i in val1..val2) {
            val intString = i.toString()
            if(intString.length % 2 == 0 && isValid(intString)) {
                sum += i
            }
        }
    }
    return sum
}

fun isValid(nums: String): Boolean {
    val half = nums.length / 2
    val firstHalf = nums.take(half)
    val secondHalf = nums.substring(half)
    return firstHalf == secondHalf
}

fun main() {
    val input = readInput("Day02").flatMap { it.split(",") }.filter { it.isEmpty().not() }
    val sum = solvePart1(input)
    println(sum)
}