package dev.petuska.kommander.buildah.dsl.option

import dev.petuska.kommander.buildah.domain.command.BuildahProgram
import dev.petuska.kommander.buildah.domain.option.BuildahProgramOption
import dev.petuska.kommander.core.opt
import dev.petuska.kommander.core.util.KommanderOptionDsl

/**
 * @see [BuildahProgramOption.Version]
 */
@KommanderOptionDsl
public val BuildahProgram.version: BuildahProgram
  get() = opt(BuildahProgramOption.Version)
