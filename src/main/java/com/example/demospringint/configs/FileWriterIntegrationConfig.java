package com.example.demospringint.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;

import java.io.File;

@Configuration
public class FileWriterIntegrationConfig {
    @Bean
    public IntegrationFlow integrationFlow() {
        return IntegrationFlows
                .from(fileReader(), sourcePollingChannelAdapterSpec -> sourcePollingChannelAdapterSpec.poller(Pollers.fixedDelay(500)))
//                .transform((String s) -> s.toUpperCase())
//                .transform(new Transformer(), "transformer")
                .handle(fileWriter())
                .get();
    }

    public FileWritingMessageHandler fileWriter(){
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File("/tmp/sia5/write"));
        handler.setExpectReply(false);
        return handler;
    }

    @Bean
    public FileReadingMessageSource fileReader() {
        FileReadingMessageSource source = new FileReadingMessageSource();
        source.setDirectory(new File("/tmp/sia5/read"));
        return source;
    }
}
