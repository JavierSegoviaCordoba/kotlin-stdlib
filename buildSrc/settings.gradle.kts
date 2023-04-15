pluginManagement {
    val hubdleVersion: String =
        rootDir.parentFile
            .resolve("gradle/libs.versions.toml")
            .readLines()
            .first { it.contains("hubdle") }
            .split("\"")[1]

    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        mavenLocal()
    }

    plugins { id("com.javiersc.hubdle") version hubdleVersion }
}

plugins { id("com.javiersc.hubdle") }
