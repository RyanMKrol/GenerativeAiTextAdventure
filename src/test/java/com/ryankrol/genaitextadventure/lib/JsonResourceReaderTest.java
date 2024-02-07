package com.ryankrol.genaitextadventure.lib;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JsonResourceReaderTest {

    @Mock
    private ResourceLoader resourceLoader;

    static class TestClass {
        public String name;
        public int value;
    }

    @Test
    public void testReadJsonFile() throws IOException {
        JsonResourceReader jsonResourceReader = new JsonResourceReader(resourceLoader);

        String jsonContent = "{\"name\":\"Test\",\"value\":123}";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(jsonContent.getBytes());

        // Mock the Resource to return the ByteArrayInputStream
        Resource mockResource = Mockito.mock(Resource.class);
        when(mockResource.getInputStream()).thenReturn(inputStream);

        when(resourceLoader.getResource("classpath:test.json")).thenReturn(mockResource);

        TestClass result = jsonResourceReader.readJsonFile("test.json", TestClass.class);

        assertEquals("Test", result.name);
        assertEquals(123, result.value);
    }
}
