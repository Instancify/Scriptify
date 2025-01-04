plugins {
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    api(project(":core"))
    api("org.mozilla:rhino:1.7.15")
}