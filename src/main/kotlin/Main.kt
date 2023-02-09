import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import java.io.File

var allIndexBoxes = mutableListOf<IndexBox>() // All saved data is in allIndexBoxes
// FontColors and BGColors for println
val red = "\u001b[31m"
val green = "\u001B[32m"
val purple = "\u001B[35m"
val yellowBG = "\u001B[43m"
val yellow = "\u001B[33m"
val black = "\u001B[30m"
val cyan = "\u001B[36m"
val reset = "\u001b[0m"
val filePath = "/Users/gregorszczypek/Desktop/Eigene Projekte/Vocabels_Gradle/vocabels_gradle/data.json" // json path
val saveFile = File(filePath)
var jsonStringReadIn: String = ""

fun main () {

    jsonStringReadIn = saveFile.readText() // read from json file
    allIndexBoxes = Json.decodeFromString(jsonStringReadIn) // Decoding of json file string, creating object allIndexBoxes

    println(yellowBG + black + "Welcome to VoCaBeLs!".padEnd(57) + reset)
    println()
    Thread.sleep(1200)
    openMenu() // Open program menu

}