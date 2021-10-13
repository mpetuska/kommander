package dev.petuska.kontainers.core

import dev.petuska.kontainers.core.util.Named
import dev.petuska.kontainers.core.util.executeCommand

public typealias GenericProgram = Program<*>

public interface Program<O : Option> : Named {
  public fun buildCommand(): String
}

public infix operator fun <T : GenericProgram> T.invoke(handler: (String) -> Unit) {
  val cmd = buildCommand()
  val code = executeCommand(cmd, onEachLine = handler)
  if (code != 0) {
    error("Command '$cmd' exited with non-zero exit code: $code")
  }
}

public operator fun <T : GenericProgram> T.invoke(): String {
  var result = ""
  invoke {
    result += it
  }
  return result
}
