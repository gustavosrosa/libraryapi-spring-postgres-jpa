package io.github.gustavosrosa.libraryapi.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "autor", schema = "public")
@Getter
@Setter
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
	
}
