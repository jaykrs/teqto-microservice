package com.teqto.consumer.contoller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerRestController {

	@PostMapping
	@RequestMapping(value = "/consumer/{name}", method = RequestMethod.GET)
	public String sayhi(@PathVariable String name) {
		return "Hallo <h2> Consumer " + name + "</h1>";
	}
}
