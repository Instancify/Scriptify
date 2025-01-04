package com.instancify.scriptify.core.script.function.impl.zip;

import com.instancify.scriptify.api.exception.ScriptFunctionArgTypeException;
import com.instancify.scriptify.api.exception.ScriptFunctionArgsCountException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.Script;
import com.instancify.scriptify.api.script.function.ScriptFunction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Represents a function to archive specific files to archive file based on regex or full file names.
 */
public class ScriptFunctionSmartZipFile implements ScriptFunction {

    @Override
    public String getName() {
        return "smartZipFile";
    }

    @Override
    public Object invoke(Script script, Object[] args) throws ScriptFunctionException {
        if (args.length != 3) {
            throw new ScriptFunctionArgsCountException(3, args.length);
        }

        if (!(args[0] instanceof String filesPath)) {
            throw new ScriptFunctionArgTypeException(String.class, args[0].getClass());
        }
        if (!(args[1] instanceof String compressedFilePath)) {
            throw new ScriptFunctionArgTypeException(String.class, args[1].getClass());
        }
        if (!(args[2] instanceof List<?> patterns)) {
            throw new ScriptFunctionArgTypeException(List.class, args[2].getClass());
        }

        try {
            File filesToZip = new File(filesPath);
            File compressedFile = new File(compressedFilePath);
            FileOutputStream fos = new FileOutputStream(compressedFile);
            ZipOutputStream zipOut = new ZipOutputStream(fos);

            List<Pattern> regexPatterns = patterns.stream()
                    .filter(String.class::isInstance)
                    .map(String.class::cast)
                    .map(Pattern::compile)
                    .toList();

            if (filesToZip.isDirectory()) {
                for (File file : filesToZip.listFiles()) {
                    String fileName = file.getName();
                    boolean matches = regexPatterns.stream().anyMatch(pattern -> pattern.matcher(fileName).matches());

                    if (matches) {
                        zipFile(file, fileName, zipOut);
                    }
                }
            }

            zipOut.close();
            fos.close();
        } catch (IOException e) {
            throw new ScriptFunctionException(e);
        }

        return null;
    }

    private void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
        if (fileToZip.isHidden()) {
            return;
        }

        if (fileToZip.isDirectory()) {
            if (!fileName.endsWith("/")) {
                fileName += "/";
            }
            zipOut.putNextEntry(new ZipEntry(fileName));
            zipOut.closeEntry();

            File[] children = fileToZip.listFiles();
            if (children != null) {
                for (File childFile : children) {
                    zipFile(childFile, fileName + childFile.getName(), zipOut);
                }
            }
        } else {
            try (FileInputStream fis = new FileInputStream(fileToZip)) {
                ZipEntry zipEntry = new ZipEntry(fileName);
                zipOut.putNextEntry(zipEntry);

                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) >= 0) {
                    zipOut.write(buffer, 0, length);
                }
            }
        }
    }
}
