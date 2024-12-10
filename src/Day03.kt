fun main() {

    fun part1(line: String): Int {
        return "mul\\(\\d+,\\d+\\)".toRegex().findAll(line).toList().sumOf {
            "\\d+".toRegex().findAll(it.value).toList().let { values ->
                values[0].value.toInt() * values[1].value.toInt()
            }
        }
    }

    fun part2(line: String): Int {
        var doIt = true
        var startIndex = 0
        var result = 0
        do {
            val nextIndex = if (doIt) line.indexOf("don't()", startIndex) else line.indexOf("do()", startIndex)
            val subbedString = if (nextIndex != -1)
                line.substring(startIndex, nextIndex)
            else
                line.substring(startIndex)
            if (doIt) result += part1(subbedString)
            startIndex = nextIndex + if (doIt) "don't()".length else "do()".length
            doIt = !doIt
        } while (nextIndex != -1)
        return result
    }

    var part1Result = 0
    var part2Result = 0
    readInput("Day03").joinToString().let { line ->
        part1Result += part1(line)
        part2Result += part2(line)
    }
    "part1 result is $part1Result".println()
    "part2 result is $part2Result".println()

}