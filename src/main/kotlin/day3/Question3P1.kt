package day3

import utils.Question
import utils.emptyString

class Question3P1(override val inputFilePath: String) : Question<Int> {

    override fun solve(): Int {
        val inputList = getInput()

        var common = emptyString()
        var score = 0

        inputList.forEach { sack ->
            val items = sack.length
            val firstCompartment = sack.substring(0, items / 2)
            val secondCompartment = sack.substring(items / 2, items)
            var temp = emptyString()

            firstCompartment.forEach { ch ->
                if (ch in secondCompartment) {
                    temp += ch
                }
            }

            common += temp.toSet().joinToString(emptyString())
        }

        common.forEach {
            score += if (it.isLowerCase()) {
                it.code - 96
            } else it.code - 38
        }

        return score
    }
}
