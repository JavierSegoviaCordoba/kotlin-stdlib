@file:Suppress("MagicNumber")

import com.javiersc.kotlin.stdlib.second
import kotlin.test.Test
import kotlin.test.assertTrue

class CollectionsTest {

    private val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    @Test
    fun collection_second() {
        assertTrue { numbers.second() == 2 }
    }
}
