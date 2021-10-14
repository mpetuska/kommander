package dev.petuska.kommander.core

import dev.petuska.kommander.core.util.KommanderOptionDsl
import dev.petuska.kommander.core.util.NamedAndValued

public interface Option : NamedAndValued<String?>

public class OptionImpl(override val name: String, override val value: String?) : Option {
  override fun toString(): String = stringify()
}

@KommanderOptionDsl
public infix fun <O : Option, T : Command<O>> T.opt(option: O): T {
  registerOption(option)
  return this
}
