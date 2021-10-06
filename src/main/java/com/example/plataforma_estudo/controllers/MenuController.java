package com.example.plataforma_estudo.controllers;

import com.example.plataforma_estudo.dao.UsuarioDao;

/*import javax.servlet.http.HttpSession;*/


/*import com.example.plataforma_estudo.models.Usuario;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;*/

import com.example.plataforma_estudo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;






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


	@GetMapping("/cadastro")
	public String exibirCadastro() {
		return "cadastro";
	}
	
	//exibindo o form de cadUsuario
	/*@GetMapping("/cadastroUsuario")
	public ModelAndView cadastroUsuariAndView() {
		ModelAndView mv = new ModelAndView("/cadastro");
		mv.addObject("usuario", new Usuario());
		return mv;
	}*/


	//salvar o usuario no banco
	/*@PostMapping("/cadastrarUsuario")
	public String salvarUsuario(@Valid Usuario usuario, BindingResult br, RedirectAttributes ra) throws Exception {
		if(br.hasErrors()) {
			ra.addFlashAttribute("mensagemError", "Preencha o campo");
			return "redirect:/cadastrarUsuario";
		}else {
			try {
				this.usuarioService.save(usuario);
				return "redirect:/login";
			} catch (Exception e) {
				ra.addFlashAttribute("mensagemErro", "Não foi possivel cadastrar " + e.getMessage());
			} 
				
			
		}
		return "redirect:/cadastroLivros";
		
	}*/
}
