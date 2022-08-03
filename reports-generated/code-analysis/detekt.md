# detekt

## Metrics

* 48 number of properties

* 38 number of functions

* 1,029 number of classes

* 3 number of packages

* 1,139 number of kt files

## Complexity Report

* 6,537 lines of code (loc)

* 3,985 source lines of code (sloc)

* 2,617 logical lines of code (lloc)

* 45 comment lines of code (cloc)

* 70 cyclomatic complexity (mcc)

* 48 cognitive complexity

* 7 number of total code smells

* 1% comment source ratio

* 26 mcc per 1,000 lloc

* 2 code smells per 1,000 lloc

## Findings (7)

### complexity, TooManyFunctions (1)

Too many functions inside a/an file/class/object/interface always indicate a violation of the single responsibility principle. Maybe the file/class/object/interface wants to manage too many things at once. Extract functionality which clearly belongs together.

[Documentation](https://detekt.dev/docs/rules/complexity#toomanyfunctions)

* kotlin-stdlib/common/main/kotlin/com/javiersc/kotlin/stdlib/Strings.kt:1:1
```
File '/home/runner/work/kotlin-stdlib/kotlin-stdlib/kotlin-stdlib/common/main/kotlin/com/javiersc/kotlin/stdlib/Strings.kt' with '11' functions detected. Defined threshold inside files is set to '11'
```
```kotlin
1 package com.javiersc.kotlin.stdlib
! ^ error
2 
3 import kotlin.contracts.contract
4 

```

### style, ReturnCount (2)

Restrict the number of return statements in methods.

[Documentation](https://detekt.dev/docs/rules/style#returncount)

* kotlin-stdlib/common/main/kotlin/com/javiersc/kotlin/stdlib/Collections.kt:71:35
```
Function penultimateOrNull has 4 return statements which exceeds the limit of 2.
```
```kotlin
68     }
69 }
70 
71 public inline fun <T> Iterable<T>.penultimateOrNull(): T? {
!!                                   ^ error
72     return when (this) {
73         is List -> getOrNull(size - 2)
74         else -> {

```

* kotlin-stdlib/common/main/kotlin/com/javiersc/kotlin/stdlib/Collections.kt:114:37
```
Function getIndexOrNull has 3 return statements which exceeds the limit of 2.
```
```kotlin
111 }
112 
113 @PublishedApi
114 internal inline fun <T> Iterable<T>.getIndexOrNull(index: Int): T? {
!!!                                     ^ error
115     return when (this) {
116         is List -> getOrNull(index - 1)
117         else -> {

```

### style, ThrowsCount (2)

Restrict the number of throw statements in methods.

[Documentation](https://detekt.dev/docs/rules/style#throwscount)

* kotlin-stdlib/common/main/kotlin/com/javiersc/kotlin/stdlib/Collections.kt:46:35
```
Too many throw statements in the function penultimate. The maximum number of allowed throw statements is 2.
```
```kotlin
43  *
44  * Throws: `NoSuchElementException` - if the list size is 1.
45  */
46 public inline fun <T> Iterable<T>.penultimate(): T {
!!                                   ^ error
47     return when (this) {
48         is List ->
49             when (size) {

```

* kotlin-stdlib/common/main/kotlin/com/javiersc/kotlin/stdlib/Collections.kt:92:37
```
Too many throw statements in the function getIndex. The maximum number of allowed throw statements is 2.
```
```kotlin
89 }
90 
91 @PublishedApi
92 internal inline fun <T> Iterable<T>.getIndex(index: Int): T {
!!                                     ^ error
93     return when (this) {
94         is List ->
95             if (size >= index - 1) this[index - 1]

```

### style, UnusedPrivateMember (2)

Private member is unused and should be removed.

[Documentation](https://detekt.dev/docs/rules/style#unusedprivatemember)

* kotlin-stdlib/common/main/kotlin/com/javiersc/kotlin/stdlib/Collections.kt:103:18
```
Private property `i` is unused.
```
```kotlin
100                 throw NoSuchElementException("Collection size is lower than $index.")
101             var value: T = iterator.next()
102 
103             for (i in 0 until index - 1) {
!!!                  ^ error
104                 if (!iterator.hasNext())
105                     throw NoSuchElementException("Collection size is lower than $index.")
106                 else value = iterator.next()

```

* kotlin-stdlib/common/main/kotlin/com/javiersc/kotlin/stdlib/Collections.kt:122:18
```
Private property `i` is unused.
```
```kotlin
119             if (!iterator.hasNext()) return null
120             var value: T = iterator.next()
121 
122             for (i in 0 until index - 1) {
!!!                  ^ error
123                 if (!iterator.hasNext()) return null else value = iterator.next()
124             }
125             value

```

generated with [detekt version 1.21.0](https://detekt.dev/) on 2022-08-03 17:30:15 UTC
