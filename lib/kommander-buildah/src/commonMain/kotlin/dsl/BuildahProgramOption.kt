package dev.petuska.kommander.buildah.dsl

import dev.petuska.kommander.buildah.BuildahDsl
import dev.petuska.kommander.buildah.domain.program.BuildahProgram
import dev.petuska.kommander.buildah.domain.program.BuildahProgramOption
import dev.petuska.kommander.buildah.domain.util.LogLevel
import dev.petuska.kommander.core.util.opt

/**
 * @see [BuildahProgramOption.Help]
 */
@BuildahDsl
public fun BuildahProgram.help(): BuildahProgram = opt(BuildahProgramOption.Help)

/**
 * @see [BuildahProgramOption.Version]
 */
@BuildahDsl
public fun BuildahProgram.version(): BuildahProgram =
  opt(BuildahProgramOption.Version)

/**
 * @see [BuildahProgramOption.LogLevel]
 */
@BuildahDsl
public infix fun BuildahProgram.logLevel(level: LogLevel): BuildahProgram =
  opt(BuildahProgramOption.LogLevel(level))

/**
 * @see [BuildahProgramOption.LogLevel]
 */
@BuildahDsl
public infix fun BuildahProgram.logLevel(level: String): BuildahProgram =
  opt(BuildahProgramOption.LogLevel(LogLevel.valueOf(level)))

/**
 * @see [BuildahProgramOption.RegistriesConf]
 */
@BuildahDsl
public infix fun BuildahProgram.registriesConf(value: String): BuildahProgram =
  opt(BuildahProgramOption.RegistriesConf(value))

/**
 * @see [BuildahProgramOption.RegistriesConfDir]
 */
@BuildahDsl
public infix fun BuildahProgram.registriesConfDir(value: String): BuildahProgram =
  opt(BuildahProgramOption.RegistriesConfDir(value))

/**
 * @see [BuildahProgramOption.Root]
 */
@BuildahDsl
public infix fun BuildahProgram.root(value: String): BuildahProgram =
  opt(BuildahProgramOption.Root(value))

/**
 * @see [BuildahProgramOption.RunRoot]
 */
@BuildahDsl
public infix fun BuildahProgram.runRoot(value: String): BuildahProgram =
  opt(BuildahProgramOption.RunRoot(value))

/**
 * @see [BuildahProgramOption.StorageDriver]
 */
@BuildahDsl
public infix fun BuildahProgram.storageDriver(value: String): BuildahProgram =
  opt(BuildahProgramOption.StorageDriver(value))

/**
 * @see [BuildahProgramOption.StorageOpt]
 */
@BuildahDsl
public infix fun BuildahProgram.storageOpt(value: String): BuildahProgram =
  opt(BuildahProgramOption.StorageOpt(value))

/**
 * @see [BuildahProgramOption.UserNsUidMap]
 */
@BuildahDsl
public infix fun BuildahProgram.userNsUidMap(value: String): BuildahProgram =
  opt(BuildahProgramOption.UserNsUidMap(value))

/**
 * @see [BuildahProgramOption.UserNsGidMap]
 */
@BuildahDsl
public infix fun BuildahProgram.userNsGidMap(value: String): BuildahProgram =
  opt(BuildahProgramOption.UserNsGidMap(value))
