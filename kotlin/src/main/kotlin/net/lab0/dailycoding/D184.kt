package net.lab0.dailycoding

/**
 * Given n numbers, find the greatest common denominator between them.
 * For example, given the numbers [42, 56, 14], return 14.
 * The given vector can't be empty
 */

fun greatestCommonDenominator(list: List<Long>): Long {
    if (list.isEmpty()) {
        throw IllegalArgumentException("The vector can't be empty")
    }

    val factors = list.map {
        extractFactors(it)
    }

    println("factors $factors")

    val distinctFactors = factors.flatten().distinct()

    println("distinct_factors $distinctFactors")

    val common = distinctFactors.map { singleFactor ->
        val count = factors.map { factorsOfNumber ->
            factorsOfNumber.count { f ->
                f == singleFactor
            }
        }.min() ?: 0
        List(count) { singleFactor }
    }.flatten()

    println("common $common")

    return common.product()
}

private fun List<Long>.product() = this.fold(1L) { acc, item ->
    acc * item
}

fun extractFactors(n: Long): List<Long> {
    if (n <= 0L) {
        throw IllegalArgumentException("Can't extract the factors of 0")
    }
    var index = 2L
    var current = n
    val factors = mutableListOf<Long>()
    while (index <= n) {
        while (current % index == 0L) {
            factors.add(index)
            current /= index
        }
        index += 1
    }
    return factors
}

