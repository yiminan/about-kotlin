package kotest

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize

class ListTest : FunSpec({
    test("emptyList의 size는 0이다.") {
        val emptyList: List<Int> = emptyList()
        emptyList shouldHaveSize 0
    }
})
