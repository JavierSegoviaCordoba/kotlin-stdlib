# Changelog

## [Unreleased]

### Added

### Changed

### Deprecated

### Removed

### Fixed

### Updated

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

## [0.0.0] - 2021-11-04

- No changes
