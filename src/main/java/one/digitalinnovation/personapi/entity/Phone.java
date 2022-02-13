package one.digitalinnovation.personapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.enums.PhoneType;

@Entity //Essa anotação inidica que essa classe é uma entididade 
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {
	
	// Notações JPA para o mapeamento e criar o modelo e dados
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Toda vez que inserir um dados será incremental
	private Long id;
	
	@Enumerated(EnumType.STRING)// Indica o enum
	@Column(nullable = false)//@Column. Para criar uma regra - uma constraint no banco de dados. (nullable) O JPA ao gerar o esquema de banco de dados irá definir de que o dado na nossa API ele seja cadastrado como obrigatório - NOT NULL.
	private PhoneType type;
	
	@Column(nullable = false)
	private String number;
}
