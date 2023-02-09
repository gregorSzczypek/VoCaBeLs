import java.io.File
//import com.google.gson.GSON

// saveReadIn gets a String with a input prompt and a list of Strings with valid input-options
fun saveReadIn(question: String, allowedWords: List<String>): String {
    while (true) {
        var input = ""
        println(yellow + question + reset)
        println(cyan + "Or type help to see available options or cancel to escape" + reset)
        input = readln().lowercase()
        if (allowedWords.contains(input)) {
            //println("Input accepted")
            println()
            return input
        } else if (input == "help") {
            println("Choose from:")
            if (allowedWords.size > 10){
                var iAfterFor = 0
                try {
                    for (i in 0 until allowedWords.size step (10)) {
                        print("${allowedWords[i]}, ")
                        iAfterFor += 1
                        print("${allowedWords[i + 1]}, ")
                        iAfterFor += 1
                        print("${allowedWords[i + 2]}, ")
                        iAfterFor += 1
                        print("${allowedWords[i + 3]}, ")
                        iAfterFor += 1
                        print("${allowedWords[i + 4]}, ")
                        iAfterFor += 1
                        print("${allowedWords[i + 5]}, ")
                        iAfterFor += 1
                        print("${allowedWords[i + 6]}, ")
                        iAfterFor += 1
                        print("${allowedWords[i + 7]}, ")
                        iAfterFor += 1
                        print("${allowedWords[i + 8]}, ")
                        iAfterFor += 1
                        print("${allowedWords[i + 9]}, ")
                        iAfterFor += 1
                        println()
                    }
                } catch (e: Exception) {
                    iAfterFor += 1
                    println("cancel")
                }
//                println((allowedWords.size))
//                println(iAfterFor)
                if ((allowedWords.size) == iAfterFor) {
                    println("cancel")
                }
            } else println(allowedWords + "cancel")
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

fun saveReadInWOHelpExit(question: String, notAllowedWords: List<String> = listOf("help", "cancel", "exit", "")): String {
        while (true) {
            var input = ""
            println(yellow + question + reset)
            println(cyan + "Or type cancel to escape" + reset)
            input = readln().lowercase()
            if (!notAllowedWords.contains(input)) {
                //println("Input accepted")
                println()
                return input
            } else if (input == "cancel") {
                println("Going back home...")
                Thread.sleep(1200)
                openMenu()
            } else {
                println(red + "Input cannot be empty, help or exit, try again..." + reset)
            }
        }
}
