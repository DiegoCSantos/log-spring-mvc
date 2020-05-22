package br.com.logsmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.logsmvc.dao.PacoteDAO;
import br.com.logsmvc.model.Pacote;

@Controller
public class PacoteController {
	
	@Autowired
	PacoteDAO dao;
	
	@RequestMapping(value = "pacote/form", method = RequestMethod.POST )
	public ModelAndView inserir(Pacote pacote, RedirectAttributes redirectAtributes) {
		
		dao.inserir(pacote);
		ModelAndView model = new ModelAndView("redirect:/pacote/form");
		redirectAtributes.addFlashAttribute("sucesso", "Pacote cadastrado com sucesso");
		
		return model;
	}

	@RequestMapping(value = "pacote/form", method = RequestMethod.GET )
	public ModelAndView form() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("formPacotes");
		return model;
	}
	
	@RequestMapping(value = "pacote/lista", method = RequestMethod.GET )
	public ModelAndView lista() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("listaPacotes");
		model.addObject("pacotes", dao.listar());
		return model;
	}
}
