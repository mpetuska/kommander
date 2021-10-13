plugins {
  id("plugin.library-mpp")
  id("plugin.publishing-mpp")
}

kotlin {
  sourceSets {
    commonMain {
      dependencies {
        api(project(":lib:kontainers-core"))
      }
    }
  }
}
