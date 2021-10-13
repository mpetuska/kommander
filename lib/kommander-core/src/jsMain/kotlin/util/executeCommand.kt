package dev.petuska.kommander.core.util

import kotlin.js.Json
import kotlin.js.json

@JsModule("child_process")
private external object ChildProcess {
  fun execSync(cmd: String, options: Json = definedExternally): String
  fun spawnSync(cmd: String, args: Array<String>, options: Json = definedExternally): Json
}

internal actual fun executeCommand(cmd: CMD, stdout: (String) -> Unit): Int {
  try {
    ChildProcess.execSync("$cmd", json("encoding" to "utf-8"))
      .split("\n")
      .forEach(stdout)
  } catch (e: Error) {
    return 1
  }
  return 0
}
