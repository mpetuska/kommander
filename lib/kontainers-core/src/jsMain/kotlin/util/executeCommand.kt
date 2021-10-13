package dev.petuska.kontainers.core.util

import kotlin.js.Json

@JsModule("child_process")
private external object ChildProcess {
  fun execSync(cmd: String, options: Json = definedExternally): String
  fun spawnSync(cmd: String, args: Array<String>, options: Json = definedExternally): Json
}

internal actual fun executeCommand(cmd: String, onEachLine: (String) -> Unit): Int {
  try {
    ChildProcess.execSync(cmd, json("encoding" to "utf-8"))
      .split("\n")
      .forEach(onEachLine)
  } catch (e: Error) {
    return 1
  }
  return 0
}
