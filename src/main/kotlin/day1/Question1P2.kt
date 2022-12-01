package day1

import utils.Question

class Question1P2(override val inputFilePath: String) : Question<Int> {

    override fun solve(): Int {
        val inputList = getInput()

        var calories = 0
        val totalCaloriesList = mutableListOf<Int>()

        inputList.forEach { value ->
            if (value.isNotEmpty()) {
                calories += value.toInt()
            } else {
                totalCaloriesList.add(calories)
                calories = 0
            }
        }

        totalCaloriesList.sortDescending()
        return totalCaloriesList[0] + totalCaloriesList[1] + totalCaloriesList[2]
    }
}
