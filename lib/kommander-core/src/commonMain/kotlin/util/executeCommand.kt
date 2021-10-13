package dev.petuska.kommander.core.util

internal expect fun executeCommand(cmd: CMD, stdout: (String) -> Unit): Int
