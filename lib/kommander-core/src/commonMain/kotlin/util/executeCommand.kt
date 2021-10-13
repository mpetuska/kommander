package dev.petuska.kommander.core.util

import dev.petuska.kommander.core.CMD

internal expect fun executeCommand(cmd: CMD, stdout: (String) -> Unit): Int
