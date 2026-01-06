package io.github.gustavosrosa.libraryapi.repository;

import static org.assertj.core.api.Assertions.*;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.github.gustavosrosa.libraryapi.model.Autor;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {
	
	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private EntityManager entityManager;
	
	@Test
	void saveNewAutor() {
		Autor autor = new Autor();

		autor.setNome("Autor 1");
		autor.setDataNascimento(LocalDate.of(2001, 12, 12));
		autor.setNacionalidade("Americana");

		Autor newAutor = autorRepository.save(autor);

		assertThat(newAutor).isNotNull();
		assertThat(newAutor.getId()).isNotNull();

		Autor foundAutor = entityManager.find(Autor.class, newAutor.getId());
		assertThat(foundAutor.getNacionalidade()).isEqualTo(newAutor.getNacionalidade());
	}

	@Test
	void updateAutor() {
		UUID uuidDb = UUID.fromString("46909b65-d47a-4dbd-850a-5867c2b38b84");

		final String newName = "Autor 2";
		final String newNationality = "Malgaxe";

		Autor getAutorById = entityManager.find(Autor.class, uuidDb);

		getAutorById.setNome(newName);
		getAutorById.setNacionalidade(newNationality);

		Autor updatedAutor = autorRepository.save(getAutorById);

		Autor foundAutor = entityManager.find(Autor.class, updatedAutor.getId());

		assertThat(foundAutor.getNome()).isEqualTo(newName);
		assertThat(foundAutor.getNacionalidade()).isEqualTo(newNationality);

	}
}
