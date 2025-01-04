plugins {
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    api(project(":core"))
    api("org.mozilla:rhino:1.8.0")
}