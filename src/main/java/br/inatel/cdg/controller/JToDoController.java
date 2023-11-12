package br.inatel.cdg.controller;

import br.inatel.cdg.entity.JToDoEntity;
import br.inatel.cdg.service.JToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  OBS: para essa aplicação em especifico, não precisariamos listar
 *  cada metodo com um endpoint diferente, pois cada um usa um
 *  tipo de requisição. Mas para melhor legibilidade, foi implemtado
 *  um endpoint para cada método
 */

@RestController
@RequestMapping("/api/todo")
public class JToDoController {

    @Autowired
    private JToDoService toDoService;

    @PostMapping("/create")
    List<JToDoEntity> create(@RequestBody @Validated JToDoEntity todo){
        return toDoService.create(todo);
    }

    @GetMapping("/list")
    List<JToDoEntity> list(JToDoEntity todo){
        return toDoService.list();
    }

    @PutMapping("/update")
    List<JToDoEntity> update(@RequestBody JToDoEntity todo){
        return toDoService.update(todo);
    }

    @DeleteMapping("/delete/{id}")
    List<JToDoEntity> delete(@PathVariable("id") Long id ){
        return toDoService.delete(id);
    }

}
