# Custom functions and consultants

You can register a custom function or constant and then use it in your script

___

Registration of custom functions:
```java
script.getFunctionManager().register(new ScriptFunction() {
    @Override
    public String getName() {
        return "yourFunction";
    }

    @Override
    public Object invoke(Script script, ScriptFunctionArgument[] args) {
        System.out.println("Invoked custom function with arguments: " + Arrays.toString(args));
        return null;
    }
});
```

Registration of custom constants:
```java
script.getConstantManager().register(ScriptConstant.of("yourConstant", "Hello world!"));
```
or:
```java
script.getConstantManager().register(new ScriptConstant() {
    @Override
    public String getName() {
        return "yourConstant";
    }

    @Override
    public Object getValue() {
        return "Hello world!";
    }
});
```

___

Using custom functions or constants:
```java
yourFunction(yourConstant);
```
Result:
```
Invoked custom function with arguments: [Hello world!]
```