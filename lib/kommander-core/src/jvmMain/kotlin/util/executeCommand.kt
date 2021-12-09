package dev.petuska.kommander.core.util

internal actual fun executeCommand(cmd: CMD, stdout: (String) -> Unit): Int =
  Runtime.getRuntime().exec("$cmd").let { p ->
    p.inputStream.reader().useLines {
      it.forEach(stdout)
    }
    p.waitFor()
  }
