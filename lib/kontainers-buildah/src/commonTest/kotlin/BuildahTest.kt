package dev.petuska.kontainers.buildah

import local.test.BlockingTest
import kotlin.test.Test

class BuildahTest : BlockingTest {
  @Test
  fun test() = blockingTest {
    buildah()
  }
}
