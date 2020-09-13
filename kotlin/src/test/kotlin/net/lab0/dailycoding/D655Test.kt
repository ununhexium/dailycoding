package net.lab0.dailycoding

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class D655Test {
  @Test
  fun `can flips the bits in the example`() {
    val a = "1111 0000 1111 0000 1111 0000 1111 0000"
        .replace(" ", "")
        .toUInt(2)

    val b = "0000 1111 0000 1111 0000 1111 0000 1111"
        .replace(" ", "")
        .toUInt(2)

    assertThat(D655.reverseBits(a)).isEqualTo(b)
  }
}
