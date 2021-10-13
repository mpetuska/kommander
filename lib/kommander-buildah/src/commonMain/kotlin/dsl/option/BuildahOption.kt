package dev.petuska.kommander.buildah.dsl.option

import dev.petuska.kommander.buildah.domain.command.BuildahCommand
import dev.petuska.kommander.buildah.domain.option.BuildahOption
import dev.petuska.kommander.buildah.domain.util.LogLevel
import dev.petuska.kommander.core.opt
import dev.petuska.kommander.core.util.KommanderOptionDsl

/**
 * @see [BuildahOption.Help]
 */
@KommanderOptionDsl
public val <O : BuildahOption, T : BuildahCommand<O>> T.help: T
  get() = opt(BuildahOption.Help)

/**
 * @see [BuildahOption.LogLevel]
 */
@KommanderOptionDsl
public infix fun <O : BuildahOption, T : BuildahCommand<O>> T.logLevel(level: LogLevel): T =
  opt(BuildahOption.LogLevel(level))

/**
 * @see [BuildahOption.LogLevel]
 */
@KommanderOptionDsl
public infix fun <O : BuildahOption, T : BuildahCommand<O>> T.logLevel(level: String): T =
  opt(BuildahOption.LogLevel(LogLevel.valueOf(level)))

/**
 * @see [BuildahOption.RegistriesConf]
 */
@KommanderOptionDsl
public infix fun <O : BuildahOption, T : BuildahCommand<O>> T.registriesConf(value: String): T =
  opt(BuildahOption.RegistriesConf(value))

/**
 * @see [BuildahOption.RegistriesConfDir]
 */
@KommanderOptionDsl
public infix fun <O : BuildahOption, T : BuildahCommand<O>> T.registriesConfDir(value: String): T =
  opt(BuildahOption.RegistriesConfDir(value))

/**
 * @see [BuildahOption.Root]
 */
@KommanderOptionDsl
public infix fun <O : BuildahOption, T : BuildahCommand<O>> T.root(value: String): T =
  opt(BuildahOption.Root(value))

/**
 * @see [BuildahOption.RunRoot]
 */
@KommanderOptionDsl
public infix fun <O : BuildahOption, T : BuildahCommand<O>> T.runRoot(value: String): T =
  opt(BuildahOption.RunRoot(value))

/**
 * @see [BuildahOption.StorageDriver]
 */
@KommanderOptionDsl
public infix fun <O : BuildahOption, T : BuildahCommand<O>> T.storageDriver(value: String): T =
  opt(BuildahOption.StorageDriver(value))

/**
 * @see [BuildahOption.StorageOpt]
 */
@KommanderOptionDsl
public infix fun <O : BuildahOption, T : BuildahCommand<O>> T.storageOpt(value: String): T =
  opt(BuildahOption.StorageOpt(value))

/**
 * @see [BuildahOption.UserNsUidMap]
 */
@KommanderOptionDsl
public infix fun <O : BuildahOption, T : BuildahCommand<O>> T.userNsUidMap(value: String): T =
  opt(BuildahOption.UserNsUidMap(value))

/**
 * @see [BuildahOption.UserNsGidMap]
 */
@KommanderOptionDsl
public infix fun <O : BuildahOption, T : BuildahCommand<O>> T.userNsGidMap(value: String): T =
  opt(BuildahOption.UserNsGidMap(value))
