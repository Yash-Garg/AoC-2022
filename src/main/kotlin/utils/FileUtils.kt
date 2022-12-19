package utils

import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader

object FileUtils {
    fun readFile(filePath: String): List<String> {
        val file = File(filePath)
        if (!file.exists()) throw FileNotFoundException("Input file ($filePath) does not exist")

        val fileReader = FileReader(file)
        return fileReader.readLines()
    }
}

fun emptyString() = ""