package utils

interface Question<T> {
    val inputFilePath: String

    fun solve(): T
    fun getInput() = FileUtils.readFile(inputFilePath)
}
