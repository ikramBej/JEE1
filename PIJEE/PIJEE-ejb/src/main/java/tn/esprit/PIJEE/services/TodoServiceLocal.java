package tn.esprit.PIJEE.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.PIJEE.persistence.Todo;

@Local
public interface TodoServiceLocal {
	
	void create(Todo todo);
	List<Todo> findAll();

}
