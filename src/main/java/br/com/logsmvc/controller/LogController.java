package br.com.logsmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.logsmvc.dao.PacoteDAO;
import br.com.logsmvc.model.Log;
import br.com.logsmvc.service.LogService;

@Controller
@RequestMapping(value = "log")
public class LogController {

		@Autowired
		LogService logService;
		@Autowired
		PacoteDAO pacoteDAO;
		
		@RequestMapping(value = "form", method = RequestMethod.POST)
		public ModelAndView inserir(@ModelAttribute Log log, RedirectAttributes redirectAttributes) {
			
			log.setPacote(pacoteDAO.obter(log.getPacote().getCodigo()));
			logService.inserir(log);
			
			redirectAttributes.addFlashAttribute("sucesso", "Log cadastrado com sucesso!");
			ModelAndView model = new ModelAndView("redirect:form");
			
			return model;
		}
		
		@RequestMapping(value = "form", method = RequestMethod.GET)
		public ModelAndView form() {
			
			ModelAndView model = new ModelAndView();
			model.setViewName("formLogs");
			model.addObject("pacotes", pacoteDAO.listar());
			return model;
		}
		
		@RequestMapping(value = "lista", method = RequestMethod.GET)
		public ModelAndView listar() {
			ModelAndView model = new ModelAndView("listaLogs");
			model.addObject("logs", logService.listar());
			return model;
		}
		
		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public ModelAndView alterar(@PathVariable("id") Long id, RedirectAttributes redirectAtributes) {
			ModelAndView model = new ModelAndView("redirect:form");
			Log log =logService.obter(id);
			redirectAtributes.addFlashAttribute("log", log);
			redirectAtributes.addFlashAttribute("codigoPacote", log.getPacote().getCodigo());
			redirectAtributes.addFlashAttribute("pacotes", pacoteDAO.listar());
			return model;
		}
		
		@RequestMapping(value = "/alterar", method = RequestMethod.POST)
		public ModelAndView alterar(Log log, RedirectAttributes redirectAtributes) {
			ModelAndView model = new ModelAndView("redirect:form");
			redirectAtributes.addFlashAttribute("sucesso", "Log alterado com sucesso!");
			logService.alterar(log);
			return model;
		}
		
		@RequestMapping(value = "/remover/{id}", method = RequestMethod.POST)
		public ModelAndView remover(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
			ModelAndView model = new ModelAndView("redirect:/log/lista");
			redirectAttributes.addFlashAttribute("sucesso", "Log removido com sucesso!");
			logService.remover(id);
			return model;
		}
		
		
}
