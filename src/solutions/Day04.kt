import utils.readInput

private val input = readInput("Day04")
    .map { it ->
        it.split("").filter { it.isNotEmpty() }.toMutableList()
    }
    .toMutableList()


fun main() {
    solvePart2()
}

fun solvePart1() {
    var sum = 0;
    for (x in input.indices) {
        for (y in input[x].indices) {
            val atNeighbors = input.checkNeighbors(x, y).count { it == "@" }
            if (input[x][y] == "@" && atNeighbors < 4) {
                sum++
            }
        }
    }
    println(sum)
}

fun solvePart2() {
    println(clearPapers(input))
}

fun clearPapers(list: MutableList<MutableList<String>>, count: Int = 0): Int {
    var counter = count
    for (x in input.indices) {
        for (y in list[x].indices) {
            val atNeighbors = list.checkNeighbors(x, y).count { it == "@" }
            if (list[x][y] == "@" && atNeighbors < 4) {
                list[x][y] = "."
                counter++
            }
        }
    }
    if (counter != count) {
        return clearPapers(list, counter)
    }
    return counter
}


private val directions = listOf(
    0 to 1, //right
    0 to -1, //left
    1 to 0, //down
    1 to -1, //up
    1 to 1, //down right
    -1 to 0, //down left
    -1 to 1, //up right
    -1 to -1 // up left
)

private fun List<List<String>>.checkNeighbors(row: Int, col: Int): List<String> {
    val rowSize = this[row].size

    return directions.mapNotNull { (dr, dc) ->
        val directionRow = dr + row
        val directionColumn = dc + col
        if (directionRow in 0 until rowSize && directionColumn in 0 until this.size) {
            this[directionRow][directionColumn]
        } else {
            null
        }

    }
}
