import kotlin.math.abs

fun main() {

    fun part1(levels: List<String>): Boolean {
        var isIncrement: Boolean? = null
        levels.windowed(2).map { levelPair ->
            val difference = (levelPair[0].toInt() - levelPair[1].toInt())
            when {
                difference == 0 -> return false
                abs(difference) > 3 -> return false
                difference > 0 -> {
                    if (isIncrement == null) {
                        isIncrement = false
                    } else if (isIncrement == true) return false
                }
                else -> {
                    if (isIncrement == null) {
                        isIncrement = true
                    }
                    else if (isIncrement == false) return false
                }
            }
        }
        return true
    }

    fun part2(levels:List<String>):Boolean{
        if(!part1(levels)){
            levels.forEachIndexed{ index, _ ->
                val tempList = levels.toMutableList()
                tempList.removeAt(index)
                if(part1(tempList))
                    return true
            }
            return false
        }
        return true
    }

    var part1Result = 0
    var part2Result = 0
    readInput("Day02").forEach { line ->
        val levels = line.split(" ")
        if (part1(levels)) {
            part1Result++
        }
        if(part2(levels)){
            part2Result++
        }
    }

    "part1 result is $part1Result".println()
    "part2 result is $part2Result".println()

}