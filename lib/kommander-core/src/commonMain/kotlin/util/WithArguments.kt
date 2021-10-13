package dev.petuska.kommander.core.util

import dev.petuska.kommander.core.Argument
import dev.petuska.kommander.core.GenericArgument

public interface WithArguments {
  public val arguments: Set<GenericArgument>
  public fun registerArgument(argument: GenericArgument)
}

public infix fun <T : WithArguments> T.arg(argument: GenericArgument): T {
  registerArgument(argument)
  return this
}

public operator fun <T : WithArguments> T.plus(argument: String): T = arg(Argument.String(argument))
public operator fun <T : WithArguments> T.plus(argument: Number): T = arg(Argument.Number(argument))
public operator fun <T : WithArguments> T.plus(argument: Boolean): T = arg(Argument.Boolean(argument))
