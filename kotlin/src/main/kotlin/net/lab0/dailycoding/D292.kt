package net.lab0.dailycoding

import org.jgrapht.alg.color.GreedyColoring
import org.jgrapht.alg.cycle.SzwarcfiterLauerSimpleCycles
import org.jgrapht.graph.DefaultEdge
import org.jgrapht.graph.DefaultDirectedGraph


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

  fun makeTeamsWithGraphs(students: Map<Int, Collection<Int>>): Pair<Collection<Int>, Collection<Int>>? {
    val g = DefaultDirectedGraph<Int, Any>(Any::class.java)

    students.forEach { (student, enemies) ->
      enemies.forEach { enemy ->
        g.addVertex(student)
        g.addVertex(enemy)
        g.addEdge(student, enemy)
      }
    }

    val cycles = SzwarcfiterLauerSimpleCycles(g).findSimpleCycles()
    if (cycles.any { it.size % 2 == 1 }) return null

    val group1 = mutableSetOf<Int>()
    val group2 = mutableSetOf<Int>()

    val coloring = GreedyColoring(g).coloring
    return if(coloring.colors.size > 2 ) null
    else coloring.colorClasses.first() to coloring.colorClasses.last()
  }
}
