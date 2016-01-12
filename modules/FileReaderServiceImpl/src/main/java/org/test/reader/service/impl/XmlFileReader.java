package org.test.reader.service.impl;

import org.osgi.service.component.annotations.Component;
import org.test.reader.service.FileReaderService;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;

@Component
public class XmlFileReader implements FileReaderService {

    @Override
    public String readFile(Path filePath) throws IOException {
        // Do something smart with the file
        return "";
    }

    @Override
    public boolean isFormatSupported(Path filePath) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.xml");
        return matcher.matches(filePath);
    }
}
