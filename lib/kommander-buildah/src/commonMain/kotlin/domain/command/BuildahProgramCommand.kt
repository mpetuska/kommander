package dev.petuska.kommander.buildah.domain.command

import dev.petuska.kommander.buildah.domain.option.BuildahOption
import dev.petuska.kommander.core.Command
import dev.petuska.kommander.core.CommandImpl
import dev.petuska.kommander.core.GenericProgram

public sealed interface BuildahProgramCommand<O : BuildahOption> : BuildahCommand<O> {
  /**
   * Help about any command
   */
  public class Help(program: GenericProgram) :
    BuildahProgramCommand<BuildahOption>,
    Command<BuildahOption> by CommandImpl(program, "help")
}
