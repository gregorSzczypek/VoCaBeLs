import java.io.File
//import com.google.gson.GSON

// saveReadIn gets a String with a input prompt and a list of Strings with valid input-options
fun saveReadIn(question: String, allowedWords: List<String>): String {
    while (true) {
        var input = ""
        println(question)
        println("Or type help to see available options or cancel to escape")
        input = readln()
        if (allowedWords.contains(input)) {
            //println("Input accepted")
            println()
            return input
        } else if (input == "help") {
            println("Choose from:")
            println(allowedWords + "cancel")
        } else if (input == "cancel") {
            println("Going back home...")
            Thread.sleep(1200)
            openMenu()
        } else {
            println(red + "Invalid input, try again..." + reset)
        }
    }
}

// readlnNotEmpty checks if the user input is not empty and returns the "not empty" user input
fun readlnNotEmpty(question: String, warning: String): String {
    var userInput = ""
    while (true) {
        println(question)
        userInput = readln()
        if (userInput == "") {
            println(warning)
            continue
        } else return userInput
    }
}

// Creates a list of Strings with the names of all wordboxes for further usage and defining indexes etc...
fun stringListOfAllBoxes(): List<String>{
    var listObjectToString: MutableList<String> = mutableListOf()

    for (i in allIndexBoxes){
        listObjectToString.add(i.indexBoxName)
    }
    return listObjectToString
}

fun saveData(filepath: String){
    val filepath = "Abschlussprojekt/Data.json"
    val DataFile = File(filepath)
    //DataFile.write
}
