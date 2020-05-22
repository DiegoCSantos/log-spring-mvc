package br.com.logsmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.logsmvc.dao.LogDAO;
import br.com.logsmvc.dao.PacoteDAO;
import br.com.logsmvc.model.Log;

@Controller
@RequestMapping(value = "log")
public class LogController {

		@Autowired
		LogDAO logDAO;
		@Autowired
		PacoteDAO pacoteDAO;
		
		@RequestMapping(value = "form", method = RequestMethod.POST)
		public ModelAndView inserir(@ModelAttribute Log log, RedirectAttributes redirectAttributes) {
			
			log.setPacote(pacoteDAO.obter(log.getPacote().getCodigo()));
			logDAO.inserir(log);
			
			redirectAttributes.addAttribute("sucesso", "Log cadastrado com sucesso!");
			ModelAndView model = new ModelAndView("redirect:form");
			
			return model;
		}
		
		@RequestMapping(value = "form", method = RequestMethod.GET)
		public ModelAndView form() {
			
			
			ModelAndView model = new ModelAndView();
			model.setViewName("formLogs");
			model.addObject("pacotes", pacoteDAO.listar());
			model.addObject(new Log());
			return model;
		}
		
		@RequestMapping(value = "lista", method = RequestMethod.GET)
		public ModelAndView listar() {
			ModelAndView model = new ModelAndView("listaLogs");
			model.addObject("logs", logDAO.listar());
			return model;
		}
}
