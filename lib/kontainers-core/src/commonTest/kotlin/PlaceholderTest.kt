package dev.petuska.kontainers.core

import local.test.BlockingTest
import kotlin.test.Test

class PlaceholderTest : BlockingTest {
  @Test
  fun test() = blockingTest {
    println("Nothing Yet!")
  }
}
