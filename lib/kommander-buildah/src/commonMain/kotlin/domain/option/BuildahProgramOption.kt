package dev.petuska.kommander.buildah.domain.option

public sealed interface BuildahProgramOption : BuildahOption {
  /**
   * Show version
   */
  public object Version : BuildahProgramOption {
    override val value: String? = null
    override val name: String = "--version"
  }
}
