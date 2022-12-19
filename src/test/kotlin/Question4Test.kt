import day4.Question4
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class Question4Test {
    lateinit var question: Question4

    @BeforeTest
    fun setUp() {
        question = Question4("day4")
    }

    @Test fun part1Test() = assertEquals(question.part1(), 605)

    @Test fun part2Test() = assertEquals(question.part2(), 914)
}
