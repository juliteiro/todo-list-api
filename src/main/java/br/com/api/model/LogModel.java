package br.com.api.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "TB_LOG")
public class LogModel {
	
	private long idLog;
	private String servico;
	private long tempo;
	
	
	public LogModel() {
		super();
	}

	public LogModel(long idLog, String servico, long tempo) {
		super();
		this.idLog = idLog;
		this.servico = servico;
		this.tempo = tempo;
	}
	
	
	public LogModel(String servico, long tempo) {
		super();
		this.servico = servico;
		this.tempo = tempo;
	}

	@Id
	@Column(name = "ID_LOG")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOG_SEQ")
	@SequenceGenerator(name = "LOG_SEQ", initialValue = 1, allocationSize = 1)
	public long getIdLog() {
		return idLog;
	}

	public void setIdLog(long idLog) {
		this.idLog = idLog;
	}
	
	
	@Column(name = "SERVICO")
	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	
	@Column(name = "TEMPO")
	public long getTempo() {
		return tempo;
	}

	public void setTempo(long tempo) {
		this.tempo = tempo;
	}

	@Override
	public String toString() {
		return "LogModel [idLog=" + idLog + ", servico=" + servico + ", tempo=" + tempo + "]";
	}
	
	

}
