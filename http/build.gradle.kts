plugins {
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    api(project(":api"))
    api("com.squareup.okhttp3:okhttp:4.12.0")
}