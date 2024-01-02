package kotest

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.maps.shouldContainExactly
import io.kotest.matchers.maps.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldNotBeSameInstanceAs

class CollectionTest : FunSpec({

    context("test: List") {
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

        test("MutableList는 변경이 가능하다.") {
            val mutableList = mutableListOf(1, 2, 3, 4)
            mutableList.add(5)

            mutableList shouldHaveSize 5
            mutableList shouldContainExactly listOf(1, 2, 3, 4, 5)
        }

        test("listOf로 생성된 List는 plus를 통해 element 추가가 가능하다.") {
            val list = listOf(1, 2, 3, 4)
            val immutableList = list.plus(5)

            immutableList shouldHaveSize 5
            immutableList shouldContainExactly listOf(1, 2, 3, 4, 5)
        }
    }

    context("test: Set") {
        test("emptySet의 size는 0이다.") {
            val emptySet: Set<Int> = emptySet()

            emptySet shouldHaveSize 0
        }

        test("setOf(1, 2, 3, 4)의 size는 4이다.") {
            val set: Set<Int> = setOf(1, 2, 3, 4)

            set shouldHaveSize 4
        }

        test("element로 null이 들어가는 set의 size는 4이다.") {
            val set: Set<Int?> = setOf(1, 2, null, 4)

            set shouldContain null
            set shouldHaveSize 4
        }

        test("Set가 null이 할당되면 null이다.") {
            val set: Set<Int>? = null

            set shouldBe null
        }

        test("Set가 할당되면 null이 아니다.") {
            val f: Set<Int> = setOf(1, 2, 3, 4)

            f shouldNotBe null
            f shouldHaveSize 4
        }

        test("MutableSet는 변경이 가능하다.") {
            val mutableSet = mutableSetOf(1, 2, 3, 4)
            val isAdded = mutableSet.add(5)

            isAdded shouldBe true
            mutableSet shouldHaveSize 5
            mutableSet shouldContainExactly setOf(1, 2, 3, 4, 5)
        }

        test("MutableList는 기존 MutableList의 plus를 통해 element 추가가 가능하다.") {
            val mutableSet = mutableSetOf(1, 2, 3)
            val mutableSet2 = mutableSet.plus(4)

            mutableSet shouldHaveSize 3
            mutableSet2 shouldHaveSize 4
            mutableSet shouldNotBeSameInstanceAs mutableSet2
        }

        test("setOf로 생성된 Set은 plus를 통해 element 추가가 가능하다.") {
            val set = setOf(1, 2, 3, 4)
            val set2 = set.plus(5)

            set shouldHaveSize 4
            set2 shouldHaveSize 5
            set2 shouldContainExactly setOf(1, 2, 3, 4, 5)
        }

        test("setOf로 생성된 Set은 plus를 통해 element 추가가 가능하다.") {
            val set = setOf(1, 2, 3)
            val set2 = set.plus(4)

            set shouldHaveSize 3
            set2 shouldHaveSize 4
            set shouldNotBeSameInstanceAs set2
        }

        test("setOf는 중복된 element를 허용하지 않는다.") {
            val set = setOf(1, 2, 3, 1, 1, 2, 3, 3)

            set shouldHaveSize 3
            set shouldContainExactly setOf(1, 2, 3)
        }
    }

    test("MutableMap은 기존 MutableMap의 put을 통해 element 추가가 가능하다.") {
        val mutableMap = mutableMapOf(1 to "1", 2 to "2", 3 to "3")
        mutableMap[4] = "4" // == mutableMap.put(4, "4")

        mutableMap shouldHaveSize 4
        mutableMap shouldContainExactly mapOf(1 to "1", 2 to "2", 3 to "3", 4 to "4")
    }

    test("MutableMap은 기존 MutableMap의 plus를 통해 element 추가가 가능하다.") {
        val mutableMap = mutableMapOf(1 to "1", 2 to "2", 3 to "3")
        val mutableMap2 = mutableMap.plus(4 to "4")

        mutableMap shouldHaveSize 3
        mutableMap2 shouldHaveSize 4
        mutableMap shouldNotBeSameInstanceAs mutableMap2
    }

    test("mapOf로 생성된 Map은 plus를 통해 element 추가가 가능하다.") {
        val map = mapOf(1 to "1", 2 to "2", 3 to "3")
        val map2 = map.plus(4 to "4")

        map shouldHaveSize 3
        map2 shouldHaveSize 4
        map shouldNotBeSameInstanceAs map2
    }
})
