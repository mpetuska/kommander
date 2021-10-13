package dev.petuska.kommander.core

import dev.petuska.kommander.core.util.CMD
import dev.petuska.kommander.core.util.KommanderProgramDsl
import dev.petuska.kommander.core.util.StringLike

public typealias GenericProgram = Program<*>

public interface Program<O : Option> : Command<O> {
  override fun command(): CMD
}

public class ProgramImpl<O : Option>(
  override val name: String,
  private val _options: MutableSet<Option> = mutableSetOf(),
  private val _arguments: MutableList<GenericArgument> = mutableListOf(),
  private val _commands: MutableList<GenericCommand> = mutableListOf(),
) : Program<O> {
  override val program: GenericProgram = this

  override val options: Set<Option> get() = _options
  override fun registerOption(option: Option) {
    _options.add(option)
  }

  override val arguments: List<GenericArgument> get() = _arguments
  override fun registerArgument(argument: GenericArgument) {
    _arguments.add(argument)
  }

  override val commands: List<GenericCommand> get() = _commands
  override fun registerCommand(command: GenericCommand) {
    _commands.add(command)
  }

  override fun stringify(): String =
    name + (options + arguments + commands).map(StringLike::stringify).joinToString { " $it" }

  override fun command(): CMD = CMD(name, (options + arguments + commands).map(StringLike::stringify))
  override fun toString(): String = stringify()
}

/**
 * Executes the command
 * @param stdout handler. Defaults to printing it to console
 * @return process exit code
 */
@KommanderProgramDsl
public operator fun <T : GenericProgram> T.invoke(stdout: (String) -> Unit = ::println): Int = command()(stdout)

/**
 * Executes the command
 * @return stdout
 */
@KommanderProgramDsl
public operator fun <T : GenericProgram> T.invoke(): String {
  val cmd = command()
  var result = ""
  val exit = cmd {
    result += it
  }
  if (exit == 0) {
    return result
  } else {
    println(result)
    error("$cmd returned non-zero exit code: $exit")
  }
}
