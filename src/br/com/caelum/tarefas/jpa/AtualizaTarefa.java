package br.com.caelum.tarefas.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.modelo.Tarefa;

public class AtualizaTarefa {

	public static void main(String[] args) {
		
		Tarefa tarefa = new Tarefa();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		tarefa.setId(2L);
		tarefa.setDataFinalizacao(Calendar.getInstance());
		tarefa.setDescricao("Testando update com Hibernate");
		tarefa.setFinalizado(true);
		
		manager.getTransaction().begin();
		manager.merge(tarefa);
		manager.getTransaction().commit();
		manager.close();
	}
}
