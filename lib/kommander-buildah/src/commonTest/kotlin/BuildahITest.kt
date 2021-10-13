package dev.petuska.kommander.buildah

import dev.petuska.klip.api.assertKlip
import dev.petuska.kommander.buildah.domain.util.LogLevel
import dev.petuska.kommander.buildah.dsl.help
import dev.petuska.kommander.buildah.dsl.logLevel
import dev.petuska.kommander.buildah.dsl.registriesConf
import dev.petuska.kommander.buildah.dsl.registriesConfDir
import dev.petuska.kommander.buildah.dsl.root
import dev.petuska.kommander.buildah.dsl.runRoot
import dev.petuska.kommander.buildah.dsl.storageDriver
import dev.petuska.kommander.buildah.dsl.storageOpt
import dev.petuska.kommander.buildah.dsl.userNsGidMap
import dev.petuska.kommander.buildah.dsl.userNsUidMap
import dev.petuska.kommander.buildah.dsl.version
import dev.petuska.kommander.core.invoke
import dev.petuska.kommander.core.util.plus
import local.test.BlockingTest
import kotlin.test.Test
import kotlin.test.assertContains

class BuildahITest : BlockingTest {
  @Test
  fun buildAllDynamicOptions() = blockingTest {
    var program = buildah logLevel LogLevel.debug logLevel "info" root "root" runRoot "runRoot"
    program = program registriesConf "registriesConf" registriesConfDir "registriesConfDir"
    program = program storageDriver "storageDriver" storageOpt "storageOpt"
    program = program userNsUidMap "userNsUidMap" userNsGidMap "userNsGidMap"

    program.cmd().assertKlip()
  }

  @Test
  fun buildAllStaticOptions() = blockingTest {
    val program = buildah.help().version() + "my" + "custom" + 1 + true

    program.cmd().assertKlip()
  }

  @Test
  fun executeVersion() = blockingTest {
    val program = buildah.version()
    assertContains(
      charSequence = program(),
      regex = Regex("buildah version ([0-9]+.){2}\\.[0-9]+ \\(image-spec .+, runtime-spec .+\\)")
    )
  }
}
