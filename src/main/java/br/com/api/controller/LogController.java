package br.com.api.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.model.LogModel;
import br.com.api.service.LogService;

@RestController
@RequestMapping("/log")
public class LogController {

	@Autowired
	private LogService logService;
	
	@GetMapping()
	public ResponseEntity<List<LogModel>> findAll() {
		
		List<LogModel> logs = logService.findAll();
		return ResponseEntity.ok(logs);
	}
	

		
}
