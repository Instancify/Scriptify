package com.instancify.scriptify.js.rhino.script;

import com.instancify.scriptify.api.script.ScriptObject;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.WrapFactory;

public class JsWrapFactory extends WrapFactory {

    public JsWrapFactory() {
        this.setJavaPrimitiveWrap(false);
    }

    @Override
    public Object wrap(Context context, Scriptable scope, Object object, Class<?> staticType) {
        // Convert the ScriptObject class to the value it contains
        if (object instanceof ScriptObject scriptObject) {
            return Context.javaToJS(scriptObject.getValue(), scope);
        }
        return super.wrap(context, scope, object, staticType);
    }
}
