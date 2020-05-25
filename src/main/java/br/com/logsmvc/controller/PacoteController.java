package br.com.logsmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.logsmvc.model.Pacote;
import br.com.logsmvc.service.PacoteService;

@Controller
@RequestMapping("pacote")
public class PacoteController {
	
	@Autowired
	PacoteService pacoteService;
	
	@RequestMapping(value = "/form", method = RequestMethod.POST )
	public ModelAndView inserir(Pacote pacote, RedirectAttributes redirectAtributes) {
		
		pacoteService.inserir(pacote);
		ModelAndView model = new ModelAndView("redirect:/pacote/form");
		redirectAtributes.addFlashAttribute("sucesso", "Pacote cadastrado com sucesso");
		
		return model;
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET , name = "form")
	public ModelAndView form() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("formPacotes");
		return model;
	}
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET )
	public ModelAndView form(@PathVariable("codigo") String codigo, RedirectAttributes redirectAtributes) {
		
		ModelAndView model = new ModelAndView("redirect:form");
		redirectAtributes.addFlashAttribute("pacote", pacoteService.obter(codigo));
		return model;
	}
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET )
	public ModelAndView lista() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("listaPacotes");
		model.addObject("pacotes", pacoteService.listar());
		return model;
	}
	
	@RequestMapping(value = "/alterar", method = RequestMethod.POST )
	public ModelAndView alterar(Pacote pacote, RedirectAttributes redirectAtributes) {
		
		ModelAndView model = new ModelAndView("redirect:form"); 
		pacoteService.alterar(pacote);
		redirectAtributes.addFlashAttribute("sucesso","Pacote alterado com sucesso" );
		return model;
	}
	
	@RequestMapping(value = "/remover/{codigo}", method = RequestMethod.POST )
	public ModelAndView remover(@PathVariable("codigo") String codigo, RedirectAttributes redirectAtributes) {
		
		ModelAndView model = new ModelAndView("redirect:pacote/lista"); 
		pacoteService.remover(codigo);
		redirectAtributes.addFlashAttribute("sucesso","Pacote removido com sucesso" );
		return model;
	}
}
