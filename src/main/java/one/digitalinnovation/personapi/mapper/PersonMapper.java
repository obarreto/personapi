package one.digitalinnovation.personapi.mapper;

import one.digitalinnovation.personapi.DTO.resquest.PersonDTO;
import one.digitalinnovation.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;



/*
 *Map Struct resposavel por realizar a conversão do date de LocalDate para String 
 */

@Mapper
public interface PersonMapper {
	
		/*
		 * A interface aceita um unico tipo de dado que é constante INSTANCE.
		 * Que retorna Mappers.getMapper para o proprio Map Struct retornar uma instancia de PersonMapper
		 */
		PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
		
		@Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
		//To model para converter para um objeto de banco de dados
		Person toModel(PersonDTO personDTO);
		
		PersonDTO toDTO(Person person);
		
}
