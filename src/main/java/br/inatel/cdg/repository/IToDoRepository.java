package br.inatel.cdg.repository;

import br.inatel.cdg.entity.JToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IToDoRepository extends JpaRepository<JToDoEntity, Long> {
}
