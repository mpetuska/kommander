package dev.petuska.kontainers.core.util

internal expect fun executeCommand(cmd: String, onEachLine: (String) -> Unit): Int
