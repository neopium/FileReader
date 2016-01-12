package org.test.reader.service;

import java.io.IOException;
import java.nio.file.Path;

public interface FileReaderService {
    /**
     * Reads the given file.
     * @param filePath Path of the file to read
     * @return the data object built from the file
     * @throws IOException if there is an error while reading the file
     */
    String readFile(Path filePath) throws IOException;

    /**
     * Detects if the format of the provided file is supported.
     * @param filePath the file to check
     * @return true if the format of the file is supported, false otherwise
     * @throws IOException if there is an error while reading the file
     */
    boolean isFormatSupported(Path filePath) throws IOException;
}