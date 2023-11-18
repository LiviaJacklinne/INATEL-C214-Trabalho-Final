package br.inatel.cdg.service;

import br.inatel.cdg.entity.JToDoEntity;
import br.inatel.cdg.repository.IToDoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test") // configurando o arquivo de application-properties de teste
class JToDoServiceTest {

    @Autowired
    private IToDoRepository toDoRepository;

    @Test
    void create() {

        // Cria uma nova tarefa
        JToDoEntity toDo = new JToDoEntity("createtask","createtask", false);

        // Salva a tarefa no banco
        JToDoEntity saveToDo = toDoRepository.save(toDo);

        // Verifica se a tarefa foi criada
        assertTrue(saveToDo.getId() > 0); // Verifica se o ID foi gerado

    }

    @Test
    void list() {

        // Cria algumas tarefas para listar
        JToDoEntity toDo1 = new JToDoEntity("list1","list1", false); // Cria uma nova tarefa
        JToDoEntity toDo2 = new JToDoEntity("list2","list2", true);

        toDoRepository.save(toDo1);
        toDoRepository.save(toDo2);

        // Obtém a lista de tarefas do banco de dados
        List<JToDoEntity> ToDos = toDoRepository.findAll();

        // Verifica se os usuários foram encontrados corretamente
        assertEquals(2, ToDos.size()); // Verifica se há dois usuários na lista
        assertTrue(ToDos.contains(toDo1)); // Verifica se user1 está na lista
        assertTrue(ToDos.contains(toDo2)); // Verifica se user2 está na lista

    }

    @Test
    void update() {

        // Cria uma tarefa para posterior atualização
        JToDoEntity toDo = new JToDoEntity("updatetask","updatetask", false);

        // Salva a tarefa no banco
        JToDoEntity saveToDo = toDoRepository.save(toDo);

        Long toDoId = saveToDo.getId(); // Obtém o ID do usuário salvo

        // Verifica se a tarefa foi salva corretamente
        assertNotNull(toDoId); // Verifica se o ID foi gerado

        // Modifica o status da tarefa
        Boolean newRealizado = true;
        saveToDo.setRealizado(newRealizado);

        // Atualiza a tarefa no banco de dados
        toDoRepository.save(saveToDo);

        // Busca a tarefa atualizado
        JToDoEntity updatedToDo = toDoRepository.findById(toDoId).orElse(null);

        // Verifica se a tarefa foi atualizado corretamente
        assertNotNull(updatedToDo); // Verifica se a tarefa foi encontrada no banco
        assertEquals(newRealizado, updatedToDo.isRealizado()); // Verifica se 'realizado' foi atualizado

    }

    @Test
    void delete() {

        // Cria uma nova tarefa
        JToDoEntity toDo = new JToDoEntity("deletetask","deletetask", true);

        // Salva a tarefa no banco
        JToDoEntity saveToDo = toDoRepository.save(toDo);
        Long userId = saveToDo.getId(); // Obtém o ID do usuário salvo

        // Verifica se a tarefa foi salva corretamente
        assertTrue(userId > 0); // Garante que o ID foi gerado

        // Deleta a tarefa
        toDoRepository.deleteById(userId);

        // Verifica se a tarefa foi excluída corretamente
        assertFalse(toDoRepository.existsById(userId));
    }
}