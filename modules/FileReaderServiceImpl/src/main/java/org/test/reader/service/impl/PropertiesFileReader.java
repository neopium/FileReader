package org.test.reader.service.impl;

import org.osgi.service.component.annotations.Component;
import org.test.reader.service.FileReaderService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Component
public class PropertiesFileReader implements FileReaderService {

    @Override
    public List<String> readFile(Path filePath) throws IOException {
        List<String> content = new ArrayList<>();
        Properties props = new Properties();
        try (InputStream txtInStream = new FileInputStream(filePath.toString())) {
            props.load(txtInStream);
            for (Object key: props.keySet()) {
                content.add(key + "=" + props.getProperty(key.toString()));
            }
        }
        return content;
    }

    @Override
    public boolean isFormatSupported(Path filePath) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.properties");
        return matcher.matches(filePath);
    }
}
