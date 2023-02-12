import java.util.*

// List nullable 과 non-nullable 예시
fun main() {
    val a: List<Int> = emptyList()
    val b: List<Int> = listOf(1, 2, 3, 4)

    val c: List<Int?> = listOf(1, 2, null, 4)
    val d: List<Int?> = listOf(1, 2, 3, 4)

    val e: List<Int>? = null
    val f: List<Int>? = listOf(1, 2, 3, 4)

    val g: List<Int?>? = null
    val h: List<Int?>? = listOf(1, 2, 3, 4)
    val i: List<Int?>? = listOf(1, 2, null, 4)

//    val immutableList = a.add(5) // error
    val immutableList = a.plus(5) // create new list
}
