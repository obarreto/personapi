package one.digitalinnovation.personapi.mapper;

import one.digitalinnovation.personapi.DTO.resquest.PersonDTO;
import one.digitalinnovation.personapi.entity.Person;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;




@Mapper
public class PersonMapper {

		PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
		
		@Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
		Person toModel(PersonDTO personDTO) {
			return null;
		}
		
		PersonDTO toDTO(Person person) {
			return null;
		}
}
