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
		return createMessageResponse(savedPerson.getId(), "Created person with ID ");
	}

	public List<PersonDTO> listAll(){
		List<Person> allPeople = personRepository.findAll();
		return allPeople.stream()
				.map(personMapper::toDTO)
				.collect(Collectors.toList());
	}

	public PersonDTO findById(Long id) throws PersonNotFoundException {
		Person person = verifyIfExists(id);

		return personMapper.toDTO(person);
			/*Optional<Person> optionalPerson = personRepository.findById(id);
		if(optionalPerson.isEmpty()){
			throw new PersonNotFoundException(id);
		}
		return personMapper.toDTO((optionalPerson.get()));
		 */
	}

	public void delete(Long id) throws PersonNotFoundException {
		verifyIfExists(id);
		personRepository.deleteById(id);
	}

	public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
		verifyIfExists(id);
		Person personToUpdate = personMapper.toModel(personDTO);

		Person updatePerson = personRepository.save(personToUpdate);
		return createMessageResponse(updatePerson.getId(), "Update person with ID ");

	}

	private Person verifyIfExists(Long id) throws PersonNotFoundException {
		return personRepository.findById(id)
				.orElseThrow(() -> new PersonNotFoundException(id));
	}

	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO
				.builder()
				.message(message + id)
				.build();
	}
}
