import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Long {
        val (left, right) = input.map {line ->
            line.split(Regex("\\s+")).let {
                require(it.size == 2)
                it[0].toLong() to it[1].toLong()
            }
        }.unzip()
        return left.sorted().zip(right.sorted()).sumOf { (first, second) ->
            abs(first - second)
        }
    }

    fun part2(input: List<String>): Long {
        val (left, right) = input.map {line ->
            line.split(Regex("\\s+")).let {
                require(it.size == 2)
                it[0].toLong() to it[1].toLong()
            }
        }.unzip()
        val freq = right.groupingBy { it }.eachCount()
        return left.fold(0L) { acc, num ->
            acc + num * freq.getOrDefault(num, 0)
        }
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11L)
    check(part2(testInput) == 31L)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
