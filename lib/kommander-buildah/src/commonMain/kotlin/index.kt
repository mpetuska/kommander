package dev.petuska.kommander.buildah

import dev.petuska.kommander.buildah.domain.command.BuildahProgram
import dev.petuska.kommander.buildah.domain.command.BuildahProgramImpl
import dev.petuska.kommander.core.util.KommanderProgramDsl

@KommanderProgramDsl
public val buildah: BuildahProgram
  get() = BuildahProgramImpl()
