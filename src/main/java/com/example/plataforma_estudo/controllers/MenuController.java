package com.example.plataforma_estudo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

/*import javax.servlet.http.HttpSession;*/


/*import com.example.plataforma_estudo.models.Usuario;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;

import com.example.plataforma_estudo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.plataforma_estudo.dao.UsuarioDao;
import com.example.plataforma_estudo.models.Usuario;
import com.example.plataforma_estudo.service.UsuarioService;






@Controller
public class MenuController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioDao usuarioDao;

	@GetMapping("/login")
    public String exibirLogin() {
		return "/user/login";
	}

	/*@GetMapping("/login")
	public ModelAndView login(HttpSession session) {
		ModelAndView mv = new ModelAndView("/login");
		mv.addObject("email", session.getAttribute("email"));
		return mv;
	}*/

	
	//exibindo o form de cadUsuario
	@GetMapping("/cadastroUsuario")
	public ModelAndView cadastroUsuariAndView() {
		ModelAndView mv = new ModelAndView("/cadastro");
		mv.addObject("usuario", new Usuario());
		return mv;
	}


	//salvar o usuario no banco
	@PostMapping("/cadastrarUsuario")
	public String salvarUsuario(@Valid @ModelAttribute Usuario usuario, BindingResult br, RedirectAttributes ra, Model model ) {
		
		if (br.hasErrors()) {
		    String msgErro = br.getAllErrors().get(0).getDefaultMessage();
		    ra.addFlashAttribute("msgErroAdd", msgErro);
		    return "redirect:/cadastroUsuario";
		} else {
		    try {
			this.usuarioService.save(usuario);
			return "redirect:/login";
		    } catch (Exception e) {
			ra.addFlashAttribute("msgErroAdd", "Não foi possivel cadastrar " + e.getMessage());
		    }

		}
		return "redirect:/cadastroUsuario";
	}
	
	
	
	@GetMapping("/aulas")
    public String exibirAulas() {
		return "/aluno/aulas";
	}

	@GetMapping("/home")
    public String exibirHome() {
		return "/aluno/home";
	}

	@GetMapping("/cadastroDisciplina")
	public String exibirCadastroDisciplina() {
		return "/professor/cadDisciplina";
	}

	@GetMapping("/teste")
	public String pagTeste() {
		return "/aluno/teste";
	}
}
