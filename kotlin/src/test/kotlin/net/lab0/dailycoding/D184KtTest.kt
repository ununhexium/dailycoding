package net.lab0.dailycoding

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class D184KtTest {
    @Test
    fun test_a() {
        assertThat(
            greatestCommonDenominator(listOf(42, 56, 14))
        ).isEqualTo(
            14
        )
    }

    @Test
    fun test_b() {
        assertThat(
            greatestCommonDenominator(listOf(7,11))
        ).isEqualTo(
            1
        )
    }

    @Test
    fun test_c() {
        assertThat(
            greatestCommonDenominator(listOf(400, 360, 1440))
        ).isEqualTo(
            40
        )
    }

    @Test
    fun test_z0() {
        val thrown = assertThrows<IllegalArgumentException> {
            greatestCommonDenominator(listOf())
        }
        assertThat(
            thrown.message
        ).isEqualTo(
            "The vector can't be empty"
        )
    }


    @Test
    fun test_extract_factors_of_2() {
        assertThat(
            extractFactors(2)
        ).isEqualTo(
            listOf(2L)
        )
    }

    @Test
    fun test_extract_factors_of_10() {
        assertThat(
            extractFactors(10)
        ).isEqualTo(
            listOf(2L,5L)
        )
    }

    @Test
    fun test_extract_factors_of_81() {
        assertThat(
            extractFactors(81)
        ).isEqualTo(
            listOf(3L,3L,3L,3L)
        )
    }

    @Test
    fun test_extract_factors_of_360() {
        assertThat(
            extractFactors(360)
        ).isEqualTo(
            listOf(2L,2L,2L,3L,3L,5L)
        )
    }

    @Test
    fun test_extract_factors_of_0() {
        val thrown = assertThrows<IllegalArgumentException> {
            extractFactors(0)
        }
        assertThat(
            thrown.message
        ).isEqualTo(
            "Can't extract the factors of 0"
        )
    }

}
