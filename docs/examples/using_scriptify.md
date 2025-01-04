# Using Scriptify

___

### Using JS with GraalVM
```kotlin
implementation "com.instancify.scriptify:script-js-graalvm:1.3.0-SNAPSHOT"
```
### Using JS with Rhino
```kotlin
implementation "com.instancify.scriptify:script-js-rhino:1.3.0-SNAPSHOT"
```
___

Running the script:
```java
import com.instancify.scriptify.script.JsScript;
import com.instancify.scriptify.core.script.constant.StandardConstantManager;
import com.instancify.scriptify.core.script.function.StandardFunctionManager;
import com.instancify.scriptify.api.exception.ScriptException;

JsScript script = new JsScript();
script.setFunctionManager(new StandardFunctionManager());
script.setConstantManager(new StandardConstantManager());
try {
    script.eval("print('Hello world from JS!')");
} catch(ScriptException e) {
    throw new RuntimeException(e);
}
```

Running a script from a file:
```java
script.eval(Files.readString(Path.of("./script.js")));
```