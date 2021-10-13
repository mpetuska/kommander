package dev.petuska.kommander.buildah.domain.program

import dev.petuska.kommander.core.CMD
import dev.petuska.kommander.core.GenericArgument
import dev.petuska.kommander.core.Program
import dev.petuska.kommander.core.util.StringLike
import dev.petuska.kommander.core.util.WithArguments
import dev.petuska.kommander.core.util.WithOptions

public interface BuildahProgram : Program<BuildahProgramOption>, WithOptions<BuildahProgramOption>, WithArguments

internal data class BuildahProgramImpl(
  private val _options: MutableSet<BuildahProgramOption>,
  private val _arguments: MutableSet<GenericArgument>
) : BuildahProgram {
  override val name: String = "buildah"

  override val arguments: Set<GenericArgument> get() = _arguments
  override fun registerArgument(argument: GenericArgument) {
    _arguments += argument
  }

  override val options: Set<BuildahProgramOption> get() = _options
  override fun registerOption(option: BuildahProgramOption) {
    _options += option
  }

  override fun cmd(): CMD = CMD(name, (options + arguments).map(StringLike::stringify))
}
