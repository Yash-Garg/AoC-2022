package day3

import utils.Question
import utils.emptyString

class Question3P2(override val inputFilePath: String) : Question<Int> {

    override fun solve(): Int {
        val inputList = getInput()

        var score = 0
        var common = emptyString()

        for (index in 0..inputList.size step 3) {
            if (index >= inputList.size) break

            val group = mutableListOf<String>()
            group.addAll(inputList.subList(index, index + 3))

            val first = group.first()
            val middle = group.elementAt(1)
            val last = group.last()

            middle.forEach {
                if (it in first && it in last) common += it
            }
        }

        common.toSet().joinToString(emptyString()).forEach {
            score += if (it.isLowerCase()) {
                it.code - 96
            } else it.code - 38
        }

        return score
    }
}
