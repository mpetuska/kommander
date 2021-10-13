package dev.petuska.kommander.core

import dev.petuska.kommander.core.util.StringLike
import dev.petuska.kommander.core.util.executeCommand

public data class CMD(val exe: String, val args: List<String> = emptyList()) : StringLike {
  override fun toString(): String = stringify()
  override fun stringify(): String = exe + args.joinToString("") { " $it" }

  /**
   * Executes the command
   * @param stdout handler. Defaults to printing it to console
   */
  public operator fun invoke(stdout: (String) -> Unit = ::println): Int {
    return executeCommand(this, stdout = stdout)
  }
}
