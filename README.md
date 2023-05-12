# me.pmatiello/tui

This library provides functions for simple terminal user interfaces in Clojure. It 
offers functions for rendering styled text, printing to stdout and reading from stdin.

## Usage

This library is available on the [clojars](https://clojars.org) repository. Refer to
the link in the image below for instructions on how to add it as a dependency to a
Clojure project.

[![Clojars Project](https://img.shields.io/clojars/v/me.pmatiello/tui.svg)](https://clojars.org/me.pmatiello/tui)

## Development

Information for developing this library.

### Running tests

The following command will execute the unit tests:

```
% clj -X:test
```

### Building

The following command will build a jar file:

```
% clj -T:build jar
```

To clean a previous build, run:

```
% clj -T:build clean
```

### Releasing

Before releasing, update the library version in the [build.clj](./build.clj) file.

Make a commit and generate a new tag:

```
% git commit -a -m "Release: ${VERSION}"
% git tag -a "v${VERSION}" -m "Release: ${VERSION}"
% git push
% git push origin "v${VERSION}" 
```

To release to [clojars](https://clojars.org), run:

```
% mvn deploy:deploy-file \
      -Dfile=target/tui-${VERSION}.jar \
      -DrepositoryId=clojars \
      -Durl=https://clojars.org/repo \
      -DpomFile=target/classes/META-INF/maven/me.pmatiello/tui/pom.xml
```

Notice that this step requires clojars to be configured as a server in the local
`~/.m2/settings.xml` file.

## Contribution Policy

This software is open-source, but closed to contributions.
