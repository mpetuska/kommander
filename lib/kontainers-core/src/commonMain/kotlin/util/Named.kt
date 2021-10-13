package dev.petuska.kontainers.core.util

public interface StringLike {
  public fun asString(): String
}

public interface Named : StringLike {
  public val name: String
  public override fun asString(): String = name
}

public interface Valued<T> : StringLike {
  public val value: T
  override fun asString(): String = value?.let { "$it" } ?: ""
}

public interface NamedAndValued<T> : Named, Valued<T> {
  override fun asString(): String = name + (value?.let { " $it" } ?: "")
}
