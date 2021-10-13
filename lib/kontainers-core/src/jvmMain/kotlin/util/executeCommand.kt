package dev.petuska.kontainers.core.util

import java.io.InputStreamReader


internal actual fun executeCommand(cmd: String, onEachLine: (String) -> Unit): Int =
  Runtime.getRuntime().exec(cmd).let { p ->
    val reader = InputStreamReader(p.inputStream)
    reader.useLines {
      it.forEach(onEachLine)
    }
    p.waitFor()
  }
