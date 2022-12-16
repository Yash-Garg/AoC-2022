package day2.models

import java.lang.IllegalArgumentException

enum class Action {
    WIN,
    LOSE,
    DRAW;

    companion object {
        fun valueFor(action: String): Action {
            return when (action) {
                "X" -> LOSE
                "Y" -> DRAW
                "Z" -> WIN
                else -> throw IllegalArgumentException()
            }
        }
    }
}
