package dev.petuska.kontainers.core.util

import kotlinx.cinterop.refTo
import kotlinx.cinterop.toKString
import platform.posix.fgets
import platform.posix.pclose
import platform.posix.popen

internal actual fun executeCommand(cmd: String, onEachLine: (String) -> Unit): Int {
  val fp = popen(cmd, "r") ?: error("Failed to run command: $cmd")
  
  val buffer = ByteArray(4096)
  while (true) {
    val input = fgets(buffer.refTo(0), buffer.size, fp) ?: break
    onEachLine(input.toKString())
  }
  
  return pclose(fp)
}
