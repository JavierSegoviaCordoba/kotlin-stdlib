# Changelog

## [Unreleased]

### Added

### Changed

### Deprecated

### Removed

### Fixed

### Updated

- `com.javiersc.hubdle:com.javiersc.hubdle.gradle.plugin -> 0.5.0-alpha.31`

## [0.1.0-alpha.15] - 2023-06-05

### Added

- `root: TreeNode<T>` to `TreeNode<T>`

### Updated

- `com.javiersc.hubdle:com.javiersc.hubdle.gradle.plugin -> 0.5.0-alpha.26`

## [0.1.0-alpha.14] - 2023-06-02

### Added

- `TreeNode` data structure
- `String.removeIf`

### Updated

- `com.javiersc.hubdle:com.javiersc.hubdle.gradle.plugin -> 0.5.0-alpha.24`
- `gradle -> 8.1.1`

## [0.1.0-alpha.13] - 2023-04-17

### Added

- `resource(name: String): File` function
- `resourceOrNull(name: String): File?` function
- `File.children: Sequence<File>`
- `String.transformstring` function
- `String.TRANSFORMSTRING` function
- `String.transformString` function
- `String.TransformString` function
- `String.transform_string` function
- `String.TRANSFORM_STRING` function
- `String.transform_hyphen_string` function
- `String.TRANSFORM_HYPHEN_STRING` function
- `String.tRaNsFoRmStRiNg` function

### Changed

- `@Ignore*` annotation use CamelCase in the target name
- `@IgnoreDARWIN` to `@IgnoreAPPLE`

### Updated

- `gradle -> 8.1`
- `com.javiersc.hubdle:com.javiersc.hubdle.gradle.plugin -> 0.5.0-alpha.8`
- `easimon/wipe-cache -> v2`

## [0.1.0-alpha.12] - 2022-10-18

### Added

- `String::capitalize`
- `String::decapitalize`

### Updated

- `com.javiersc.hubdle:com.javiersc.hubdle.gradle.plugin -> 0.2.0-alpha.42`
- `com.android.tools.build:gradle -> 7.3.0`
- `gradle -> 7.5.1`

## [0.1.0-alpha.11] - 2022-07-14

### Added

- `kotlin-test-testng` artifact

## [0.1.0-alpha.10] - 2022-07-14

### Added

- `kotlin-test-junit` artifact
- `kotlin-test-juni5` artifact

### Removed

- `kotlin-test` artifact

## [0.1.0-alpha.9] - 2022-07-14

### Added

- `kotlin-test` artifact

### Updated

- `com.javiersc.hubdle:com.javiersc.hubdle.gradle.plugin -> 0.2.0-alpha.23`

## [0.1.0-alpha.8] - 2022-07-10

### Added

- `String.replace(vararg oldToNewValues: Pair<String, String>): String`
- `String.remove(vararg values: String): String`

### Updated

- `com.javiersc.hubdle:com.javiersc.hubdle.gradle.plugin -> 0.2.0-alpha.20`
- `org.jetbrains.kotlin:kotlin-gradle-plugin -> 1.7.10`

## [0.1.0-alpha.7] - 2022-07-05

### Updated

- `com.javiersc.hubdle:com.javiersc.hubdle.gradle.plugin -> 0.2.0-alpha.8`

## [0.1.0-alpha.6] - 2022-06-29

### Added

- `CharSequence.notContain: Boolean` functions

### Updated

- `org.jetbrains.kotlinx:binary-compatibility-validator -> 0.10.1`
- `org.jetbrains.kotlinx:kotlinx-coroutines-core -> 1.6.3`

## [0.1.0-alpha.5] - 2022-06-14

### Fixed

- `String.ansiColor` function just color the first line in multiline strings

### Updated

- `org.jetbrains.kotlinx:kotlinx-coroutines-core -> 1.6.2`
- `org.jetbrains.kotlinx:binary-compatibility-validator -> 0.10.0`
- `com.javiersc.gradle-plugins:all-plugins -> 0.1.0-rc.43`
- `io.kotest:kotest-assertions-core -> 5.3.0`
- `org.jetbrains.kotlin:kotlin-gradle-plugin -> 1.6.21`
- `gradle -> 7.4.2`

## [0.1.0-alpha.4] - 2022-01-07

### Added

- `List<String>.removeDuplicateEmptyLines`
- `String.removeDuplicateEmptyLines`
- `String.endWithNewLine`

### Changed

- `emptyString()` to `String.Empty`

### Updated

- `com.javiersc.gradle-plugins:all-plugins -> 0.1.0-rc.39`
- `org.jetbrains.kotlinx:kotlinx-coroutines-core -> 1.6.0`
- `gradle -> 7.3.3`
- `io.kotest:kotest-assertions-core -> 5.0.3`
- `org.jetbrains.kotlin:kotlin-gradle-plugin -> 1.6.10`

## [0.1.0-alpha.3] - 2021-11-29

### Changed

- Java support to Java 8

### Fixed

- `com.javiersc.gradle-plugins:all-plugins -> 0.1.0-rc.17`

## [0.1.0-alpha.2] - 2021-11-29

### Added

- `emptyString()`
- `isNotNullNorBlank()` and `isNotNullNorEmpty()`
- `second()`, `third()`, `forth()`, `fifth()` and `penultimate()`
- `OrNull` variants for `second()`, `third()`, `forth()`, `fifth()` and `penultimate()`

### Updated

- `com.javiersc.gradle-plugins:all-plugins -> 0.1.0-rc.17`
- `io.kotest:kotest-assertions-core -> 5.0.0`
- `org.jetbrains.kotlin:kotlin-gradle-plugin -> 1.6.0`

## [0.1.0-alpha.1] - 2021-11-10

### Added

- `AnsiColor` and `String.ansiColor()`
- `String.remove`

### Updated

- `gradle -> 7.3`
- `com.javiersc.gradle-plugins:all-plugins -> 0.1.0-rc.8`
- `org.jetbrains.kotlinx:binary-compatibility-validator -> 0.8.0`

[Unreleased]: https://github.com/JavierSegoviaCordoba/kotlin-stdlib/compare/0.1.0-alpha.15...HEAD

[0.1.0-alpha.15]: https://github.com/JavierSegoviaCordoba/kotlin-stdlib/compare/0.1.0-alpha.14...0.1.0-alpha.15

[0.1.0-alpha.14]: https://github.com/JavierSegoviaCordoba/kotlin-stdlib/compare/0.1.0-alpha.13...0.1.0-alpha.14

[0.1.0-alpha.13]: https://github.com/JavierSegoviaCordoba/kotlin-stdlib/compare/0.1.0-alpha.12...0.1.0-alpha.13

[0.1.0-alpha.12]: https://github.com/JavierSegoviaCordoba/kotlin-stdlib/compare/0.1.0-alpha.11...0.1.0-alpha.12

[0.1.0-alpha.11]: https://github.com/JavierSegoviaCordoba/kotlin-stdlib/compare/0.1.0-alpha.10...0.1.0-alpha.11

[0.1.0-alpha.10]: https://github.com/JavierSegoviaCordoba/kotlin-stdlib/compare/0.1.0-alpha.9...0.1.0-alpha.10

[0.1.0-alpha.9]: https://github.com/JavierSegoviaCordoba/kotlin-stdlib/compare/0.1.0-alpha.8...0.1.0-alpha.9

[0.1.0-alpha.8]: https://github.com/JavierSegoviaCordoba/kotlin-stdlib/compare/0.1.0-alpha.7...0.1.0-alpha.8

[0.1.0-alpha.7]: https://github.com/JavierSegoviaCordoba/kotlin-stdlib/compare/0.1.0-alpha.6...0.1.0-alpha.7

[0.1.0-alpha.6]: https://github.com/JavierSegoviaCordoba/kotlin-stdlib/compare/0.1.0-alpha.5...0.1.0-alpha.6

[0.1.0-alpha.5]: https://github.com/JavierSegoviaCordoba/kotlin-stdlib/compare/0.1.0-alpha.4...0.1.0-alpha.5

[0.1.0-alpha.4]: https://github.com/JavierSegoviaCordoba/kotlin-stdlib/compare/0.1.0-alpha.3...0.1.0-alpha.4

[0.1.0-alpha.3]: https://github.com/JavierSegoviaCordoba/kotlin-stdlib/compare/0.1.0-alpha.2...0.1.0-alpha.3

[0.1.0-alpha.2]: https://github.com/JavierSegoviaCordoba/kotlin-stdlib/compare/0.1.0-alpha.1...0.1.0-alpha.2

[0.1.0-alpha.1]: https://github.com/JavierSegoviaCordoba/kotlin-stdlib/commits/0.1.0-alpha.1
