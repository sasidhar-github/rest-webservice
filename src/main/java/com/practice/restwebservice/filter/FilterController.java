package com.practice.restwebservice.filter;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {

	@GetMapping(path="/getStatic")
	StaticFilteringBean staticfileringOnFields() {
		return new StaticFilteringBean("myName", "departmentName");
	}
	
	@GetMapping(path="/getStaticClassLvl")
	StaticFilteringClassLvlBean staticfileringClassLvlOnFields() {
		return new StaticFilteringClassLvlBean("myName", "departmentName","mngrName");
	}
	
	@GetMapping(path="/getDynamicClassLvl")
	MappingJacksonValue dynamicFileringClassLvlOnFields() {
		DynamicFilteringClassLvlBean dfC = new DynamicFilteringClassLvlBean("myName", "departmentName","mngrName");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("myName");
		FilterProvider filters = new SimpleFilterProvider().addFilter("getDynamicClassLvlFilter", filter );
		MappingJacksonValue mjv = new MappingJacksonValue(dfC);
		mjv.setFilters(filters);
		return mjv;
	}
}
