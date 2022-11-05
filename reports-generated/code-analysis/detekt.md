# detekt

## Metrics

* 55 number of properties

* 43 number of functions

* 1,029 number of classes

* 3 number of packages

* 1,139 number of kt files

## Complexity Report

* 6,622 lines of code (loc)

* 4,051 source lines of code (sloc)

* 2,678 logical lines of code (lloc)

* 57 comment lines of code (cloc)

* 76 cyclomatic complexity (mcc)

* 50 cognitive complexity

* 7 number of total code smells

* 1% comment source ratio

* 28 mcc per 1,000 lloc

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

* kotlin-stdlib/common/main/kotlin/com/javiersc/kotlin/stdlib/Collections.kt:89:35
```
Function penultimateOrNull has 4 return statements which exceeds the limit of 2.
```
```kotlin
86     }
87 }
88 
89 public inline fun <T> Iterable<T>.penultimateOrNull(): T? {
!!                                   ^ error
90     return when (this) {
91         is List -> getOrNull(size - 2)
92         else -> {

```

* kotlin-stdlib/common/main/kotlin/com/javiersc/kotlin/stdlib/Collections.kt:132:37
```
Function getIndexOrNull has 3 return statements which exceeds the limit of 2.
```
```kotlin
129 }
130 
131 @PublishedApi
132 internal inline fun <T> Iterable<T>.getIndexOrNull(index: Int): T? {
!!!                                     ^ error
133     return when (this) {
134         is List -> getOrNull(index - 1)
135         else -> {

```

### style, ThrowsCount (2)

Restrict the number of throw statements in methods.

[Documentation](https://detekt.dev/docs/rules/style#throwscount)

* kotlin-stdlib/common/main/kotlin/com/javiersc/kotlin/stdlib/Collections.kt:64:35
```
Too many throw statements in the function penultimate. The maximum number of allowed throw statements is 2.
```
```kotlin
61  *
62  * Throws: `NoSuchElementException` - if the list size is 1.
63  */
64 public inline fun <T> Iterable<T>.penultimate(): T {
!!                                   ^ error
65     return when (this) {
66         is List ->
67             when (size) {

```

* kotlin-stdlib/common/main/kotlin/com/javiersc/kotlin/stdlib/Collections.kt:110:37
```
Too many throw statements in the function getIndex. The maximum number of allowed throw statements is 2.
```
```kotlin
107 }
108 
109 @PublishedApi
110 internal inline fun <T> Iterable<T>.getIndex(index: Int): T {
!!!                                     ^ error
111     return when (this) {
112         is List ->
113             if (size >= index - 1) this[index - 1]

```

### style, UnusedPrivateMember (2)

Private member is unused and should be removed.

[Documentation](https://detekt.dev/docs/rules/style#unusedprivatemember)

* kotlin-stdlib/common/main/kotlin/com/javiersc/kotlin/stdlib/Collections.kt:121:18
```
Private property `i` is unused.
```
```kotlin
118                 throw NoSuchElementException("Collection size is lower than $index.")
119             var value: T = iterator.next()
120 
121             for (i in 0 until index - 1) {
!!!                  ^ error
122                 if (!iterator.hasNext())
123                     throw NoSuchElementException("Collection size is lower than $index.")
124                 else value = iterator.next()

```

* kotlin-stdlib/common/main/kotlin/com/javiersc/kotlin/stdlib/Collections.kt:140:18
```
Private property `i` is unused.
```
```kotlin
137             if (!iterator.hasNext()) return null
138             var value: T = iterator.next()
139 
140             for (i in 0 until index - 1) {
!!!                  ^ error
141                 if (!iterator.hasNext()) return null else value = iterator.next()
142             }
143             value

```

generated with [detekt version 1.21.0](https://detekt.dev/) on 2022-11-05 13:08:23 UTC
