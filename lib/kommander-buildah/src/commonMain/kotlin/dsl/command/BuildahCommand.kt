package dev.petuska.kommander.buildah.dsl.command

import dev.petuska.kommander.buildah.domain.command.BuildahCommand
import dev.petuska.kommander.buildah.domain.command.BuildahProgramCommand
import dev.petuska.kommander.buildah.domain.option.BuildahOption
import dev.petuska.kommander.core.cmd
import dev.petuska.kommander.core.util.KommanderCommandDsl

/**
 * @see [BuildahOption.Help]
 */
@KommanderCommandDsl
public val <O : BuildahOption, T : BuildahCommand<O>> T.Help: T
  get() = cmd(BuildahProgramCommand.Help(this.program))

/**
 * @see [BuildahOption.Help]
 */
@KommanderCommandDsl
public infix fun <O : BuildahOption, T : BuildahCommand<O>> T.Help(opts: BuildahProgramCommand.Help.() -> Unit): T =
  cmd(BuildahProgramCommand.Help(this.program), opts)
