package utils

interface Question<T> {
    val day: String

    private fun getFilePath(): String {
        val currentDir = "${System.getProperty("user.dir")}/src/main/kotlin/"

        return "$currentDir/$day/input.txt"
    }

    fun part1(): T
    fun part2(): T
    fun getInput() = FileUtils.readFile(getFilePath())
}
