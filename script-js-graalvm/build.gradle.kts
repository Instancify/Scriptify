plugins {
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    api(project(":security"))
    api("org.graalvm.polyglot:polyglot:24.1.1")
    api("org.graalvm.polyglot:js:24.1.1")
}