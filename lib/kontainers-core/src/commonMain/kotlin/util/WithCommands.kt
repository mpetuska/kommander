package dev.petuska.kontainers.core.util

import dev.petuska.kontainers.core.GenericCommand

public interface WithCommands {
  public fun registerCommand(command: GenericCommand)
}

public infix fun <T : WithCommands> T.cmd(command: GenericCommand): T {
  registerCommand(command)
  return this
}
