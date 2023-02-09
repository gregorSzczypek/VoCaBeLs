import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import java.io.File

var allIndexBoxes = mutableListOf<IndexBox>()
val red = "\u001b[31m"
val green = "\u001B[32m"
val purple = "\u001B[35m"
val yellowBG = "\u001B[43m"
val black = "\u001B[30m"
val reset = "\u001b[0m"
val filePath = "/Users/gregorszczypek/Desktop/Eigene Projekte/Vocabels_Gradle/vocabels_gradle/data.json"
val saveFile = File(filePath)
var jsonStringReadIn: String = ""

fun main () {

    jsonStringReadIn = saveFile.readText()
    allIndexBoxes = Json.decodeFromString(jsonStringReadIn)

    println(yellowBG + black + "Welcome to VoCaBeLs!".padEnd(57) + reset)
    println()
    Thread.sleep(1200)
    openMenu()

}


