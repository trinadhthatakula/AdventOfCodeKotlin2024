import kotlin.math.abs

fun main() {

    fun part1(list1:MutableList<Int>, list2:MutableList<Int>): Int{
        list1.sort()
        list2.sort()
        return list1.mapIndexed { index, i -> abs( i - list2[index])}.sum()
    }

    fun part2(list1:MutableList<Int>, list2:MutableList<Int>) =
        list1.sumOf { i -> i * list2.count { it == i } }

    val input = readInput("Day01")
    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()
    input.map { inputString ->
        inputString.split("   ").let {
            list1.add(it[0].toInt())
            list2.add(it[1].toInt())
        }
    }
    "part1 result is ${part1(list1, list2)}".println()
    "part2 result is ${part2(list1, list2)}".println()


}
