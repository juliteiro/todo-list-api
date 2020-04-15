package br.com.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.api.util.Status;

@Entity
@Table(name = "TB_TAREFA")
public class TarefaModel {

	private long idTarefa;
	private String nomeTarefa;
	private String descricao;
	private Status status;
	
	public TarefaModel() {
		super();
	}


	public TarefaModel(long idTarefa, String nomeTarefa, String descricao, Status status) {
		super();
		this.idTarefa = idTarefa;
		this.nomeTarefa = nomeTarefa;
		this.descricao = descricao;
		this.status = status;
	}


	@Id
	@Column(name = "ID_TAREFA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TAREFA_SEQ")
	@SequenceGenerator(name = "TAREFA_SEQ", initialValue = 1, allocationSize = 1)
	public long getIdTarefa() {
		return idTarefa;
	}
	public void setIdTarefa(long idTarefa) {
		this.idTarefa = idTarefa;
	}
	
	
	@Column(name = "NOME")
	@NotNull(message = "Nome obrigatório")
	@Size(min = 2, max = 150, message = "Nome deve conter entre 2 e 50 caracteres")
	public String getNomeTarefa() {
		return nomeTarefa;
	}
	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}

	
	@Column(name = "DESCRICAO")
	@NotNull(message = "Descrição obrigatória")
	@Size(min = 2, max = 150, message = "Descrição deve ser entre 2 e 50 caracteres")
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Column(name = "STATUS")
	@NotNull(message = "Status obrigatório")
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "TarefaModel [idTarefa=" + idTarefa + ", nomeTarefa=" + nomeTarefa + ", descricao=" + descricao
				+ ", status=" + status + "]";
	}
	



	
}
