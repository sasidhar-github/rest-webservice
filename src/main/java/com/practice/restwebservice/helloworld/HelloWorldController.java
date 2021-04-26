package com.practice.restwebservice.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSources;
    
	@GetMapping(path = "/hello")
	public String helloWorld() {
		return "hello world";
	}
    
    @GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("hello world",25);
	}
    
    @GetMapping(path = "/hello-world-bean/{name}")
 	public HelloWorldBean helloWorldBeanVar(@PathVariable String name) {
 		return new HelloWorldBean(String.format("Hello : %s",name));
 	}
    
    @GetMapping(path = "/hello-world-internalization")
 	public String helloWorldInternalization(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
 		return messageSources.getMessage("good.morning.message",null, locale);
 	}
}
