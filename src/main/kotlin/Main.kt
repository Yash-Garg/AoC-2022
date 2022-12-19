import day1.Question1
import day2.Question2
import day3.Question3
import day4.Question4
import day5.Question5
import utils.Question

fun main() {
    val question1 = Question1("day1")
    val question2 = Question2("day2")
    val question3 = Question3("day3")
    val question4 = Question4("day4")
    val question5 = Question5("day5")

    listOf(question1, question2, question3, question4, question5).forEach(::log)
}

internal fun log(ques: Question<*>) {
    println("${ques.javaClass.canonicalName}\nPart 1 - ${ques.part1()}\nPart 2 - ${ques.part2()}\n")
}
