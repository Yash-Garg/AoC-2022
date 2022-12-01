package day1

import utils.Question

class Question1P1(override val inputFilePath: String) : Question<Int> {

    override fun solve(): Int {
        val inputList = getInput()

        var maxCalories = 0
        var elfCalories = 0

        inputList.forEach { value ->
            if (value.isNotEmpty()) {
                elfCalories += value.toInt()
            } else {
                if (elfCalories > maxCalories) {
                    maxCalories = elfCalories
                }
                elfCalories = 0
            }
        }

        return maxCalories
    }
}
