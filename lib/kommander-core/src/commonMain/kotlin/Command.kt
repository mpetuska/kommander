package dev.petuska.kommander.core

import dev.petuska.kommander.core.util.Named

public typealias GenericCommand = Command<*>
public interface Command<O : Option> : Named
