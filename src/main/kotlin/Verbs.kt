//import kotlinx.serialization.*
//
//@Serializable
//
//class Verbs(
//    val mothertongueTranslation: String, // save the word in mothertongue
//    val learningLanguageTranslation: String, //saves the word in learning language
//    val wordType: String = "Verb",
//    timesCalled: Int = 0, // Count of how many times the word was called during training sessions
//    timesRight: Int = 0, // Count of how many times th word was translated right
//    slidingWindowList: MutableList<Int> = mutableListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//    confidence: Int = 0 // Confidence, tells how confident the user already is  with the word
//): Word(timesCalled, timesRight, slidingWindowList, confidence) {
//
//    override fun toString(): String {
//        return this.mothertongueTranslation
//    }
//}

import kotlinx.serialization.*

@Serializable

class Verbs: Word {
    var mothertongueTranslation: String
    var learningLanguageTranslation: String
    var wordType: String
//    var timesCalled: Int
//    var timesRight: Int
//    var slidingWindowList: MutableList<Int>
//    var confidence: Int

    constructor(mothertongueTranslation: String,
                learningLanguageTranslation: String,
                wordType: String = "Verb",
                timesCalled: Int = 0,
                timesRight: Int = 0,
                slidingWindowList: MutableList<Int> = mutableListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                confidence: Int = 0
    ): super(timesCalled, timesRight, slidingWindowList, confidence){
        this.mothertongueTranslation = mothertongueTranslation
        this.learningLanguageTranslation = learningLanguageTranslation
        this. wordType = "Verb"
        this.timesCalled = timesCalled
        this.timesRight = timesRight
        this.slidingWindowList = slidingWindowList
        this.confidence = confidence
    }

    override fun toString(): String {
        return this.mothertongueTranslation
    }
}