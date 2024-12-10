import kotlin.math.abs

fun main() {

    fun isSafe(levels: List<String>): Boolean {
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

    var safeCount = 0
    readInput("Day02").forEach { line ->
        val levels = line.split(" ")
        if (isSafe(levels)) {
            safeCount++
        }
    }

    safeCount.println()

}