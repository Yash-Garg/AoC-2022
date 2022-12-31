package day2

import day2.models.Action
import day2.models.Strategy
import utils.Question
import utils.SPACE_DELIM

class Question2(override val day: String) : Question<Int> {

    private val inputList = getInput()

    override fun part1(): Int {
        var score = 0

        inputList.forEach { value ->
            lateinit var oppOption: Strategy
            lateinit var myOption: Strategy

            value.split(" ").apply {
                oppOption = Strategy.valueFor(first())
                myOption = Strategy.valueFor(last())
            }

            if (oppOption != myOption) {
                score +=
                    when (oppOption) {
                        Strategy.Rock ->
                            if (myOption == Strategy.Paper) {
                                Strategy.winningPoints
                            } else 0
                        Strategy.Paper ->
                            if (myOption == Strategy.Scissors) {
                                Strategy.winningPoints
                            } else 0
                        Strategy.Scissors ->
                            if (myOption == Strategy.Rock) {
                                Strategy.winningPoints
                            } else 0
                    } + Strategy.pointsFor(myOption)
            } else {
                score += Strategy.pointsFor(myOption) + Strategy.drawPoints
            }
        }

        return score
    }

    override fun part2(): Int {
        var score = 0

        inputList.forEach { value ->
            lateinit var oppOption: Strategy
            lateinit var action: Action

            value.split(SPACE_DELIM).apply {
                oppOption = Strategy.valueFor(first())
                action = Action.valueFor(last())
            }

            with(Strategy) {
                score +=
                    when (action) {
                        Action.WIN ->
                            when (oppOption) {
                                Strategy.Rock -> pointsFor(Strategy.Paper)
                                Strategy.Paper -> pointsFor(Strategy.Scissors)
                                Strategy.Scissors -> pointsFor(Strategy.Rock)
                            } + winningPoints
                        Action.LOSE ->
                            when (oppOption) {
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
