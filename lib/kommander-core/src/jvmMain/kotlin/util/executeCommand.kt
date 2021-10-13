package dev.petuska.kommander.core.util

import java.io.InputStreamReader

internal actual fun executeCommand(cmd: CMD, stdout: (String) -> Unit): Int =
  Runtime.getRuntime().exec("$cmd").let { p ->
    val reader = InputStreamReader(p.inputStream)
    reader.useLines {
      it.forEach(stdout)
    }
    p.waitFor()
  }
