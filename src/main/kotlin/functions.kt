fun training() {

    println("Hello fellow human! It seems to be time for some good ol' training session.")
    var boxForTrainingSession = saveReadIn(
        "Choose which word box you want to train today",
        stringListOfAllBoxes()
    )
    println("Nice, lets train in word box: $boxForTrainingSession")
    var numberOfRounds = saveReadIn(
        "how many words would you like to train today?",
        listOf("10", "20", "30", "40", "50")
    )
    var numberOfRoundsInt = numberOfRounds.toInt()
    var choiceList = createChoiceOfWords(numberOfRoundsInt, boxForTrainingSession)
    var questionAdjective: Adjectives? = null
    var questionNoun: Nouns? = null
    var questionVerb: Verbs? = null
    var questionString: String = ""
    var answer: String

    for (i in 0 until numberOfRoundsInt) {
        var currentBox = allIndexBoxes[stringListOfAllBoxes().indexOf(boxForTrainingSession)]
        choiceList.shuffle()
        var questionWord = choiceList.random()
        choiceList.remove(questionWord)

        // Confidence calculation for adjectives
        if (currentBox.adjectivesList.contains(questionWord)) {
            questionAdjective = currentBox.adjectivesList[currentBox.adjectivesList.indexOf(questionWord)]
            questionString = questionAdjective.mothertongueTranslation
            println("Translate following word: $questionString")
            answer = readln().lowercase()
            questionAdjective.timesCalled += 1
            println("times called: ${questionAdjective.timesCalled}")

            if (answer == questionAdjective.learningLanguageTranslation) {
                println(green + "You are amazing, the answer is right!" + reset)
                questionAdjective.timesRight += 1
                questionAdjective.slidingWindowList.removeAt(0)
                questionAdjective.slidingWindowList.add(1)
                println("Sliding window: ${questionAdjective.slidingWindowList}")
                questionAdjective.refreshConfidence()
                println("The new conf for word $questionString is ${questionAdjective.confidence}")
                println()
            } else {
                println(red + "The answer was wrong :-(" + reset)
                questionAdjective.slidingWindowList.removeAt(0)
                questionAdjective.slidingWindowList.add(-1)
                println("Sliding window: ${questionAdjective.slidingWindowList}")
                questionAdjective.refreshConfidence()
                println("The new conf for word $questionString is ${questionAdjective.confidence}")
                println()
            }
        }
        // Confidence calculation for verbs
        if (currentBox.verbsList.contains(questionWord)) {
            questionVerb = currentBox.verbsList[currentBox.verbsList.indexOf(questionWord)]
            questionString = questionVerb.mothertongueTranslation
            println("Translate following word: $questionString")
            answer = readln().lowercase()
            questionVerb.timesCalled += 1
            println("times called: ${questionVerb.timesCalled}")

            if (answer == questionVerb.learningLanguageTranslation) {
                println(green + "You are amazing, the answer is right!" + reset)
                questionVerb.timesRight += 1
                questionVerb.slidingWindowList.removeAt(0)
                questionVerb.slidingWindowList.add(1)
                println("Sliding window: ${questionVerb.slidingWindowList}")
                questionVerb.refreshConfidence()
                println("The new conf for word $questionString is ${questionVerb.confidence}")
                println()
            } else {
                println(red + "The answer was wrong :-(" + reset)
                questionVerb.slidingWindowList.removeAt(0)
                questionVerb.slidingWindowList.add(-1)
                println("Sliding window: ${questionVerb.slidingWindowList}")
                questionVerb.refreshConfidence()
                println("The new conf for word $questionString is ${questionVerb.confidence}")
                println()
            }
        }
        // Confidence calculation for nouns
        if (currentBox.nounsList.contains(questionWord)) {
            questionNoun = currentBox.nounsList[currentBox.nounsList.indexOf(questionWord)]
            questionString = questionNoun.mothertongueTranslation
            println("Translate following word: $questionString")
            answer = readln().lowercase()
            questionNoun.timesCalled += 1
            println("times called: ${questionNoun.timesCalled}")

            if (answer == questionNoun.learningLanguageTranslation) {
                println(green + "You are amazing, the answer is right!" + reset)
                questionNoun.timesRight += 1
                questionNoun.slidingWindowList.removeAt(0)
                questionNoun.slidingWindowList.add(1)
                println("Sliding window: ${questionNoun.slidingWindowList}")
                questionNoun.refreshConfidence()
                println("The new conf for word $questionString is ${questionNoun.confidence}")
                println()
            } else {
                println(red + "The answer was wrong :-(" + reset)
                questionNoun.slidingWindowList.removeAt(0)
                questionNoun.slidingWindowList.add(-1)
                println("Sliding window: ${questionNoun.slidingWindowList}")
                questionNoun.refreshConfidence()
                println("The new conf for word $questionString is ${questionNoun.confidence}")
                println()
            }
        }
    }
}

fun createNewIndexBox() {
    var choice = ""
    var readInActive = true
    while (readInActive == true) {
        val motherTongueList = listOf<String>("german", "spanish", "english", "polish", "russian",
        "turkish", "estonian", "mandarin", "french", "swedish", "norwegian", "arabic", "italian", "dutch", "finish",
            "hungarian", "bulgarian", "slowenian", "klingonian", "sindarin", "esperanto")
        val learningLanguageList = mutableListOf<String>("german", "spanish", "english", "polish", "russian",
            "turkish", "estonian", "mandarin", "french", "swedish", "norwegian", "arabic", "italian", "dutch", "finish",
            "hungarian", "bulgarian", "slowenian", "klingonian", "sindarin", "esperanto")
        val boxName = readlnNotEmpty("Name your wordbox:", "Worbox name cannot be empty")
        var isDuplicate = false
        for (i in allIndexBoxes) {
            if (i.indexBoxName == boxName) {
                println(red + "Box already created, choose different name." + reset)
                isDuplicate = true
            }
        }
        if (isDuplicate == true) {
            continue // restart the while loop and ask for a name again
        }
        val motherTongue = saveReadIn("Which is the mothertongue?", motherTongueList)
        learningLanguageList.remove(motherTongue) // remove mothertongue from allowed learning languages
        val learningLanguage = saveReadIn("Which is the learning language?", learningLanguageList)
        allIndexBoxes.add(IndexBox(boxName, motherTongue, learningLanguage))
        println("Wordbox $boxName was successfully created!")
        choice = saveReadIn("Would you like to add another index box?", listOf("yes", "no"))
        if (choice == "yes") {
            continue // restart while loop and start creating another wordbox
        } else readInActive = false // exit while loop
    }
}

fun createNewWord() {

    var stringList = stringListOfAllBoxes()

    var indexBoxForNewWord = saveReadIn(
        "Where do you want to save a new word? Type in the name of the Wordbox.",
        stringListOfAllBoxes()
    ) // Check, if wordbox is already created, is done in openMenu function

    allIndexBoxes[stringListOfAllBoxes().indexOf(indexBoxForNewWord)].createNewWord()

}

fun deleteWord() {

    var listObjectToString: MutableList<String> = mutableListOf()

    for (i in allIndexBoxes) {
        listObjectToString.add(i.indexBoxName)
    }

    var indexBoxForNewWord = saveReadIn(
        "Where do you want to delete a word? Type in the name of the Wordbox.",
        listObjectToString
    ) // Check, if wordbox is already created, is done in openMenu function

    //println(allIndexBoxes[listObjectToString.indexOf(indexBoxForNewWord)])
    allIndexBoxes[listObjectToString.indexOf(indexBoxForNewWord)].deleteWord()

}

fun deleteIndexBox() {
    println("Which wordbox would you like to delete?")
    val nameToDelete = readln()
    var existence = false
    var j = 0
    for (i in allIndexBoxes) {
        if (i.indexBoxName == nameToDelete) {
            existence = true
            break
        }
        j += 1
    }
    if (existence) {
        val confirmation = saveReadIn(red + "Do you really want to remove wordbox $nameToDelete?" + reset, listOf("yes", "no"))
        if (confirmation == "yes") {
            allIndexBoxes.removeAt(j)
            println(green + "Wordbox $nameToDelete was removed successfully" + reset)
        } else openMenu()
    } else {
        println(red + "Invalid name" + reset)
        deleteIndexBox()
    }
}

fun showAllWordboxes() { // TODO format statistics output


    for (i in allIndexBoxes){
        i.refreshConfidenceOfIndexBox()
        println(yellowBG + black + "${i.indexBoxName.uppercase()} - ${i.confidence}%".padEnd(57) + reset)
        println(purple + "ADJECTIVES" + reset)
        for (j in i.adjectivesList){
            println("${j.mothertongueTranslation} - ${j.confidence}%")
        }
        println(purple + "VERBS" + reset)
        for (k in i.verbsList){
            println("${k.mothertongueTranslation} - ${k.confidence}%")
        }
        println(purple + "NOUNS" + reset)
        for (l in i.nounsList){
            println("${l.mothertongueTranslation} - ${l.confidence}%")
        }
    }
    println()
}

fun createChoiceOfWords(numberOfRounds: Int, boxForTrainingSession: String): MutableList<Word> {
    var choiceList = mutableListOf<Word>() // Final list for training session
    var allWordsListLvl1 = mutableListOf<Word>() // All Words with: 0 < confidence <= 25
    var allWordsListLvl2 = mutableListOf<Word>() // All Words with 25 < confidence <= 50
    var allWordsListLvl3 = mutableListOf<Word>() // ALl Words with 50 < confidence <= 75
    var allWordsListLvl4 = mutableListOf<Word>() // All words with 75 < confidence <= 100
    var amountLvl1 = (numberOfRounds * 0.4).toInt()
    var amountLvl2 = (numberOfRounds * 0.3).toInt()
    var amountLvl3 = (numberOfRounds * 0.2).toInt()
    var amountLvl4 = (numberOfRounds * 0.1).toInt()
    var indexOfBox = stringListOfAllBoxes().indexOf(boxForTrainingSession)
    var currentBox = allIndexBoxes[indexOfBox]

    println(amountLvl1)
    println(amountLvl2)
    println(amountLvl3)
    println(amountLvl4)

    var adjectivesSaved = true
    var verbsSaved = true
    var nounsSaved = true

    try {
        for (i in currentBox.adjectivesList) {
            if (i.confidence >= 0 && i.confidence <= 25) {
                allWordsListLvl1.add(i)
            } else if (i.confidence > 25 && i.confidence <= 50) {
                allWordsListLvl2.add(i)
            } else if (i.confidence > 50 && i.confidence <= 75) {
                allWordsListLvl3.add(i)
            } else if (i.confidence > 75 && i.confidence <= 100) {
                allWordsListLvl4.add(i)
            }
        }
    } catch (e: Exception) {
        println("No Adjectives saved")
        adjectivesSaved = false
    }

    try {
        for (i in currentBox.nounsList) {

            if (i.confidence >= 0 && i.confidence <= 25) {
                allWordsListLvl1.add(i)
            } else if (i.confidence > 25 && i.confidence <= 50) {
                allWordsListLvl2.add(i)
            } else if (i.confidence > 50 && i.confidence <= 75) {
                allWordsListLvl3.add(i)
            } else if (i.confidence > 75 && i.confidence <= 100) {
                allWordsListLvl4.add(i)
            }
        }
    }catch (e: Exception) {
        println("No nouns saved")
        nounsSaved = false
    }

    try {
        for (i in currentBox.verbsList) {

            if (i.confidence >= 0 && i.confidence <= 25) {
                allWordsListLvl1.add(i)
            } else if (i.confidence > 25 && i.confidence <= 50) {
                allWordsListLvl3.add(i)
            } else if (i.confidence > 50 && i.confidence <= 75) {
                allWordsListLvl3.add(i)
            } else if (i.confidence > 75 && i.confidence <= 100) {
                allWordsListLvl4.add(i)
            }
        }
    } catch (e: Exception) {
        println("No verbs saved")
        verbsSaved = false
    }

    if (nounsSaved == false && verbsSaved == false && adjectivesSaved == false){
        println("Wordbox empty, create words...")
        createNewWord()
    }

    var allLvlWordList = mutableListOf<Word>()
    allLvlWordList.addAll(allWordsListLvl1)
    allLvlWordList.addAll(allWordsListLvl2)
    allLvlWordList.addAll(allWordsListLvl3)
    allLvlWordList.addAll(allWordsListLvl4)

    println(allWordsListLvl1)
    println(allWordsListLvl2)
    println(allWordsListLvl3)
    println(allWordsListLvl4)

    if (numberOfRounds > allWordsListLvl1.size)
        amountLvl1 = allWordsListLvl1.size
    if (numberOfRounds > allWordsListLvl2.size)
        amountLvl2 = allWordsListLvl2.size
    if (numberOfRounds > allWordsListLvl3.size)
        amountLvl3 = allWordsListLvl3.size
    if (numberOfRounds > allWordsListLvl4.size)
        amountLvl4 = allWordsListLvl4.size

    for (i in 0 until amountLvl1) {
        try {
            allWordsListLvl1.random()
        } catch (e: Exception) {
            break
        }
        var currentChoice = allWordsListLvl1.random()
        choiceList.add(currentChoice)
        allWordsListLvl1.remove(currentChoice)
    }

    for (i in 0 until amountLvl2) {
        try {
            allWordsListLvl2.random()
        } catch (e: Exception) {
            break
        }
        var currentChoice = allWordsListLvl2.random()
        choiceList.add(currentChoice)
        allWordsListLvl2.remove(currentChoice)
    }

    for (i in 0 until amountLvl3) {
        try {
            allWordsListLvl3.random()
        } catch (e: Exception) {
            break
        }
        var currentChoice = allWordsListLvl3.random()
        choiceList.add(currentChoice)
        allWordsListLvl3.remove(currentChoice)
    }

    for (i in 0 until amountLvl4) {
        try {
            allWordsListLvl4.random()
        } catch (e: Exception) {
            break
        }
        var currentChoice = allWordsListLvl4.random()
        choiceList.add(currentChoice)
        allWordsListLvl4.remove(currentChoice)
    }

    var restOfWordsList = mutableListOf<Word>()
    restOfWordsList.addAll(allWordsListLvl1)
    restOfWordsList.addAll(allWordsListLvl2)
    restOfWordsList.addAll(allWordsListLvl3)
    restOfWordsList.addAll(allWordsListLvl4)

    while (choiceList.size < numberOfRounds) {
        try {
            var addWord = restOfWordsList.random()
            choiceList.add(addWord)
            restOfWordsList.remove(addWord)
        } catch (e: Exception) {
            println("Not enough words left, creating list anyway :-)")
            break
        }
    }
    while (choiceList.size < numberOfRounds) {
        try {
            choiceList.add(allLvlWordList.random())
        } catch (e: Exception) {
            println("No words in chosen Wordbox")
            createNewWord()
        }
    }
    println("ChoiceList:" + choiceList)
    return choiceList
}