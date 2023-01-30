fun main() {
    val a: List<Int?> = listOf(1, 2, null, 4)
    val b: List<Int?> = listOf(1, 2, 3, 4)

    val c: List<Int>? = null
    val d: List<Int>? = listOf(1, 2, 3, 4)

    val e: List<Int?>? = null
    val f: List<Int?>? = listOf(1, 2, 3, 4)
    val g: List<Int?>? = listOf(1, 2, null, 4)
}
