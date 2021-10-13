[![Dokka docs](https://img.shields.io/badge/docs-dokka-orange?style=flat-square)](http://mpetuska.github.io/kommander)
[![Version maven-central](https://img.shields.io/maven-central/v/dev.petuska/kommander?logo=apache-maven&style=flat-square)](https://mvnrepository.com/artifact/dev.petuska/kommander/latest)

# kommander

Kotlin MPP bindings for various cli tools. The libraries only wrap around the clis and still require them to be natively
available on the PATH. Main use-case is convenient and typesafe scripting with *.kts, however this could also be used in
applications as a regular library (as long as runtime environment had appropriate native tooling installed for each cli)
.

## Modules

* [kommander-core](./lib/kommander-core)[WIP] - core constructs to manage CLI command building
* [kommander-buildah](./lib/kommander-buildah)[WIP] - [buildah](https://buildah.io/) cli bindings
* [kommander-podman](./lib/kommander-buildah)[TODO] - [podman](https://podman.io/) cli bindings
