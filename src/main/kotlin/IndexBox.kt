import kotlinx.serialization.*

@Serializable
data class IndexBox(
    val indexBoxName: String,
    val motherTongue: String,
    val learningLanguage: String,
    val adjectivesList: MutableList<Adjectives> = mutableListOf<Adjectives>(),
    val verbsList: MutableList<Verbs> = mutableListOf<Verbs>(),
    val nounsList: MutableList<Nouns> = mutableListOf<Nouns>(),
    var confidence: Int = 0

) {

    fun createNewWord() {
        var wordType = ""
        var motherTongueWord = ""
        var learningLanguageWord = ""
        var anotherWordChoice = ""

        wordType = saveReadIn("Please type in a valid wordtype", listOf("adjective", "verb", "noun")
        )

        when (wordType) {

            "adjective" -> {
                while (true) {
                    println("Type in the word in ${this.motherTongue}:")
                    motherTongueWord = readln().lowercase()
                    println("Type in the word in ${this.learningLanguage}:")
                     learningLanguageWord = readln().lowercase()

                    var CheckExistence = false
                    for (i in adjectivesList){
                        if (i.mothertongueTranslation == motherTongueWord || i.learningLanguageTranslation == learningLanguageWord){
                            CheckExistence = true
                            break
                        } else CheckExistence = false
                    }

                    if (CheckExistence){
                        println(red + "Word already created, try a different one..." + reset)
                        createNewWord()
                    }else {
                        adjectivesList.add(Adjectives(motherTongueWord, learningLanguageWord))
                        println("Word saved successfully!")
                        println()
                    }
                    anotherWordChoice = saveReadIn("Do you want to add another word?", listOf("yes", "no"))
                    if (anotherWordChoice == "yes") {
                        continue
                    } else openMenu()
                }
                println(adjectivesList)
            }

            "verb" -> {
                while (true) {
                    println("Type in the word in ${this.motherTongue}:")
                    motherTongueWord = readln().lowercase()
                    println("Type in the word in ${this.learningLanguage}:")
                    learningLanguageWord = readln().lowercase()

                    var CheckExistence = false
                    for (i in verbsList){
                        if (i.mothertongueTranslation == motherTongueWord || i.learningLanguageTranslation == learningLanguageWord){
                            CheckExistence = true
                            break
                        } else CheckExistence = false
                    }

                    if (CheckExistence){
                        println(red + "Word already created, try a different one..." + reset)
                        createNewWord() // TODO not sure if bug or feature...
                    }else {
                        verbsList.add(Verbs(motherTongueWord, learningLanguageWord))
                        println("Word saved successfully!")
                        println()
                    }
                    anotherWordChoice = saveReadIn("Do you want to add another word?", listOf("yes", "no"))
                    if (anotherWordChoice == "yes") {
                        continue
                    } else openMenu()
                }
                println(verbsList)
            }

            "noun" -> {
                while (true) {
                    println("Type in the word in ${this.motherTongue}:")
                    motherTongueWord = readln().lowercase()
                    println("Type in the word in ${this.learningLanguage}:")
                    learningLanguageWord = readln().lowercase()

                    var CheckExistence = false
                    for (i in nounsList){
                        if (i.mothertongueTranslation == motherTongueWord || i.learningLanguageTranslation == learningLanguageWord){
                            CheckExistence = true
                            break
                        } else CheckExistence = false
                    }

                    if (CheckExistence){
                        println(red + "Word already created, try a different one..." + reset)
                        createNewWord()
                    }else {
                        nounsList.add(Nouns(motherTongueWord, learningLanguageWord))
                        println("Word saved successfully!")
                        println()
                    }
                    anotherWordChoice = saveReadIn("Do you want to add another word?", listOf("yes", "no"))
                    if (anotherWordChoice == "yes") {
                        continue
                    } else openMenu()
                }
            }
        }
    }


    fun deleteWord() {
        var allWordsMotherTongueString = mutableListOf<String>()
        for (i in this.adjectivesList){
            allWordsMotherTongueString.add(i.mothertongueTranslation)
        }
        for (i in this.verbsList){
            allWordsMotherTongueString.add(i.mothertongueTranslation)
        }
        for (i in this.nounsList){
            allWordsMotherTongueString.add(i.mothertongueTranslation)
        }

        var wordToDelete = saveReadIn("Which word do you want to delete?", allWordsMotherTongueString)
        for (i in this.adjectivesList){
            if (i.mothertongueTranslation == wordToDelete){
                println(red + "Word: ${i.mothertongueTranslation} successfully deleted!" + reset)
                println()
                this.adjectivesList.remove(i)
                break
            }
        }
        for (i in this.verbsList){
            if (i.mothertongueTranslation == wordToDelete){
                println(red + "Word: ${i.mothertongueTranslation} successfully deleted!" + reset)
                println()
                this.verbsList.remove(i)
                break
            }
        }
        for (i in this.nounsList){
            if (i.mothertongueTranslation == wordToDelete){
                println(red + "Word: ${i.mothertongueTranslation} successfully deleted!" + reset)
                println()
                this.nounsList.remove(i)
                break
            }
        }
    }

    fun refreshConfidenceOfIndexBox() { // refresh confidence of whole wordbox
        var sumOfConfidences = 0
        var confIndexBox: Double = 0.0

        for (i in this.adjectivesList){
            sumOfConfidences = sumOfConfidences + i.confidence
        }
        for (i in this.verbsList){
            sumOfConfidences = sumOfConfidences + i.confidence
        }
        for (i in this.nounsList){
            sumOfConfidences = sumOfConfidences + i.confidence
        }
        //println("Sum of confidences: $sumOfConfidences%")
        confIndexBox = sumOfConfidences / (this.adjectivesList.size + this.verbsList.size + this.nounsList.size).toDouble()

        this.confidence = confIndexBox.toInt()
    }

    override fun toString(): String {
        return this.indexBoxName
    }
}
