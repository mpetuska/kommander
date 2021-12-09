package dev.petuska.kommander.buildah

import dev.petuska.klip.api.assertKlip
import dev.petuska.kommander.buildah.domain.util.LogLevel
import dev.petuska.kommander.buildah.dsl.command.Help
import dev.petuska.kommander.buildah.dsl.option.help
import dev.petuska.kommander.buildah.dsl.option.logLevel
import dev.petuska.kommander.buildah.dsl.option.registriesConf
import dev.petuska.kommander.buildah.dsl.option.registriesConfDir
import dev.petuska.kommander.buildah.dsl.option.root
import dev.petuska.kommander.buildah.dsl.option.runRoot
import dev.petuska.kommander.buildah.dsl.option.storageDriver
import dev.petuska.kommander.buildah.dsl.option.storageOpt
import dev.petuska.kommander.buildah.dsl.option.userNsGidMap
import dev.petuska.kommander.buildah.dsl.option.userNsUidMap
import dev.petuska.kommander.buildah.dsl.option.version
import dev.petuska.kommander.core.invoke
import dev.petuska.kommander.core.plus
import kotlin.test.Test
import kotlin.test.assertContains
import local.test.BlockingTest

class BuildahITest : BlockingTest {
  @Test
  fun buildAllDynamicOptions() = blockingTest {
    val program = buildah logLevel LogLevel.debug logLevel "info" root
        "root" runRoot "runRoot" registriesConf "registriesConf" registriesConfDir "registriesConfDir" storageDriver
        "storageDriver" storageOpt "storageOpt" userNsUidMap "userNsUidMap" userNsGidMap "userNsGidMap"
    
    program.command().assertKlip()
  }
  
  @Test
  fun buildAllStaticOptions() = blockingTest {
    val program = buildah.version.help + "my" + "custom" + 1 + true Help {
      help
      Help
    }
    
    program.command().assertKlip()
  }
  
  @Test
  fun executeVersion() = blockingTest {
    val program = buildah.version
    assertContains(
      charSequence = program(),
      regex = Regex("buildah version ([0-9]+.){2}\\.[0-9]+ \\(image-spec .+, runtime-spec .+\\)")
    )
  }
}
