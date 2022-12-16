package day2

import day2.models.Action
import day2.models.Strategy
import utils.Question

class Question2P2(override val inputFilePath: String) : Question<Int> {

    override fun solve(): Int {
        val inputList = getInput()
        var score = 0

        inputList.forEach { value ->
            lateinit var oppOption: Strategy
            lateinit var action: Action

            value.split(" ").apply {
                oppOption = Strategy.valueFor(first())
                action = Action.valueFor(last())
            }

            with(Strategy) {
                score += when (action) {
                    Action.WIN -> when (oppOption) {
                        Strategy.Rock -> pointsFor(Strategy.Paper)
                        Strategy.Paper -> pointsFor(Strategy.Scissors)
                        Strategy.Scissors -> pointsFor(Strategy.Rock)
                    } + winningPoints

                    Action.LOSE -> when (oppOption) {
                        Strategy.Rock -> pointsFor(Strategy.Scissors)
                        Strategy.Paper -> pointsFor(Strategy.Rock)
                        Strategy.Scissors -> pointsFor(Strategy.Paper)
                    }

                    Action.DRAW -> pointsFor(oppOption) + drawPoints
                }
            }
        }

        return score
    }
}
