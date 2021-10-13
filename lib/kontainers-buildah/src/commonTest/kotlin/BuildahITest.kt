package dev.petuska.kontainers.buildah

import dev.petuska.kontainers.buildah.domain.util.LogLevel
import dev.petuska.kontainers.buildah.dsl.help
import dev.petuska.kontainers.buildah.dsl.logLevel
import dev.petuska.kontainers.buildah.dsl.registriesConf
import dev.petuska.kontainers.buildah.dsl.registriesConfDir
import dev.petuska.kontainers.buildah.dsl.root
import dev.petuska.kontainers.buildah.dsl.runRoot
import dev.petuska.kontainers.buildah.dsl.storageDriver
import dev.petuska.kontainers.buildah.dsl.storageOpt
import dev.petuska.kontainers.buildah.dsl.userNsGidMap
import dev.petuska.kontainers.buildah.dsl.userNsUidMap
import dev.petuska.kontainers.buildah.dsl.version
import dev.petuska.kontainers.core.invoke
import dev.petuska.kontainers.core.util.plus
import local.test.BlockingTest
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

class BuildahITest : BlockingTest {
  @Test
  fun buildAllDynamicOptions() = blockingTest {
    var cmd = buildah logLevel LogLevel.debug logLevel "info" root "root" runRoot "runRoot"
    cmd = cmd registriesConf "registriesConf" registriesConfDir "registriesConfDir"
    cmd = cmd storageDriver "storageDriver" storageOpt "storageOpt"
    cmd = cmd userNsUidMap "userNsUidMap" userNsGidMap "userNsGidMap"
    
    assertEquals(
      expected = "buildah --log-level debug --log-level info --root root --runroot runRoot " +
          "--registries-conf registriesConf --registries-conf-dir registriesConfDir --storage-driver storageDriver " +
          "--storage-opt storageOpt --userns-uid-map userNsUidMap --userns-gid-map userNsGidMap",
      actual = cmd.buildCommand().also(::println)
    )
  }
  
  @Test
  fun buildAllStaticOptions() = blockingTest {
    val cmd = buildah.help().version() + "my" + "custom" + 1 + true
    
    assertEquals(
      expected = "buildah --help --version my custom 1 true",
      actual = cmd.buildCommand().also(::println)
    )
  }
  
  @Test
  fun executeVersion() = blockingTest {
    val cmd = buildah.version()
    assertContains(
      charSequence = cmd().also(::println),
      regex = Regex("buildah version ([0-9]+.){2}\\.[0-9]+ \\(image-spec .+, runtime-spec .+\\)")
    )
  }
}
