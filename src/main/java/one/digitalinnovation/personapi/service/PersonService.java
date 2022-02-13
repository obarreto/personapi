package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.DTO.response.MessageResponseDTO;
import one.digitalinnovation.personapi.DTO.resquest.PersonDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.personapi.mapper.PersonMapper;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service 
public class PersonService {

	private PersonRepository personRepository;

	private final PersonMapper personMapper = PersonMapper.INSTANCE;

	/*
	 * @Autowired : Injeta uma implementação do tipo Repository,
	 *  somente o contrato de PersonRepository.
	 * */
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public MessageResponseDTO createPerson(PersonDTO personDTO) {

		Person personToSave = personMapper.toModel(personDTO);
		/*Person personToSave = Person.builder()
				.firstName(personDTO.getFirstName())
				.lastName(personDTO.getLastName())
				.birthDate(personDTO.getBirthDate())
				.phones(personDTO.getPhones())
				.build();*/

		Person savedPerson = personRepository.save(personToSave);
		return MessageResponseDTO
				.builder()
				.message("Created person with ID " + savedPerson.getId())
				.build();
	}

	public List<PersonDTO> listAll(){
		List<Person> allPeople = personRepository.findAll();
		return allPeople.stream()
				.map(personMapper::toDTO)
				.collect(Collectors.toList());
	}

	public PersonDTO findById(Long id) throws PersonNotFoundException {
		Person person = personRepository.findById(id)
				.orElseThrow(() ->  new PersonNotFoundException(id));
		/*Optional<Person> optionalPerson = personRepository.findById(id);
		if(optionalPerson.isEmpty()){
			throw new PersonNotFoundException(id);
		}
		return personMapper.toDTO((optionalPerson.get()));
		 */
		return personMapper.toDTO(person);
	}
}
