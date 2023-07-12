package com.capgemini.mbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.capgemini.model.Tarefa;

@ManagedBean
@SessionScoped
public class GerenciadorTarefasBean {
	private Tarefa tarefa;
	private List<Tarefa> tarefas;
	private static int contador;
	
	
	public GerenciadorTarefasBean() {
		tarefa = new Tarefa(null, "", "", "Média", new Date());
		
		tarefas = new ArrayList<Tarefa>();
		//adicionando tarefas de teste
		tarefas.add(new Tarefa(1, "Titulo 1", "Descricao 1", "Baixa", new Date()));
		tarefas.add(new Tarefa(2, "Titulo 2", "Descricao 2", "Alta", new Date()));
		
		contador = tarefas.size();
		
	}

	public void novaTarefa() {
		tarefa = new Tarefa(null, "", "", "Média", new Date());
	}

	public void salvarTarefa () {
		if(tarefa.getId() == null) {
			tarefa.setId(++contador);
			tarefas.add(tarefa);
		}
		
		novaTarefa();
		addMensagem("Tarefa Salva");
	}
	
	public void apagarTarefa(Tarefa tarefa) {
		tarefas.remove(tarefa);
		addMensagem("Tarefa Apagada");
	}
	
	public void editarTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	private void addMensagem(String msg) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
		
	}

	public Tarefa getTarefa() {
		return tarefa;
	}


	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}


	public List<Tarefa> getTarefas() {
		return tarefas;
	}


	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
}
