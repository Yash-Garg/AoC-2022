package day3

import utils.Question
import utils.emptyString
import java.lang.IllegalArgumentException

class Question3(override val inputFilePath: String) : Question<Int> {

    private val inputList = getInput()

    private val String.chars: String
        get() = toSet().joinToString(emptyString())

    private val Char.priority: Int
        get() = when (this) {
            in 'a'..'z' -> this.code - 'a'.code + 1
            in 'A'..'Z' -> this.code - 'A'.code + 27
            else -> throw IllegalArgumentException()
        }

    override fun part1(): Int {
        var common = emptyString()
        var prioritySum = 0

        inputList.forEach { sack ->
            val items = sack.length
            val firstCompartment = sack.substring(0, items / 2).chars
            val secondCompartment = sack.substring(items / 2, items).chars

            firstCompartment.forEach {
                if (it in secondCompartment) common += it
            }
        }

        common.forEach { prioritySum += it.priority }
        return prioritySum
    }

    override fun part2(): Int {
        val groups = inputList
            .map { it.toSet() }
            .windowed(3, step = 3)

        return groups.sumOf { (first, middle, last) -> (first intersect middle intersect last).single().priority }
    }
}
