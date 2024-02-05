package com.ryankrol.genaitextadventure;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class ApplicationTests {

	@Test
	public void contextLoads() {
		// ensures we don't tear down the application context before the test can verify it's up and running.
		try (MockedStatic<SpringApplication> mocked = Mockito.mockStatic(SpringApplication.class)) {
			mocked.when(() -> SpringApplication.exit(Mockito.any(ApplicationContext.class))).thenReturn(0);
		}
	}
}
