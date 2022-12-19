import day1.Question1
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class Question1Test {
    lateinit var question: Question1

    @BeforeTest
    fun setUp() {
        question = Question1("day1")
    }

    @Test fun part1Test() = assertEquals(question.part1(), 66487)

    @Test fun part2Test() = assertEquals(question.part2(), 197301)
}
