package com.instancify.scriptify.common.script.function;

import com.instancify.scriptify.common.script.function.impl.crypto.ScriptFunctionBase64Decode;
import com.instancify.scriptify.common.script.function.impl.crypto.ScriptFunctionBase64Encode;
import com.instancify.scriptify.common.script.function.impl.crypto.ScriptFunctionMD5;
import com.instancify.scriptify.common.script.function.impl.crypto.ScriptFunctionSHA256;
import com.instancify.scriptify.common.script.function.impl.file.*;
import com.instancify.scriptify.common.script.function.impl.os.ScriptFunctionEnv;
import com.instancify.scriptify.common.script.function.impl.os.ScriptFunctionExecCommand;
import com.instancify.scriptify.common.script.function.impl.random.*;
import com.instancify.scriptify.common.script.function.impl.util.*;
import com.instancify.scriptify.common.script.function.impl.zip.ScriptFunctionSmartUnzipFile;
import com.instancify.scriptify.common.script.function.impl.zip.ScriptFunctionSmartZipFile;
import com.instancify.scriptify.common.script.function.impl.zip.ScriptFunctionUnzipFile;
import com.instancify.scriptify.common.script.function.impl.zip.ScriptFunctionZipFile;
import com.instancify.scriptify.core.script.function.StandardFunctionManager;

public class CommonFunctionManager extends StandardFunctionManager {

    public CommonFunctionManager() {
        this.register(new ScriptFunctionPrint());
        this.register(new ScriptFunctionExistsFile());
        this.register(new ScriptFunctionDeleteFile());
        this.register(new ScriptFunctionMoveFile());
        this.register(new ScriptFunctionListFiles());
        this.register(new ScriptFunctionReadFile());
        this.register(new ScriptFunctionWriteFile());
        this.register(new ScriptFunctionZipFile());
        this.register(new ScriptFunctionUnzipFile());
        this.register(new ScriptFunctionSmartZipFile());
        this.register(new ScriptFunctionSmartUnzipFile());
        this.register(new ScriptFunctionNormalizePath());
        this.register(new ScriptFunctionBase64Encode());
        this.register(new ScriptFunctionBase64Decode());
        this.register(new ScriptFunctionDownloadFromUrl());
        this.register(new ScriptFunctionJoinPath());
        this.register(new ScriptFunctionRandomUUID());
        this.register(new ScriptFunctionRandomInteger());
        this.register(new ScriptFunctionRandomLong());
        this.register(new ScriptFunctionRandomFloat());
        this.register(new ScriptFunctionRandomDouble());
        this.register(new ScriptFunctionMD5());
        this.register(new ScriptFunctionSHA256());
        this.register(new ScriptFunctionExecCommand());
        this.register(new ScriptFunctionEnv());
        this.register(new ScriptFunctionShuffleArray());
        this.register(new ScriptFunctionListOf());
        this.register(new ScriptFunctionSetOf());
        this.register(new ScriptFunctionArrayOf());
        this.register(new ScriptFunctionRegexPattern());
        this.register(new ScriptFunctionRegexMatch());
    }
}
