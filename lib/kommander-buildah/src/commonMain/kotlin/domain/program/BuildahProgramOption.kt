package dev.petuska.kommander.buildah.domain.program

import dev.petuska.kommander.core.Option
import dev.petuska.kommander.buildah.domain.util.LogLevel as PublicLogLevel

public sealed interface BuildahProgramOption : Option {
  /**
   * Show help
   */
  public object Help : BuildahProgramOption {
    override val value: String? = null
    override val name: String = "--help"
  }

  /**
   * Show version
   */
  public object Version : BuildahProgramOption {
    override val value: String? = null
    override val name: String = "--version"
  }

  /**
   * The log level to be used. Either "trace", "debug", "info", "warn", "error", "fatal", or "panic", defaulting to "warn".
   */
  public data class LogLevel(val level: PublicLogLevel) : BuildahProgramOption {
    override val value: String get() = level.toString()
    override val name: String = "--log-level"
  }

  /**
   * Pathname  of the configuration file which specifies which container registries
   * should be consulted when completing image names which do not include a registry or domain portion.
   * It is not recommended that this option be used, as the default behavior of using the system-wide
   * configuration (/etc/containers/registries.conf) is most often preferred.
   */
  public data class RegistriesConf(override val value: String) : BuildahProgramOption {
    override val name: String = "--registries-conf"
  }

  /**
   * Pathname of the directory which contains configuration snippets which specify registries which
   * should be consulted when completing image names which do not include a registry or domain portion.
   * It is not recommended that this option be used, as the default behavior of using the system-wide
   * configuration (/etc/containers/registries.d) is most often preferred.
   */
  public data class RegistriesConfDir(override val value: String) : BuildahProgramOption {
    override val name: String = "--registries-conf-dir"
  }

  /**
   * Storage root dir (default: "/var/lib/containers/storage" for UID 0,
   * "$HOME/.local/share/containers/storage" for other users) Default root dir
   * is configured in /etc/containers/storage.conf
   */
  public data class Root(override val value: String) : BuildahProgramOption {
    override val name: String = "--root"
  }

  /**
   * Storage state dir (default: "/run/containers/storage" for UID 0, "/run/user/$UID" for other users)
   * Default state dir is configured in /etc/containers/storage.conf
   */
  public data class RunRoot(override val value: String) : BuildahProgramOption {
    override val name: String = "--runroot"
  }

  /**
   * The  default storage driver for UID 0 is configured in /etc/containers/storage.conf
   * ($HOME/.config/containers/storage.conf in rootless mode), and is vfs for other users.
   * The STORAGE_DRIVER environment variable overrides the default.
   * The --storage-driver specified driver overrides all.
   */
  public data class StorageDriver(override val value: String) : BuildahProgramOption {
    override val name: String = "--storage-driver"
  }

  /**
   * Storage driver option, Default storage driver options are configured in /etc/containers/storage.conf
   * ($HOME/.config/containers/storage.conf in rootless mode).
   * The STORAGE_OPTS environment variable overrides the default.
   * The --storage-opt specified options overrides all.
   */
  public data class StorageOpt(override val value: String) : BuildahProgramOption {
    override val name: String = "--storage-opt"
  }

  /**
   * Directly  specifies  a UID mapping which should be used to set ownership, at the filesystem level,
   * on the working container's contents.  Commands run when handling RUN instructions will default
   * to being run in their own user namespaces, configured using the UID and GID maps.
   *
   * Entries in this map take the form of one or more colon-separated triples of a starting in-container UID,
   * a corresponding starting host-level UID, and the number of consecutive IDs which the map entry represents.
   *
   * This option overrides the remap-uids setting in the options section of /etc/containers/storage.conf.
   *
   * If this option is not specified, but a global --userns-uid-map setting is supplied,
   * settings from the global option will be used.
   *
   * If none of --userns-uid-map-user, --userns-gid-map-group, or --userns-uid-map are specified,
   * but --userns-gid-map is specified, the UID map will be set to use the same numeric values as the GID map.
   *
   * NOTE: When this option is specified by a rootless user, the specified mappings are relative to the
   * rootless usernamespace in the container, rather than being relative to the host as it would be when run rootful.
   */
  public data class UserNsUidMap(override val value: String) : BuildahProgramOption {
    override val name: String = "--userns-uid-map"
  }

  /**
   * Directly  specifies  a GID mapping which should be used to set ownership, at the filesystem level,
   * on the working container's contents.  Commands run when handling RUN instructions will default
   * to being run in their own user namespaces, configured using the UID and GID maps.
   *
   * Entries in this map take the form of one or more colon-separated triples of a starting in-container
   * GID, a corresponding starting host-level GID, and the number of consecutive IDs which the map entry represents.
   *
   * This option overrides the remap-gids setting in the options section of /etc/containers/storage.conf.
   *
   * If this option is not specified, but a global --userns-gid-map setting is supplied,
   * settings from the global option will be used.
   *
   * If none of --userns-uid-map-user, --userns-gid-map-group, or --userns-gid-map are specified,
   * but --userns-uid-map is specified, the GID map will be set to use the same numeric values as the UID map.
   *
   * NOTE: When this option is specified by a rootless user, the specified mappings are relative to the rootless
   * usernamespace in the container, rather than being relative to the host as it would be when run rootful.
   */
  public data class UserNsGidMap(override val value: String) : BuildahProgramOption {
    override val name: String = "--userns-gid-map"
  }
}
