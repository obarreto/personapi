package one.digitalinnovation.personapi.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //Essa anotação inidica que essa classe é uma entididade 
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	/*unique = true : é uma Constraint só será possível cadastrar pessoas na tabela pessoas com CPF unico. 
	 * Vantagem: A indexação fica mais facíl e as consulta utilizando os dados unicos tem mais performance.
	 * O JPA automaticamente coloca essa constraint ao declarar o unique.
	 * */
	@Column(nullable = false, unique = true)
	private String cpf;
	
	private LocalDate birthDate;// Aqui não se dá obrigatoriedade a inserção da data de nascimento
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Phone> phones;
}
