package com.cursocuencajava.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cursocuencajava.app.entities.Cursos;
import com.cursocuencajava.app.entities.Usuario;
import com.cursocuencajava.app.model.CursoInfo;
import com.cursocuencajava.app.model.LoginInfo;
import com.cursocuencajava.app.model.StatusResult;
import com.cursocuencajava.app.services.Centro;
import com.cursocuencajava.app.services.ICentro;
import com.cursocuencajava.app.services.IUsuarios;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	public static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private IUsuarios usuarios;
	
	@Autowired
	private ICentro centro;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST,produces="application/json")
	@ResponseBody
	public String login(@ModelAttribute LoginInfo info) {
		Usuario user = usuarios.login(info.getU(), info.getP());
		return new StatusResult(user==null?StatusResult.NOT_ALLOWED:StatusResult.OK,user).toJson();
	}
	
	@RequestMapping(value = "api/cursos/save", method = RequestMethod.POST,produces="application/json")
	@ResponseBody
	public Cursos save(@ModelAttribute CursoInfo info) {
		return centro.addCurso(info.getCurso());
	}
	
	@RequestMapping(value = "api/cursos/list", method = RequestMethod.GET,produces="application/json")
	@ResponseBody
	public List<Cursos> list() {
		return centro.cursos();
	}
	
}
