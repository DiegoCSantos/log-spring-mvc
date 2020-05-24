package br.com.logsmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.logsmvc.model.Log;

@Repository
@Transactional
public class LogDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Log inserir(Log log) {
		entityManager.persist(log);
		return log;
	}
	
	public List<Log> listar(){
		TypedQuery<Log> query = entityManager.createQuery("select l from Log l ", Log.class);
		return query.getResultList();
	}
	
	public Log obter(Long id){
		return entityManager.find(Log.class, id);
	}
	
	public Log alterar(Log log){
		entityManager.merge(log);
		return log;
	}
	
	public Log remover(Log log){
		entityManager.remove(log);
		return log;
	}

}
