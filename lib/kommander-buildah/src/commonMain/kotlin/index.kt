package dev.petuska.kommander.buildah

import dev.petuska.kommander.buildah.domain.program.BuildahProgram
import dev.petuska.kommander.buildah.domain.program.BuildahProgramImpl

@DslMarker
@Retention(AnnotationRetention.SOURCE)
public annotation class BuildahDsl

public val buildah: BuildahProgram get() = BuildahProgramImpl(mutableSetOf(), mutableSetOf())
