package org.test.reader.consumer;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.test.reader.service.ReaderFactoryService;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileReaderConsumer {
    private ReaderFactoryService service;

    @Activate
    public void activate() {
        try {
            System.out.println("FileReaderConsumer.activate");
            Path filePath1 = Paths.get("test.txt");
            System.out.println("Reading: " + filePath1.toString());
            System.out.println(service.readFile(filePath1));

            Path filePath2 = Paths.get("test.properties");
            System.out.println("Reading: " + filePath2.toString());
            System.out.println(service.readFile(filePath2));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Deactivate
    public void deactivate() {
        System.out.println("FileReaderConsumer.deactivate");
    }

    @Reference
    public void setReaderFactoryService(final ReaderFactoryService serviceToSet) {
        this.service = serviceToSet;
    }

    public void unsetReaderFactoryService(final ReaderFactoryService serviceToUnset) {
        this.service = null;
    }
}
