package com.example.demospringint.integrations;

import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

// this annotation is used to generate implementation at runtime
// the defaultRequestChannel indicates that any result from any method in the interface will be sent to the defaultRequestChannel
//@MessagingGateway(defaultRequestChannel = "textInChannel")
//@Component
public interface FileWriterGateway {

    void writeToFile(@Header(FileHeaders.FILENAME) String filename, String data);
}
