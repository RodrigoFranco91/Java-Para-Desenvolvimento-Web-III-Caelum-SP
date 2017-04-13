package br.com.caelum.tarefas.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.tarefas.modelo.Tarefa;

@Repository
public class JpaTarefaDao implements TarefaDao {

	@PersistenceContext
	EntityManager manager;

	@Override
	public Tarefa buscaPorId(Long id) {
		return manager.find(Tarefa.class, id);
	}

	@Override
	public List<Tarefa> lista() {
		return manager.createQuery("SELECT t FROM Tarefa t").getResultList();
	}

	@Override
	public void adiciona(Tarefa t) {
		manager.persist(t);

	}

	@Override
	public void altera(Tarefa t) {
		manager.merge(t);

	}

	@Override
	public void remove(Tarefa t) {
		Tarefa tarefaARemover = buscaPorId(t.getId());
		manager.remove(tarefaARemover);

	}

	@Override
	public void finaliza(Long id) {
		Tarefa tarefa = buscaPorId(id);
		tarefa.setFinalizado(true);
		tarefa.setDataFinalizacao(Calendar.getInstance());

	}

}
