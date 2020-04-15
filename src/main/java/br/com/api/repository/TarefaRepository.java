package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.model.TarefaModel;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaModel, Long> {

}
