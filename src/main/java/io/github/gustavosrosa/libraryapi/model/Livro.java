package io.github.gustavosrosa.libraryapi.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "livro")
@Data // Incorpore all the datas (getter, setter, toString, equals, hashcode, required args constructor
@NoArgsConstructor
@AllArgsConstructor
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(length = 20, nullable = false)
	private String isbn;
	
	@Column(length = 150, nullable = false)
	private String titulo;
	
	@Column(name = "data_publicacao", nullable = false)
	private LocalDate dataPublicacao;
	
	@Column(length = 30, nullable = false)
	@Enumerated(EnumType.STRING)
	private GeneroLivro genero;
	
	@Column(precision = 18, scale = 2)
	private BigDecimal preco;
	
	@ManyToOne
	@JoinColumn(name = "id_autor")
	private Autor autor;

}
