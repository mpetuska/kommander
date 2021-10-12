plugins {
  id("de.fayard.refreshVersions") version "0.23.0"
  id("com.gradle.enterprise") version "3.7"
}

rootProject.name = "kontainers"
include(":test")
include(
  ":lib:kontainers-buildah",
  ":lib:kontainers-podman"
)
