package com.ryankrol.genaitextadventure.lib;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Service
public class JsonResourceReader {
    private final ResourceLoader resourceLoader;

    JsonResourceReader(@Autowired ResourceLoader resourceLoader){
        this.resourceLoader = resourceLoader;
    }

    private String readFileAsString(String resourcePath) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:" + resourcePath);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            return reader.lines().collect(Collectors.joining("\n"));
        }
    }

    public <T> T readJsonFile(String filePath, Class<T> clazz) throws IOException {
        final String fileContent = readFileAsString(filePath);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(fileContent, clazz);
    }
}
