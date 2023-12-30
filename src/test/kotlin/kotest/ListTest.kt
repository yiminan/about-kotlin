package kotest

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class ListTest : FunSpec({
    test("emptyList의 size는 0이다.") {
        val emptyList: List<Int> = emptyList()

        emptyList shouldHaveSize 0
    }

    test("listOf(1, 2, 3, 4)의 size는 4이다.") {
        val list: List<Int> = listOf(1, 2, 3, 4)

        list shouldHaveSize 4
    }

    test("element로 null이 들어가는 list의 size는 4이다.") {
        val list: List<Int?> = listOf(1, 2, null, 4)

        list shouldContain null
        list shouldHaveSize 4
    }

    test("List가 null이 할당되면 null이다.") {
        val list: List<Int>? = null

        list shouldBe null
    }

    test("List가 할당되면 null이 아니다.") {
        val f: List<Int> = listOf(1, 2, 3, 4)

        f shouldNotBe null
        f shouldHaveSize 4
    }
})
