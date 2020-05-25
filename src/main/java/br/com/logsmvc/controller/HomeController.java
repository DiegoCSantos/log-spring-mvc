package br.com.logsmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.logsmvc.model.Log;
import br.com.logsmvc.model.Pacote;
import br.com.logsmvc.service.LogService;
import br.com.logsmvc.service.PacoteService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	LogService logService;
	
	@Autowired
	PacoteService pacoteService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(@RequestParam(name = "search", required = false) String search) {
		ModelAndView model =new ModelAndView("home");
		
		if(search != null && !search.isEmpty()) {
			Pacote pacote = pacoteService.obter(search);
			
			if(pacote ==null) {
				model.addObject("erro", "Pacote não encontrado");
			}
			
			List<Log> logs = logService.listarPorPacote(search);
			
			if(logs ==null || logs.isEmpty()) {
				model.addObject("erro", "Nenhum log encontrado");
			}else {
				model.addObject("logs", logs);
			}
		}
		
		return model;
	}

}
