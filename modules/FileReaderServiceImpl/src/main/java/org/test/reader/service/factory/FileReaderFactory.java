package org.test.reader.service.factory;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.test.reader.service.FileReaderService;
import org.test.reader.service.ReaderFactoryService;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@Component
public class FileReaderFactory implements ReaderFactoryService {

    @Reference(cardinality = ReferenceCardinality.AT_LEAST_ONE)
    private List<FileReaderService> availableServices;

    @Modified
    private void modified() {
        for (FileReaderService service : availableServices) {
            System.out.println(service);
        }
    }

    @Override
    public List<String> readFile(Path filePath) throws IOException {

        for (FileReaderService reader : availableServices) {
            if (reader.isFormatSupported(filePath)) {
                return reader.readFile(filePath);
            }
        }

        return null;
    }

    @Override
    public boolean isFormatSupported(Path filePath) throws IOException {
        for (FileReaderService reader : availableServices) {
            if (reader.isFormatSupported(filePath)) {
                return true;
            }
        }
        return false;
    }
}
