package net.lab0.dailycoding

/**
 * The content of a heap may be any positive number.
 * The player can take any number of items.
 * This is the same as having 1 or 2+ items.
 * This will hereafter be simplified as 1 or 2 items.
 *
 * Each column may have 1 or 2 items, there are 3 columns, so 4 possibilities:
 *
 *     A B C
 * C1> 1 1 1
 * C2> 1 1 2
 * C3> 1 2 2
 * C4> 2 2 2
 *
 * As the order of the heaps doesn't matter...
 *
 * case C1, player 1 looses:
 * P1 takes from A
 * 0 1 1
 * P2 takes from B
 * 0 0 1
 * P1 takes from C and looses
 *
 * case C2, player 1 wins
 * P1 takes 1 from A
 * 1 1 1 -> losing case for P2
 *
 * case C3, player 1 wins
 * P1 takes 1 from A:
 * 0 2 2
 * if P2 takes 1 from B:
 * 0 1 2, then P1 takes 2 from C
 * 0 1 0, P1 wins
 *
 * if P2 takes 2 from B:
 * 0 0 2
 * P1 takes 1 from C
 * 0 0 1, P1 wins
 *
 *
 * case C4, player 1 takes either 1 or 2 from any column
 * 0 2 2 -> P1 looses
 * 1 2 2 -> P1 looses
 *
 *
 * Is it really that simple?
 */
object D289 {
  fun meh(heaps: List<Int>): Boolean {
    return when {
      heaps.all { it == 1 } || heaps.all { it > 1 } -> false //loose
      else -> true // win
    }
  }
}