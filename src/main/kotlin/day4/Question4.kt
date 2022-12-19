package day4

import utils.Question

class Question4(override val day: String) : Question<Int> {

    private val inputList = getInput()

    private val String.pair: Pair<Int, Int>
        get() {
            val groups = split("-")
            return Pair(groups.first().toInt(), groups.last().toInt())
        }

    private fun Pair<Int, Int>.containsFully(pair: Pair<Int, Int>): Boolean {
        return (pair.first in first..second) && (pair.second in first..second)
    }

    private fun Pair<Int, Int>.overlap(pair: Pair<Int, Int>): Boolean {
        return (pair.first in first..second) || (pair.second in first..second)
    }

    override fun part1(): Int {
        var numPairs = 0

        inputList.forEach {
            val pairs = it.split(",")

            val p1 = pairs.first().pair
            val p2 = pairs.last().pair

            if (p1.containsFully(p2) || p2.containsFully(p1)) numPairs++
        }

        return numPairs
    }

    override fun part2(): Int {
        var overlappingPairs = 0

        inputList.forEach {
            val pairs = it.split(",")

            val p1 = pairs.first().pair
            val p2 = pairs.last().pair

            if (p1.overlap(p2) || p2.overlap(p1)) overlappingPairs++
        }

        return overlappingPairs
    }
}
