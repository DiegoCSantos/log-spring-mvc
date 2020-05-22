package br.com.logsmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.logsmvc.model.Pacote;

@Repository
@Transactional
public class PacoteDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Pacote inserir(Pacote pacote) {
		entityManager.persist(pacote);
		return pacote;
	}

	public List<Pacote> listar() {
		TypedQuery<Pacote> query = entityManager.createQuery("select p from Pacote p", Pacote.class);
		
		return query.getResultList();
	}

	public Pacote obter(String codigo) {
		return entityManager.find(Pacote.class, codigo);
	}

}
