package br.com.logsmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.logsmvc.dao.PacoteDAO;
import br.com.logsmvc.model.Pacote;

@Service
public class PacoteService {

	@Autowired
	private PacoteDAO pacoteDAO;
	
	public Pacote inserir(Pacote pacote) {
		return pacoteDAO.inserir(pacote);
	}

	public Pacote obter(String codigo) {
		return pacoteDAO.obter(codigo);
	}

	public List<Pacote> listar() {
		return pacoteDAO.listar();
	}
	
	public Pacote alterar(Pacote pacote) {
		return pacoteDAO.alterar(pacote);
	}

	@Transactional
	public void remover(String codigo) {
		pacoteDAO.remover(pacoteDAO.obter(codigo));
	}

}
