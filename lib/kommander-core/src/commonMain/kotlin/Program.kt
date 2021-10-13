package dev.petuska.kommander.core

import dev.petuska.kommander.core.util.Named

public typealias GenericProgram = Program<*>

public interface Program<O : Option> : Named {
  public fun cmd(): CMD
}

/**
 * Executes the command
 * @param stdout handler. Defaults to printing it to console
 * @return process exit code
 */
public operator fun <T : GenericProgram> T.invoke(stdout: (String) -> Unit = ::println): Int = cmd()(stdout)

/**
 * Executes the command
 * @return stdout
 */
public operator fun <T : GenericProgram> T.invoke(): String {
  val cmd = cmd()
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
