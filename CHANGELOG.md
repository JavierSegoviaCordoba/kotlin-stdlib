# Changelog

## [Unreleased]

### Added

- `String.Blank`

### Changed

### Deprecated

### Fixed

- `removeDuplicateEmptyLines` move back to use `String`
- `endWithNewLine` move back to use `String`

### Removed

### Updated

## [0.2.0] - 2025-01-10

### Added

- `invalidIfIsBlank` to Validate APIs
- Validate APIs support specifying a generic error
- Nested validator: `validator(fooValidator, foo)` 
- Nested validator: `foo.validatedBy(fooValidator)`
- Nested validator: `fooValidator.validatorFor(foo)`

### Removed

- `ValidatableList` APIs
- `Graph::toGraph` function
- `Graph::circularVertexes` to be `Map<T, List<Edge<T>>>`

### Updated

- `gradle -> 8.12`
- `com.javiersc.hubdle:com.javiersc.hubdle.gradle.plugin -> 0.8.1`

## [0.1.0] - 2024-11-28

### Added

- Validate Dsl
- `Either` data structure
- `identity` function
- `FileScope` DSL
- `T?.or(other: T): T`
- `T?.or(block: () -> T): T`
- `Iterable<T>.sixth(): T`
- `Iterable<T>.sixthOrNull(): T?`
- `Iterable<T>.seventh(): T`
- `Iterable<T>.seventhOrNull(): T?`
- `Iterable<T>.eighth(): T`
- `Iterable<T>.eighthOrNull(): T?`
- `Iterable<T>.ninth(): T`
- `Iterable<T>.ninthOrNull(): T?`
- `Iterable<T>.tenth(): T`
- `Iterable<T>.tenthOrNull(): T?`
- `Boolean.ifFalse(block: () -> Unit): Boolean`
- `Boolean.ifTrue(block: () -> Unit): Boolean`
- `T?.ifNotNull(block: () -> Unit): T?`
- `T?.ifNull(block: () -> Unit): T?`
- `Graph` data structure
- `root: TreeNode<T>` to `TreeNode<T>`
- `TreeNode` data structure
- `String.removeIf`
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
- `String::capitalize`
- `String::decapitalize`
- `kotlin-test-testng` artifact
- `kotlin-test-junit` artifact
- `kotlin-test-juni5` artifact
- `kotlin-test` artifact
- `String.replace(vararg oldToNewValues: Pair<String, String>): String`
- `String.remove(vararg values: String): String`
- `CharSequence.notContain: Boolean` functions
- `List<String>.removeDuplicateEmptyLines`
- `String.removeDuplicateEmptyLines`
- `String.endWithNewLine`
- `emptyString()`
- `isNotNullNorBlank()` and `isNotNullNorEmpty()`
- `second()`, `third()`, `forth()`, `fifth()` and `penultimate()`
- `OrNull` variants for `second()`, `third()`, `forth()`, `fifth()` and `penultimate()`
- `AnsiColor` and `String.ansiColor()`
- `String.remove`

### Changed

- `@Ignore*` annotation use CamelCase in the target name
- `@IgnoreDARWIN` to `@IgnoreAPPLE`
- `emptyString()` to `String.Empty`
- Java support to Java 8

### Fixed

- `String.ansiColor` function just color the first line in multiline strings
- `com.javiersc.gradle-plugins:all-plugins -> 0.1.0-rc.17`

### Removed

- `kotlin-test` artifact

### Updated

- `com.javiersc.hubdle:com.javiersc.hubdle.gradle.plugin -> 0.8.0`
- `gradle -> 8.11.1`
- `easimon/wipe-cache -> v2`
- `com.android.tools.build:gradle -> 7.3.0`
- `org.jetbrains.kotlin:kotlin-gradle-plugin -> 1.7.10`
- `org.jetbrains.kotlinx:binary-compatibility-validator -> 0.10.1`
- `org.jetbrains.kotlinx:kotlinx-coroutines-core -> 1.6.3`
- `com.javiersc.gradle-plugins:all-plugins -> 0.1.0-rc.43`
- `io.kotest:kotest-assertions-core -> 5.3.0`

[Unreleased]: https://github.com/JavierSegoviaCordoba/kotlin-stdlib/compare/0.2.0...HEAD

[0.2.0]: https://github.com/JavierSegoviaCordoba/kotlin-stdlib/compare/0.1.0...0.2.0

[0.1.0]: https://github.com/JavierSegoviaCordoba/kotlin-stdlib/commits/0.1.0
