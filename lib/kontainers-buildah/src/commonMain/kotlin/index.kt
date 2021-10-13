package dev.petuska.kontainers.buildah

import dev.petuska.kontainers.buildah.domain.program.BuildahProgram
import dev.petuska.kontainers.buildah.domain.program.BuildahProgramImpl

@DslMarker
@Retention(AnnotationRetention.SOURCE)
public annotation class BuildahDsl

public val buildah: BuildahProgram get() = BuildahProgramImpl(mutableSetOf(), mutableSetOf())
