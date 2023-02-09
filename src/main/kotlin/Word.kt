import kotlinx.serialization.*

@Serializable

open class Word(
    var timesCalled: Int = 0,
    var timesRight: Int = 0,
    var slidingWindowList: MutableList<Int> = mutableListOf<Int>(
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    ),
    var confidence: Int = 0
) {

    fun refreshConfidence() { // sliding window calculation
        this.confidence = (this.slidingWindowList.sum() * 5)
        if (this.confidence < 0){
            this.confidence = 0
        }
    }
}