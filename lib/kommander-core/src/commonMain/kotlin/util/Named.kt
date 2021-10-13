package dev.petuska.kommander.core.util

public interface StringLike {
  public fun stringify(): String
}

public interface Named : StringLike {
  public val name: String
  public override fun stringify(): String = name
}

public interface Valued<T> : StringLike {
  public val value: T
  override fun stringify(): String = value?.let { "$it" } ?: ""
}

public interface NamedAndValued<T> : Named, Valued<T> {
  override fun stringify(): String = name + (value?.let { " $it" } ?: "")
}
