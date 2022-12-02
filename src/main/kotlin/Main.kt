import day1.Question1P1
import day1.Question1P2
import day2.Question2P1

fun main() {
    val currentDir = System.getProperty("user.dir")

    val question1p1 = Question1P1("$currentDir/src/main/kotlin/day1/input.txt")
    val question1p2 = Question1P2("$currentDir/src/main/kotlin/day1/input.txt")
    val question2p1 = Question2P1("$currentDir/src/main/kotlin/day2/input.txt")

    println("${question1p1.javaClass.simpleName}: ${question1p1.solve()}")
    println("${question1p2.javaClass.simpleName}: ${question1p2.solve()}")
    println("${question2p1.javaClass.simpleName}: ${question2p1.solve()}")
}
