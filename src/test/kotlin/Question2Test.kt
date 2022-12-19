import day2.Question2
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class Question2Test {
    lateinit var question: Question2

    @BeforeTest
    fun setUp() {
        question = Question2("day2")
    }

    @Test fun part1Test() = assertEquals(question.part1(), 13005)

    @Test fun part2Test() = assertEquals(question.part2(), 11373)
}
