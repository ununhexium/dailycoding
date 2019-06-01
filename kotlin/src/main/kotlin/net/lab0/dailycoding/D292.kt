package net.lab0.dailycoding

/**
 * a -> z
 *      |
 * b -> y
 *
 * (a,b) (y,z)
 *
 * (a,y) (z,b)
 *
 * // TODO: could it be considered as a graph and then be possible only if we can find no loop or if there are loop, the loops are made of an even number of people
 */
object D292 {
  /**
   * @return two teams or null if teams can't be made
   */
  fun makeTeamsWithSets(students: Map<Int, Collection<Int>>): Pair<Collection<Int>, Collection<Int>>? {
    val group1 = mutableSetOf<Int>()
    val group2 = mutableSetOf<Int>()

    val relationships = students.toMutableMap()
    while (relationships.isNotEmpty()) {
      val prioritySelection = group1 + group2

      val relationship = relationships.entries.firstOrNull {
        it.key in prioritySelection
      } ?: relationships.entries.first()

      // next.key is in team A
      val (a, b) = if (relationship.key in group1) group1 to group2 else group2 to group1

      // if any of the students in team A is an enemy of this student -> contradiction, can't build teams
      if (a.any { it in relationship.value }) return null
      b.addAll(relationship.value)

      relationships.remove(relationship.key)
    }

    return group1 to group2
  }
  
}
