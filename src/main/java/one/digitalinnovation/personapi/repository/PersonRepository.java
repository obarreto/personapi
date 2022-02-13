package one.digitalinnovation.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.personapi.entity.Person;

/*
 *  É possivel herdar outra interface pois JpaRepository interface propria do Spring DATA
 *  É necessaŕio passar através generics a entidade que se quer gerenciar
 *  Com isso não é preciso nem fechar e nem abrir conxões com banco de dados como Hibernate e JPA e implementações
 *  nativas, onde precisava ter objetos entity, managers, também se faz necessário construir operação para 
 *  realizar a criação, leitura, inclusão, deletar dos dados.  
 *  Com apenas interface JpaRepository já faz toda essa implementação.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
