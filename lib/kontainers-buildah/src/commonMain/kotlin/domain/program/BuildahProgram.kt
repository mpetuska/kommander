package dev.petuska.kontainers.buildah.domain.program

import dev.petuska.kontainers.core.GenericArgument
import dev.petuska.kontainers.core.Program
import dev.petuska.kontainers.core.util.StringLike
import dev.petuska.kontainers.core.util.WithArguments
import dev.petuska.kontainers.core.util.WithOptions


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
  
  override fun buildCommand(): String =
    (listOf(this) + options + arguments).joinToString(" ", transform = StringLike::asString)
}
