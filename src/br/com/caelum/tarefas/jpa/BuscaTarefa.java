package br.com.caelum.tarefas.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.caelum.tarefas.modelo.Tarefa;

public class BuscaTarefa {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();

		// O nome da tabela selecionada é o nome da classe que é Entity e nao
		// como é chamada no banco de dados.

		Query query = manager.createQuery("SELECT t FROM Tarefa AS t WHERE t.finalizado = :paramFinalizado ");
		query.setParameter("paramFinalizado", true);

		List<Tarefa> tarefas = query.getResultList();

		for (Tarefa aux : tarefas) {
			System.out.println(aux.getDescricao());
		}

		manager.close();
	}
}
