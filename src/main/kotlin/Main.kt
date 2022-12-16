import day1.Question1P1
import day1.Question1P2
import day2.Question2P1
import day2.Question2P2
import day3.Question3P1
import utils.Question

fun main() {
    val inputFile = "input.txt"
    val currentDir = "${System.getProperty("user.dir")}/src/main/kotlin/"

    val question1p1 = Question1P1("$currentDir/day1/$inputFile")
    val question1p2 = Question1P2("$currentDir/day1/$inputFile")
    val question2p1 = Question2P1("$currentDir/day2/$inputFile")
    val question2p2 = Question2P2("$currentDir/day2/$inputFile")
    val question3p1 = Question3P1("$currentDir/day3/$inputFile")

    listOf(
        question1p1,
        question1p2,
        question2p1,
        question2p2,
        question3p1
    ).forEach(::log)
}

internal fun log(ques: Question<*>) {
    println("${ques.javaClass.simpleName}: ${ques.solve()}")
}
