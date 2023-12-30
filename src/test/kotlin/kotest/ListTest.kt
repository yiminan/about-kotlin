package kotest

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldHaveSize

class ListTest : FunSpec({
    test("emptyList의 size는 0이다.") {
        val emptyList: List<Int> = emptyList()

        emptyList shouldHaveSize 0
    }

    test("listOf(1, 2, 3, 4)의 size는 4이다.") {
        val list: List<Int> = listOf(1, 2, 3, 4)

        list shouldHaveSize 4
    }
})
