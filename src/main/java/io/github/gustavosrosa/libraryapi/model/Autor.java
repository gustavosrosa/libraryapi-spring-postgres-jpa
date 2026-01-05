package io.github.gustavosrosa.libraryapi.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "autor", schema = "public")
@Data // Incorpore all the datas (getter, setter, toString, equals, hashcode, required args constructor
@NoArgsConstructor
@AllArgsConstructor
public class Autor {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(length = 100, nullable = false)
	private String nome;
	
	@Column(name = "data_nascimento", nullable = false)
	private LocalDate dataNascimento;
	
	@Column(length = 50, nullable = false)
	private String nacionalidade;
	
	@OneToMany(mappedBy = "autor")
	private List<Livro> livros;
	
}
