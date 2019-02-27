package net.lab0.dailycoding

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class D184Test {
  @Test
  fun test_a() {
    assertThat(
        D184.greatestCommonDenominator(listOf(42, 56, 14))
    ).isEqualTo(
        14
    )
  }

  @Test
  fun test_b() {
    assertThat(
        D184.greatestCommonDenominator(listOf(7, 11))
    ).isEqualTo(
        1
    )
  }

  @Test
  fun test_c() {
    assertThat(
        D184.greatestCommonDenominator(listOf(400, 360, 1440))
    ).isEqualTo(
        40
    )
  }

  @Test
  fun test_z0() {
    val thrown = assertThrows<IllegalArgumentException> {
      D184.greatestCommonDenominator(listOf())
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
        D184.extractFactors(2)
    ).isEqualTo(
        listOf(2L)
    )
  }

  @Test
  fun test_extract_factors_of_10() {
    assertThat(
        D184.extractFactors(10)
    ).isEqualTo(
        listOf(2L, 5L)
    )
  }

  @Test
  fun test_extract_factors_of_81() {
    assertThat(
        D184.extractFactors(81)
    ).isEqualTo(
        listOf(3L, 3L, 3L, 3L)
    )
  }

  @Test
  fun test_extract_factors_of_360() {
    assertThat(
        D184.extractFactors(360)
    ).isEqualTo(
        listOf(2L, 2L, 2L, 3L, 3L, 5L)
    )
  }

  @Test
  fun test_extract_factors_of_0() {
    val thrown = assertThrows<IllegalArgumentException> {
      D184.extractFactors(0)
    }
    assertThat(
        thrown.message
    ).isEqualTo(
        "Can't extract the factors of 0"
    )
  }

}
