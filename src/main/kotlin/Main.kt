import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import java.io.File

var allIndexBoxes = mutableListOf<IndexBox>() // All saved data is in allIndexBoxes
// FontColors and BGColors for println
val red = "\u001b[31m"
val green = "\u001B[32m"
val greenBG = "\u001B[42m"
val purple = "\u001B[35m"
val purpleBG = "\u001B[45m"
val yellowBG = "\u001B[43m"
val yellow = "\u001B[33m"
val black = "\u001B[30m"
val blackBG = "\u001B[40m"
val cyan = "\u001B[36m"
val cyanBG = "\u001B[46m"

val reset = "\u001b[0m"
val filePath = "/Users/gregorszczypek/Desktop/Eigene Projekte/Vocabels_Gradle/vocabels_gradle/data.json" // json path
val saveFile = File(filePath)
var jsonStringReadIn: String = ""

fun main () {

    jsonStringReadIn = saveFile.readText() // read from json file
    allIndexBoxes = Json.decodeFromString(jsonStringReadIn) // Decoding of json file string, creating object allIndexBoxes

    println(yellowBG + black + "Welcome to VoCaBeLs!".padEnd(50) + reset)
    println()
    Thread.sleep(1200)
    openMenu() // Open program menu

}