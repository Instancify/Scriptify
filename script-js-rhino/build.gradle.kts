plugins {
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    api(project(":http"))
    api(project(":core"))
    api("org.mozilla:rhino:1.8.0")
}