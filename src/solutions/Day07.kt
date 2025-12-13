package solutions

import utils.readInput

private val input = readInput("Day07").map { it.split("").toMutableList() }

fun main() {
    solvePart1()
}

private fun solvePart1() {
    val startPos = getStartingPosition(input)
    if(startPos != null) {
        waterFallFromPosition(input, startPos)
    }
    val sum = input.sumOf {
        it.sumOf { list -> list.count { char -> char == 'x'}}
    }
    println(sum)
}

private fun getStartingPosition(list: List<List<String>>): Pair<Int, Int>? {
    list.forEachIndexed { indexX, subList ->
        subList.forEachIndexed { indexY, value ->
            if(value == "S") {
                return Pair(indexX + 1, indexY)
            }
        }
    }
    return null
}
private fun waterFallFromPosition(
    list: List<MutableList<String>>,
    position: Pair<Int, Int>
) {
    val (posX, posY) = position

    for (x in posX until list.size) {
        if (list[x][posY] == ".") {
            list[x][posY] = "|"
            continue
        } else if(list[x][posY] == "^") {
            list[x][posY] = "x"
            waterFallFromPosition(list, Pair(x, posY - 1))
            waterFallFromPosition(list, Pair(x, posY + 1))
            break
        } else {
            break
        }
    }
}
