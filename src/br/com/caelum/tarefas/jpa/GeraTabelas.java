package br.com.caelum.tarefas.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeraTabelas {
	public static void main(String[] args) {
		// a variavel tarefas é o nome dado ao persistence-unit no arquivo persistence.xml
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
	}
}
