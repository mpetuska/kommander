plugins {
  id("de.fayard.refreshVersions") version "0.23.0"
  id("com.gradle.enterprise") version "3.12.3"
}

rootProject.name = "kommander"
include(":test")
include(
  ":lib:kommander-core",
  ":lib:kommander-buildah",
  ":lib:kommander-podman",
)

refreshVersions {
  extraArtifactVersionKeyRules(rootDir.resolve("versions.rules"))
}
