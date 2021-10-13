package dev.petuska.kommander.core.util

import dev.petuska.kommander.core.Option

public interface WithOptions<O : Option> {
  public val options: Set<O>
  public fun registerOption(option: O)
}

public infix fun <O : Option, T : WithOptions<O>> T.opt(option: O): T {
  registerOption(option)
  return this
}
