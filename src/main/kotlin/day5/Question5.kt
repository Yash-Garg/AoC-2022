package day5

import utils.Question
import utils.SPACE_DELIM
import utils.emptyString

class Question5(override val day: String) : Question<String> {
    private val inputList = getInput()

    override fun part1() = performTask(true)

    override fun part2() = performTask(false)

    private fun performTask(reversed: Boolean): String {
        val stacks = parseStacks(inputList)
        val moves = parseMoves(inputList)

        moves.forEach { (move, from, to) ->
            val toMove = stacks[from].take(move)

            repeat(move) { stacks[from].removeFirst() }
            stacks[to].addAll(0, if (reversed) toMove.reversed() else toMove)
        }

        return stacks.map { it.first() }.joinToString("")
    }

    private fun parseStacks(input: List<String>): List<MutableList<Char>> {
        val rows = input.takeWhile { it.contains('[') }
        return (1..rows.last().length step 4).map { index ->
            rows
                .mapNotNull { it.getOrNull(index) }
                .filter { it.isUpperCase() }
                .toMutableList()
        }
    }

    private fun parseMoves(input: List<String>): List<Move> {
        return input.dropWhile { !it.startsWith("move") }.map { row ->
            row.split(SPACE_DELIM).let {
                Move(move = it[1].toInt(), from = it[3].toInt() - 1, to = it[5].toInt() - 1)
            }
        }
    }

    private data class Move(
        val move: Int,
        val from: Int,
        val to: Int
    )
}
