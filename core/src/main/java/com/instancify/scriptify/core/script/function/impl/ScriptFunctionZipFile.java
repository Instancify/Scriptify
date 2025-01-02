package com.instancify.scriptify.core.script.function.impl;

import com.instancify.scriptify.api.exception.ScriptFunctionArgTypeException;
import com.instancify.scriptify.api.exception.ScriptFunctionArgsCountException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.function.ScriptFunction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Represents a function to archive file to zip
 */
public class ScriptFunctionZipFile implements ScriptFunction {

    @Override
    public String getName() {
        return "zipFile";
    }

    @Override
    public Object invoke(Object[] args) throws ScriptFunctionException {
        if (!(args.length == 2)) {
            throw new ScriptFunctionArgsCountException(2, args.length);
        }
        if (!(args[0] instanceof String)) {
            throw new ScriptFunctionArgTypeException(String.class, args[0].getClass());
        }
        if(!(args[1] instanceof String)) {
            throw new ScriptFunctionArgTypeException(String.class, args[1].getClass());
        }

        String filePath = (String) args[0];
        String compressedFilePath = (String) args[1];

        try {
            File fileToZip = new File(filePath);
            File compressedFile = new File(compressedFilePath);

            FileOutputStream fos = new FileOutputStream(compressedFile);
            ZipOutputStream zipOut = new ZipOutputStream(fos);

            zipFile(fileToZip, fileToZip.getName(), zipOut);
            zipOut.close();
            fos.close();
        } catch (IOException e) {
            throw new ScriptFunctionException(e);
        }

        return null;
    }

    private static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
        if (fileToZip.isHidden()) {
            return;
        }
        if (fileToZip.isDirectory()) {
            if (fileName.endsWith("/")) {
                zipOut.putNextEntry(new ZipEntry(fileName));
                zipOut.closeEntry();
            } else {
                zipOut.putNextEntry(new ZipEntry(fileName + "/"));
                zipOut.closeEntry();
            }
            File[] children = fileToZip.listFiles();
            for (File childFile : children) {
                zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
            }
            return;
        }
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileName);
        zipOut.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        fis.close();
    }
}
