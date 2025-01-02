# Instancify Scriptify
Instancify Scriptify is a library to evaluate scripts written in JavaScript with ability to add global functions and variables.

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
    <version>1.0.1-SNAPSHOT</version>
</dependency>
```

For adding a library with JS:
```xml
<dependency>
    <groupId>com.instancify.scriptify</groupId>
    <artifactId>script-js</artifactId>
    <version>1.0.1-SNAPSHOT</version>
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
implementation "com.instancify.scriptify:core:1.0.1-SNAPSHOT"
```

For adding a library with JS:
```groovy
implementation "com.instancify.scriptify:script-js:1.0.1-SNAPSHOT"
```