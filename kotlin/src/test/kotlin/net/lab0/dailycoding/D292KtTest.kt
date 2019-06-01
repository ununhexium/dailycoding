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

    val (a1, b1) = D292.makeTeamsWithSets(students)!!
    val (a2, b2) = D292.makeTeamsWithSets(students)!!

    // TODO: the opposite would also be valid
    assertThat(b1).containsExactlyInAnyOrder(0, 1, 4, 5)
    assertThat(a1).containsExactlyInAnyOrder(2, 3)

    assertThat(b2).containsExactlyInAnyOrder(0, 1, 4, 5)
    assertThat(a2).containsExactlyInAnyOrder(2, 3)
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

    val result1 = D292.makeTeamsWithSets(students)
    val result2 = D292.makeTeamsWithGraphs(students)
    assertThat(result1).isNull()
    assertThat(result2).isNull()
  }
}