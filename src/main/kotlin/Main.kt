import day1.Question1
import day2.Question2
import day3.Question3
import utils.Question

fun main() {
    val inputFile = "input.txt"
    val currentDir = "${System.getProperty("user.dir")}/src/main/kotlin/"

    val question1 = Question1("$currentDir/day1/$inputFile")
    val question2 = Question2("$currentDir/day2/$inputFile")
    val question3 = Question3("$currentDir/day3/$inputFile")

    listOf(question1, question2, question3).forEach(::log)
}

internal fun log(ques: Question<*>) {
    println("${ques.javaClass.canonicalName}\nPart 1 - ${ques.part1()}\nPart 2 - ${ques.part2()}\n")
}
