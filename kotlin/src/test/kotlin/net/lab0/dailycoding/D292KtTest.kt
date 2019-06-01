package net.lab0.dailycoding

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class D292KtTest {
  @Test
  fun `can make teams with no student`() {
    val students = mapOf<Int, List<Int>>()
    val (a, b) = D292.makeTeamsWithSets(students)!!
    assertThat(a).isEmpty()
    assertThat(b).isEmpty()
  }

  @Test
  fun `can make a team with given sample`() {
    val students = mapOf(
        0 to listOf(3),
        1 to listOf(2),
        2 to listOf(1, 4),
        3 to listOf(0, 4, 5),
        4 to listOf(2, 3),
        5 to listOf(3)
    )

    val (a, b) = D292.makeTeamsWithSets(students)!!

    // TODO: the opposite would also be valid
    assertThat(b).containsExactlyInAnyOrder(0, 1, 4, 5)
    assertThat(a).containsExactlyInAnyOrder(2, 3)
  }

  @Test
  fun `return null when can't make a group`() {
    val students = mapOf(
      0 to listOf(3),
      1 to listOf(2),
      2 to listOf(1, 3, 4),
      3 to listOf(0, 2, 4, 5),
      4 to listOf(2, 3),
      5 to listOf(3)
    )

    val result = D292.makeTeamsWithSets(students)
    assertThat(result).isNull()
  }
}