package dev.petuska.kommander.buildah.domain.command

import dev.petuska.kommander.buildah.domain.option.BuildahOption
import dev.petuska.kommander.core.Command

public sealed interface BuildahCommand<O : BuildahOption> : Command<O>
