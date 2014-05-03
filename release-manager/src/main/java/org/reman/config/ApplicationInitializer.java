package org.reman.config;

import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ApplicationInitializer extends SpringBootServletInitializer {

	@Bean public ServletRegistrationBean jerseyServlet() {
		return new ServletRegistrationBean(new ServletContainer(new JerseyConfig()), "/v1/**");
	}

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(ApplicationInitializer.class);
	}
	
	
	
}
