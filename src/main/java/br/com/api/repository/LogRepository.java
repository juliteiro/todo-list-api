package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.model.LogModel;

@Repository
public interface LogRepository extends JpaRepository<LogModel, Long>{

}
