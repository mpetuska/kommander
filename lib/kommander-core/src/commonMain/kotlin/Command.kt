package dev.petuska.kommander.core

import dev.petuska.kommander.core.util.CMD
import dev.petuska.kommander.core.util.KommanderArgumentDsl
import dev.petuska.kommander.core.util.KommanderCommandDsl
import dev.petuska.kommander.core.util.KommanderOptionDsl
import dev.petuska.kommander.core.util.Named
import dev.petuska.kommander.core.util.StringLike

public typealias GenericCommand = Command<*>

public interface Command<out O : Option> : Named {
  public val program: GenericProgram
  public val options: Set<Option>
  public fun registerOption(option: Option)

  public val arguments: List<GenericArgument>
  public fun registerArgument(argument: GenericArgument)

  public val commands: List<GenericCommand>
  public fun registerCommand(command: GenericCommand)

  public fun command(): CMD = program.command()
  override fun stringify(): String = name + (options + arguments).map(StringLike::stringify).joinToString { " $it" }
}

public class CommandImpl<O : Option>(
  override val program: GenericProgram,
  override val name: String,
  private val _options: MutableSet<Option> = mutableSetOf(),
  private val _arguments: MutableList<GenericArgument> = mutableListOf(),
  private val _commands: MutableList<GenericCommand> = mutableListOf(),
) : Command<O> {
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

  override fun toString(): String = stringify()
}

@KommanderCommandDsl
public infix fun <O, T : Command<O>, C : GenericCommand> T.cmd(command: C): T {
  registerCommand(command)
  return this
}

@KommanderCommandDsl
public fun <O, T : Command<O>, C : GenericCommand> T.cmd(command: C, opts: C.() -> Unit): T {
  registerCommand(command)
  return this
}

@KommanderOptionDsl
public infix fun <O : Option, T : Command<O>> T.opt(option: O): T {
  registerOption(option)
  return this
}

@KommanderArgumentDsl
public infix fun <O : Option, T : Command<O>> T.arg(argument: GenericArgument): T {
  registerArgument(argument)
  return this
}

@KommanderArgumentDsl
public operator fun <O : Option, T : Command<O>> T.plus(argument: String): T = arg(Argument.String(argument))

@KommanderArgumentDsl
public operator fun <O : Option, T : Command<O>> T.plus(argument: Number): T = arg(Argument.Number(argument))

@KommanderArgumentDsl
public operator fun <O : Option, T : Command<O>> T.plus(argument: Boolean): T = arg(Argument.Boolean(argument))
