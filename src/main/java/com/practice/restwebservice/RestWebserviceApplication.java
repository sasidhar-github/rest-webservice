package com.practice.restwebservice;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class RestWebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestWebserviceApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver sesLocaleResolver = new SessionLocaleResolver();
		sesLocaleResolver.setDefaultLocale(Locale.US);
		return sesLocaleResolver;
	}
	
	@Bean
	public ResourceBundleMessageSource messageSources() {
		ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
		bundleMessageSource.setBasename("messages");
		return bundleMessageSource;
	}

}
