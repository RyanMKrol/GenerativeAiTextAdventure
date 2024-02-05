package com.ryankrol.genaitextadventure;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@TestConfiguration
public class TestConfig {

    @Bean
    @Primary
    public InputStream mockInputStream() {
        String inputData = "exit\n";
        return new ByteArrayInputStream(inputData.getBytes());
    }

}

