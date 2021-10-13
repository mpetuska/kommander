package dev.petuska.kontainers.core

import dev.petuska.kontainers.core.util.Named

public typealias GenericCommand = Command<*>
public interface Command<O : Option> : Named
