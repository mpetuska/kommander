package dev.petuska.kommander.core

import dev.petuska.kommander.core.util.Valued

public typealias GenericArgument = Argument<*>

public sealed interface Argument<T> : Valued<T> {
  public data class String(override val value: kotlin.String) : Argument<kotlin.String> {
    override fun toString(): kotlin.String = stringify()
  }

  public data class Number(override val value: kotlin.Number) : Argument<kotlin.Number> {
    override fun toString(): kotlin.String = stringify()
  }

  public data class Boolean(override val value: kotlin.Boolean) : Argument<kotlin.Boolean> {
    override fun toString(): kotlin.String = stringify()
  }
}
