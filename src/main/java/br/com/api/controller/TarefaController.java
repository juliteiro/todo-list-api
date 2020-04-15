package br.com.api.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.api.model.TarefaModel;
import br.com.api.service.LogService;
import br.com.api.service.TarefaService;


@RestController
@RequestMapping("/tarefa")
public class TarefaController{

		@Autowired
		private TarefaService tarefaService;
		
		@Autowired
		private LogService logService;
		
		@GetMapping()
		public ResponseEntity<List<TarefaModel>> findAll() {		
			StopWatch tempo = new StopWatch();
			tempo.start();
			List<TarefaModel> tarefas = tarefaService.findAll();
			tempo.stop();
			logService.save("GET/findaAll()", tempo.getTotalTimeMillis());
			
			return ResponseEntity.ok(tarefas);			
		}
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<TarefaModel> findById(@PathVariable("id") long idTarefa) {				
			StopWatch tempo = new StopWatch();
			tempo.start();
			TarefaModel tarefaModel = tarefaService.findById(idTarefa);
			tempo.stop();
			logService.save("GET/fingById", tempo.getTotalTimeMillis());
			
			return ResponseEntity.ok(tarefaModel);
		}
		
		@PostMapping()
		public ResponseEntity save(@RequestBody @Valid TarefaModel tarefaModel) {
			StopWatch tempo = new StopWatch();
			tempo.start();
			tarefaService.save(tarefaModel);
			URI location = ServletUriComponentsBuilder
	                .fromCurrentRequest().path("/{id}")
	                .buildAndExpand(tarefaModel.getIdTarefa()).toUri();
			tempo.stop();
			logService.save("POST/save", tempo.getTotalTimeMillis());
			
			return ResponseEntity.created(location).build();			
		}
		
		@PutMapping(value = "/{id}")
		public ResponseEntity update(@PathVariable("id") long idTarefa, @RequestBody @Valid TarefaModel tarefaModel) {
			StopWatch tempo = new StopWatch();
			tempo.start();
			tarefaService.findById(idTarefa);
			tarefaModel.setIdTarefa(idTarefa);
			tarefaService.save(tarefaModel);
			tempo.stop();
			logService.save("PUT/update", tempo.getTotalTimeMillis());
			
			return ResponseEntity.ok().build();
		}	
		
		@DeleteMapping(value ="/{id}")
		public ResponseEntity deleteById(@PathVariable("id") long idTarefa) {
			StopWatch tempo = new StopWatch();
			tempo.start();
			tarefaService.deleteById(idTarefa);
			tempo.stop();
			logService.save("DELETE/deleteById", tempo.getTotalTimeMillis());
			
			return ResponseEntity.noContent().build();
		}


		

}
