package br.inatel.cdg.service;

import br.inatel.cdg.entity.JToDoEntity;
import br.inatel.cdg.repository.IToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JToDoService {

    @Autowired
    private IToDoRepository toDoRepo;

    public List<JToDoEntity> create(JToDoEntity todo){
        toDoRepo.save(todo);

        return list();
    }

    public List<JToDoEntity> list(){
        return toDoRepo.findAll();
    }

    public List<JToDoEntity> update(JToDoEntity todo){
        toDoRepo.save(todo);

        return list();
    }

    public List<JToDoEntity> delete(Long id){
        toDoRepo.deleteById(id);

        return list();
    }
}
