package day1

import utils.Question

class Question1(override val inputFilePath: String) : Question<Int> {

    private val inputList = getInput()

    override fun part1(): Int {
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

    override fun part2(): Int {
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
