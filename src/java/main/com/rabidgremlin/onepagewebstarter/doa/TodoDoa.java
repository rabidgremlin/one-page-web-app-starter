package com.rabidgremlin.onepagewebstarter.doa;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.rabidgremlin.onepagewebstarter.entity.Todo;

public class TodoDoa {
	private EntityManager em;

	@Inject
	public TodoDoa(EntityManager em) {
		System.out.println("Created DOA. em:" + em);
		this.em = em;
	}

	public List<Todo> getAll() {
		return em.createQuery("SELECT t FROM Todo t", Todo.class)
				.getResultList();
	}

	public Todo getTodo(String id) {

		return em.find(Todo.class, id);
	}

	public boolean deleteTodo(String id) {
		em.remove(getTodo(id));

		return true;
	}

	public void saveTodo(Todo todo) {		

		if (todo.getId() == null) {
			todo.setId(UUID.randomUUID().toString());
		}

		em.persist(todo);

	}

}
