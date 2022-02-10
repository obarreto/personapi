package one.digitalinnovation.personapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.personapi.service.PersonService;

@RestController
@RequestMapping("api/v1/people")
public class PersonController {
	
	@GetMapping
	public String getBook() {
		return "API Test";
	}
}
