package dev.petuska.kommander.podman

import local.test.BlockingTest
import kotlin.test.Test

class PodmanTest : BlockingTest {
  @Test
  fun test() = blockingTest {
    podman()
  }
}
