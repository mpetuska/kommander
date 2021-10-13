package dev.petuska.kommander.buildah.domain.command

import dev.petuska.kommander.buildah.domain.option.BuildahProgramOption
import dev.petuska.kommander.core.Program
import dev.petuska.kommander.core.ProgramImpl

public interface BuildahProgram : BuildahCommand<BuildahProgramOption>, Program<BuildahProgramOption>

internal class BuildahProgramImpl : BuildahProgram, Program<BuildahProgramOption> by ProgramImpl("buildah")
