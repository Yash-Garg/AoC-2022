package day2

import utils.Question

class Question2P1(override val inputFilePath: String) : Question<Int> {

    override fun solve(): Int {
        val inputList = getInput()
        var score = 0

        inputList.forEach { value ->
            lateinit var oppOption: Strategy
            lateinit var myOption: Strategy

            value.split(" ").apply {
                oppOption = Strategy.valueFor(first())
                myOption = Strategy.valueFor(last())
            }

            if (oppOption != myOption) {
                score += when (oppOption) {
                    Strategy.Rock -> if (myOption == Strategy.Paper) {
                        Strategy.winningPoints
                    } else 0

                    Strategy.Paper -> if (myOption == Strategy.Scissors) {
                        Strategy.winningPoints
                    } else 0

                    Strategy.Scissors -> if (myOption == Strategy.Rock) {
                        Strategy.winningPoints
                    } else 0
                } + Strategy.pointsFor(myOption)
            } else {
                score += Strategy.pointsFor(myOption) + Strategy.drawPoints
            }
        }

        return score
    }
}
