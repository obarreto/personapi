package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.DTO.response.MessageResponseDTO;
import one.digitalinnovation.personapi.DTO.resquest.PersonDTO;
import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("api/v1/people")
public class PersonController {


	private PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	/*
	 * @PostMapping para fazer uma criação de uma pessoa
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
		return personService.createPerson(personDTO);
	}
	@GetMapping
	public List<PersonDTO> listAll(){
		return personService.listAll();
	}

	@GetMapping("/{id}")
	public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
		return personService.findById(id);
	}
}
