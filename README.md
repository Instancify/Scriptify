# Instancify Scriptify
Instancify Scriptify is a library to evaluate scripts written in JavaScript with ability to add global functions and variables.

## What is it for?
This library is designed to execute JavaScript scripts and has the ability to register global functions and constants.
It also allows you to configure security for executing scripts.

## Maven
Adding repo:
```xml
<repositories>
    <repository>
        <id>instancify-repository-snapshots</id>
        <url>https://repo.instancify.app/snapshots</url>
    </repository>
</repositories>
```

For adding a library only:
```xml
<dependency>
    <groupId>com.instancify.scriptify</groupId>
    <artifactId>core</artifactId>
    <version>1.4.1-SNAPSHOT</version>
</dependency>
```

For adding a library with JS for Rhino or GraalVM:
```xml
<dependency>
    <groupId>com.instancify.scriptify</groupId>
    <artifactId>script-js-rhino</artifactId>
    <version>1.4.1-SNAPSHOT</version>
</dependency>
<dependency>
    <groupId>com.instancify.scriptify</groupId>
    <artifactId>script-js-graalvm</artifactId>
    <version>1.4.1-SNAPSHOT</version>
</dependency>
```
## Gradle
Adding repo:
```groovy
maven {
    name "instancifyRepositorySnapshots"
    url "https://repo.instancify.app/snapshots"
}
```

For adding a library only:
```groovy
implementation "com.instancify.scriptify:core:1.4.1-SNAPSHOT"
```

For adding a library with JS for Rhino or GraalVM:
```groovy
implementation "com.instancify.scriptify:script-js-rhino:1.4.1-SNAPSHOT"
implementation "com.instancify.scriptify:script-js-graalvm:1.4.1-SNAPSHOT"
```