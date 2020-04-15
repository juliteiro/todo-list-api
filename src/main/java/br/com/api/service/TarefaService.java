package br.com.api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import br.com.api.model.TarefaModel;
import br.com.api.repository.TarefaRepository;

@Component
public class TarefaService {

	private static final Logger log = LoggerFactory.getLogger(TarefaService.class);
	
	@Autowired
	public TarefaRepository tarefaRepository;
	
	public List<TarefaModel> findAll() {
		log.info("Buscando lista de tarefas");
		return tarefaRepository.findAll();
	}

	@Cacheable("tarefaCache")
	public TarefaModel findById(long idTarefa) {
		log.info("Buscando tarefa do id {}", idTarefa);
		return tarefaRepository.findById(idTarefa).get();
	}
	
	@CachePut("tarefaCache")
	public void save(TarefaModel tarefaModel) {
		log.info("Salvando tarefa {}", tarefaModel);
		tarefaRepository.save(tarefaModel);	
	}

	public void deleteById(long idTarefa) {
		log.info("Removendo tarefa do id {}", idTarefa);
		tarefaRepository.deleteById(idTarefa);
	}
}
