plugins {
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    api("org.jetbrains:annotations:26.0.1")
    api(project(":core"))
}