import kotlin.system.exitProcess
import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import java.io.File


fun openMenu() {
    var choiceOfAction = ""

    while (true) {
        println("What would you like to do?")
        println(purple + "1 - training" + reset)
        println(purple + "2 - create new index box" + reset)
        println(purple + "3 - create new word" + reset)
        println(purple + "4 - delete word" + reset)
        println(purple + "5 - show saved wordboxes" + reset)
        println(purple + "6 - delete wordbox" + reset)
        println(red + "exit" + reset)
        println()
        choiceOfAction = saveReadIn("Please enter your choice:", listOf("1", "2", "3", "4", "5", "6", "exit"))

        when (choiceOfAction) {
            "1" -> {
                if (allIndexBoxes.isNotEmpty()) {
                    training()
                } else {
                    println(red + "No wordboxes saved." + reset)
                    println()
                }
            }

            "2" -> {
                createNewIndexBox() // Only function working right away to create a new wordbox and start the programm
            }

            "3" -> {
                if (allIndexBoxes.isNotEmpty()) {
                    createNewWord()
                } else {
                    println(red + "No wordboxes saved, please create wordbox." + reset)
                    println()
                }
            }

            "4" -> {
                if (allIndexBoxes.isNotEmpty()) {
                    deleteWord()
                } else {
                    println(red + "No wordboxes saved." + reset)
                    println()
                }
            }

            "5" -> {
                if (allIndexBoxes.isNotEmpty()) {
                    showAllWordboxes()
                } else {
                    println(red + "No wordboxes saved." + reset)
                    println()
                }
            }

            "6" -> {
                if (allIndexBoxes.isNotEmpty()) {
                    deleteIndexBox()
                } else {
                    println(red + "No wordboxes saved!" + reset)
                    println()
                }
            }

            "exit" -> {
                var exitConfirmation = saveReadIn("Do you really want to exit the programm?", listOf("yes", "no"))
                if (exitConfirmation == "yes") {
                    var serializedData = Json.encodeToString(allIndexBoxes)
                    println(serializedData)
                    saveFile.writeText(serializedData)
                    exitProcess(0)
                } else openMenu()
            }
        }
    }
}
