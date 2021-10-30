package com.uway.server.config;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example.demo")
public class WebConfiguration extends WebMvcConfigurationSupport {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setPrettyPrint(true);
        converter.setDefaultCharset(StandardCharsets.UTF_8);
		/*
		 * converter.setObjectMapper(Jackson2ObjectMapperBuilder .xml()
		 * .failOnEmptyBeans(false) .failOnUnknownProperties(false) .indentOutput(true)
		 * .build());
		 */
        //converter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_XML, Med MediaType.APPLICATION_XML));
        converters.add(converter);
	}
	
	@Override
	protected void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.defaultContentType(MediaType.APPLICATION_JSON)
				  .ignoreAcceptHeader(true);
	}
}