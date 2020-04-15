package br.com.api.service;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.api.model.LogModel;
import br.com.api.repository.LogRepository;



@Component
public class LogService {
	
	
	@Autowired
	public LogRepository logRepository;
	
	

	public List<LogModel> findAll() {
	
		return logRepository.findAll();
	}

	public LogModel save(String servico, long tempo) {
	
		LogModel logModel = new LogModel(servico, tempo);
		
		
		return logRepository.save(logModel);
		
	}
	
	
	
}
