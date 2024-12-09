import kotlin.math.abs

fun main() {

    val input = readInput("Day01")
    val part1 = mutableListOf<Int>()
    val part2 = mutableListOf<Int>()
    input.map { inputString ->
        inputString.split("   ").let {
            part1.add(it[0].toInt())
            part2.add(it[1].toInt())
        }
    }
    part1.sort()
    part2.sort()
    part1.mapIndexed { index, i -> abs( i - part2[index])}.sum().println()

}
