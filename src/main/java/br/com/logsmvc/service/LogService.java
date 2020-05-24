package br.com.logsmvc.service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.logsmvc.dao.LogDAO;
import br.com.logsmvc.model.Log;

@Service
public class LogService {
	
	@Autowired LogDAO logDAO;
	
	public Log inserir(Log log) {
		return logDAO.inserir(log);
	}
	
	public List<Log> listar(){
		return logDAO.listar();
	}
	
	public Log obter(Long id){
		return logDAO.obter(id);
	}
	
	public Log alterar(Log log){
		return logDAO.alterar(log);
	}
	
	@Transactional
	public Log remover(Long id){
		return logDAO.remover(logDAO.obter(id));
	}


}
