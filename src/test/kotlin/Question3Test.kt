import day3.Question3
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class Question3Test {
    lateinit var question: Question3

    @BeforeTest
    fun setUp() {
        question = Question3("day3")
    }

    @Test fun part1Test() = assertEquals(question.part1(), 7990)

    @Test fun part2Test() = assertEquals(question.part2(), 2602)
}
