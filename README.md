# me.pmatiello/tui

This library provides functions for simple terminal user interfaces in Clojure. It 
offers functions for rendering styled text, printing to stdout and reading from stdin.

## Usage

This library is available on the [clojars](https://clojars.org) repository. Refer to
the link in the image below for instructions on how to add it as a dependency to a
Clojure project.

[![Clojars Project](https://img.shields.io/clojars/v/me.pmatiello/tui.svg)](https://clojars.org/me.pmatiello/tui)

The public functions are located in the `me.pmatiello.tui.core` namespace. Please
refer to the docstrings and specs of these functions for usage details and examples.

### Example

```clj
(require '[me.pmatiello.tui.core :as tui])

; print "hello world!" in bold blue text
(tui/println {:style [:bold :fg-blue]
              :body  "hello world!"})
```

### Pages

Rendering and printing functions take pages as arguments.

| Spec                 | Description                                                      |
|----------------------|------------------------------------------------------------------|
| `::specs/page`       | Collection of `::specs/text`                                     |
| `::specs/text`       | Either a `::specs/body` or a `::specs/body+style`                |
| `::specs/body`       | `String`                                                         |
| `::specs/body+style` | Map with `:body` (`::specs/body`) and `:style` (`::specs/style`) |
| `::specs/style`      | Collection of `::specs/style*`                                   |
| `::specs/style*`     | A supported style (see below)                                    |

That is, a page is a collection of texts. Texts can either be strings or maps
containing a body and a list of styles.

Some valid texts are:

```clj
"plain text"
```

```clj
{:style [:bold :fg-blue] :body "styled text"}
```

#### Styles

These are the supported styles:

| ANSI Code            | Description                                    |
|----------------------|------------------------------------------------|
| `:reset`             | Resets all attributes and colors to default.   |
| `:bold`              | Bold intensity.                                |
| `:faint`             | Faint intensity.                               |
| `:italic`            | Italicized.                                    |
| `:underline`         | Underline.                                     |
| `:slow-blink`        | Slow blink.                                    |
| `:fast-blink`        | Fast blink.                                    |
| `:reverse-video`     | Reverses the foreground and background colors. |
| `:conceal`           | Conceals the text.                             |
| `:strike`            | Strikethrough.                                 |
| `:weight-off`        | Unsets bold or faint intensity.                |
| `:italic-off`        | Unsets italics.                                |
| `:underline-off`     | Unsets underline.                              |
| `:blink-off`         | Unsets blinking.                               |
| `:reverse-video-off` | Unsets reverse video.                          |
| `:conceal-off`       | Unsets text concealment.                       |
| `:strike-off`        | Unsets strikethrough.                          |
| `:fg-black`          | Black text.                                    |
| `:fg-red`            | Red text.                                      |
| `:fg-green`          | Green text.                                    |
| `:fg-yellow`         | Yellow text.                                   |
| `:fg-blue`           | Blue text.                                     |
| `:fg-purple`         | Purple text.                                   |
| `:fg-cyan`           | Cyan text.                                     |
| `:fg-white`          | White text.                                    |
| `:fg-default`        | Default text.                                  |
| `:bg-black`          | Black background.                              |
| `:bg-red`            | Red background.                                |
| `:bg-green`          | Green background.                              |
| `:bg-yellow`         | Yellow background.                             |
| `:bg-blue`           | Blue background.                               |
| `:bg-purple`         | Purple background.                             |
| `:bg-cyan`           | Cyan background.                               |
| `:bg-white`          | White background.                              |
| `:bg-default`        | Default background.                            |

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
