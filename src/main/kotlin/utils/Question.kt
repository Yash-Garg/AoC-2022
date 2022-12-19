package utils

interface Question<T> {
    val inputFilePath: String

    fun part1(): T
    fun part2(): T
    fun getInput() = FileUtils.readFile(inputFilePath)
}
