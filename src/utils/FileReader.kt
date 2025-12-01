package utils

import kotlin.io.path.Path
import kotlin.io.path.readText

fun readInput(name: String) = Path("src/text_files/$name.txt").readText().trim().lines()