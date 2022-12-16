package day2.models

import java.lang.IllegalArgumentException

enum class Strategy {
    Rock, Paper, Scissors;

    companion object {
        const val winningPoints = 6
        const val drawPoints = 3

        fun pointsFor(strategy: Strategy): Int {
            return when (strategy) {
                Rock -> 1
                Paper -> 2
                Scissors -> 3
            }
        }

        fun valueFor(strategy: String): Strategy {
            return when (strategy) {
                "A", "X" -> Rock
                "B", "Y" -> Paper
                "C", "Z" -> Scissors
                else -> throw IllegalArgumentException()
            }
        }
    }
}
