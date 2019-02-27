package net.lab0.dailycoding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class D184 {
  public static Long greatestCommonDenominator(List<Long> list) {
    if (list.isEmpty()) {
      throw new IllegalArgumentException("The vector can't be empty");
    }

    List<List<Long>> factors = list
        .stream()
        .map(D184::extractFactors)
        .collect(Collectors.toList());

    System.out.println("factors " + factors);

    List<Long> distinctFactors = factors
        .stream()
        .flatMap(Collection::stream)
        .distinct()
        .collect(Collectors.toList());

    System.out.println("distinct_factors " + distinctFactors);

    List<Long> common = distinctFactors
        .stream()
        .map(singleFactor -> {
               Long count = factors
                   .stream()
                   .map(factorsOfNumber ->
                            factorsOfNumber.stream()
                                           .filter(f -> f.equals(singleFactor))
                                           .count()
                   ).reduce(Long::min).orElse(0L);
               // TODO: add test with only 1 number in the list
               return Collections.nCopies(count.intValue(), singleFactor);
             }
        ).flatMap(Collection::stream).collect(Collectors.toList());

    System.out.println("common " + common);

    return common.stream().reduce(1L, (a, b) -> a * b);
  }

  public static List<Long> extractFactors(Long n) {
    if (n <= 0L) {
      throw new IllegalArgumentException("Can't extract the factors of 0");
    }
    long index = 2L;
    long current = n;
    ArrayList<Long> factors = new ArrayList<>();
    while (index <= n) {
      while (current % index == 0L) {
        factors.add(index);
        current /= index;
      }
      index += 1;
    }
    return factors;
  }
}
