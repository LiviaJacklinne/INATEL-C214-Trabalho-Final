package br.inatel.cdg;

import br.inatel.cdg.entity.JToDoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

// Especifica que a aplicação vai rodar em uma pota aleatória
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class JToDoApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTodoSuccess() {
		var todo = new JToDoEntity("todo 1", "tarefa 1", false);

		webTestClient
				.post()
				.uri("/api/todo/create")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].nome").isEqualTo(todo.getNome())
				.jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
				.jsonPath("$[0].realizado").isEqualTo(todo.isRealizado());

	}

	@Test
	void testCreateTodoFailure() {
		webTestClient
				.post()
				.uri("/api/todo/create")
				.bodyValue(new JToDoEntity("","", false))
				.exchange()
				.expectStatus().isBadRequest();
	}

}
