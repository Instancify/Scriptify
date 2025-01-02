package com.instancify.scriptify.core.script.function.impl;

import com.instancify.scriptify.api.exception.ScriptFunctionArgTypeException;
import com.instancify.scriptify.api.exception.ScriptFunctionArgsCountException;
import com.instancify.scriptify.api.exception.ScriptFunctionException;
import com.instancify.scriptify.api.script.function.ScriptFunction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Represents a function to unzip specific files from an archive based on regex or full file names.
 */
public class ScriptFunctionSmartUnzipFile implements ScriptFunction {

    @Override
    public String getName() {
        return "smartUnzipFile";
    }

    @Override
    public Object invoke(Object[] args) throws ScriptFunctionException {
        if (args.length != 3) {
            throw new ScriptFunctionArgsCountException(3, args.length);
        }

        if (!(args[0] instanceof String compressedFilePath)) {
            throw new ScriptFunctionArgTypeException(String.class, args[0].getClass());
        }
        if (!(args[1] instanceof String decompressedPath)) {
            throw new ScriptFunctionArgTypeException(String.class, args[1].getClass());
        }
        if (!(args[2] instanceof List<?> patterns)) {
            throw new ScriptFunctionArgTypeException(List.class, args[2].getClass());
        }

        try {
            File fileCompressed = new File(compressedFilePath);
            File fileDecompressed = new File(decompressedPath);

            // Convert patterns to regex patterns
            List<Pattern> regexPatterns = patterns.stream()
                    .filter(String.class::isInstance)
                    .map(String.class::cast)
                    .map(Pattern::compile)
                    .toList();

            byte[] buffer = new byte[1024];
            try (ZipInputStream zis = new ZipInputStream(new FileInputStream(fileCompressed))) {
                ZipEntry zipEntry = zis.getNextEntry();
                while (zipEntry != null) {
                    String fileName = zipEntry.getName();

                    // Check if the file matches any pattern
                    boolean matches = regexPatterns.stream().anyMatch(pattern -> pattern.matcher(fileName).matches());
                    if (matches) {
                        File newFile = newFile(fileDecompressed, zipEntry);
                        if (zipEntry.isDirectory()) {
                            if (!newFile.isDirectory() && !newFile.mkdirs()) {
                                throw new IOException("Failed to create directory " + newFile);
                            }
                        } else {
                            File parent = newFile.getParentFile();
                            if (!parent.isDirectory() && !parent.mkdirs()) {
                                throw new IOException("Failed to create directory " + parent);
                            }

                            try (FileOutputStream fos = new FileOutputStream(newFile)) {
                                int len;
                                while ((len = zis.read(buffer)) > 0) {
                                    fos.write(buffer, 0, len);
                                }
                            }
                        }
                    }

                    zipEntry = zis.getNextEntry();
                }
                zis.closeEntry();
            }
        } catch (IOException e) {
            throw new ScriptFunctionException(e);
        }

        return null;
    }

    private File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());

        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return destFile;
    }
}
