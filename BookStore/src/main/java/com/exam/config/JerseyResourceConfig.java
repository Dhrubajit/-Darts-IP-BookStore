package com.exam.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.exam.resource.BookResource;


@Component
public class JerseyResourceConfig extends ResourceConfig {
	
	public JerseyResourceConfig() {
        register(BookResource.class);
    }
}
