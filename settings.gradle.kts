plugins {
  id("de.fayard.refreshVersions") version "0.30.0"
  id("com.gradle.enterprise") version "3.7"
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
