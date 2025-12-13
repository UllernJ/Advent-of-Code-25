package solutions

import utils.readInput

private val input = readInput("Day05")

fun main() {
    val numsIndex = input.indexOf("") + 1

    val ranges = input.subList(0, numsIndex - 1)
        .map { it.split("-").map(String::toLong) }
    val nums = input.subList(numsIndex, input.size)
        .map(String::toLong)
    println(solvePart1(ranges, nums))
}

fun solvePart1(ranges: List<List<Long>>, nums: List<Long>): Int {
    var numFresh = 0
    nums.forEach { num ->
        if (ranges.any { range ->
                range.zipWithNext().any { (start, end) ->
                    num in start until end
                }
            }) {
            numFresh++
        }
    }
    return numFresh
}