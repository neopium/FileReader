package org.test.reader.service.impl;

import org.osgi.service.component.annotations.Component;
import org.test.reader.service.FileReaderService;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.List;

@Component
public class TxtFileReader implements FileReaderService {

    @Override
    public List<String> readFile(Path filePath) throws IOException {
        return Files.readAllLines(filePath);
    }

    @Override
    public boolean isFormatSupported(Path filePath) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        return matcher.matches(filePath);
    }
}
