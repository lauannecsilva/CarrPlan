package com.example.plataforma_estudo.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.logging.log4j.util.Strings;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.plataforma_estudo.dao.UsuarioDao;
import com.example.plataforma_estudo.exception.UsuarioInexistenteException;
import com.example.plataforma_estudo.exception.UsuarioInvalidoException;
import com.example.plataforma_estudo.models.TipoUsuario;
import com.example.plataforma_estudo.models.Trilha;
import com.example.plataforma_estudo.models.Usuario;
import com.example.plataforma_estudo.service.TrilhaService;
import com.example.plataforma_estudo.service.UsuarioService;






@Controller
public class MenuController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioDao usuarioDao;

    @Autowired
    private TrilhaService triService;

	@GetMapping("/login")
    public ModelAndView exibirLogin(@RequestParam(required = false) String erro, RedirectAttributes ra) {
//		return "/user/login";
		ModelAndView mv = new ModelAndView("user/login");
		
		if (erro != null) {
			mv.setViewName("redirect:/login");
			
			if (erro.equals("email_em_uso")) {
				ra.addFlashAttribute("msgErro", "Este e-mail já está em uso.");
			} else if (erro.equals("authorization_request_not_found")) {
				ra.addFlashAttribute("msgErro", "Erro ao entrar. Por favor, tente novamente.");
			} else if (erro.equals("email_inexistente")) {
				ra.addFlashAttribute("msgErro", "E-mail não encontrado em nossa base de dados.");
			} else if (erro.equals("access_denied")) {
				ra.addFlashAttribute("msgErro", "Por favor, aceite as permissões necessárias.");
			} else if (erro.equals("nome_vazio_github")) {
				ra.addFlashAttribute("msgErro", "Parece que você não tem um nome definido no GitHub. Por favor, defina um antes de continuar.");
			} else if (erro.equals("provedor_invalido_google")) {
				ra.addFlashAttribute("msgErro", "Aparentemente você está cadastrado com a conta do Google. Por favor, use sua conta do Google para entrar.");
			} else if (erro.equals("provedor_invalido_facebook")) {
				ra.addFlashAttribute("msgErro", "Aparentemente você está cadastrado com a conta do Facebook. Por favor, use sua conta do Facebook para entrar.");
			} else if (erro.equals("provedor_invalido_github")) {
				ra.addFlashAttribute("msgErro", "Aparentemente você está cadastrado com a conta do GitHub. Por favor, use sua conta do GitHub para entrar.");
			} else {
				ra.addFlashAttribute("msgErro", "Desculpe, algo deu errado. Tente novamente.");
			}
		}
		
		return mv;
	}
	
	@PostMapping("/login")
	public String autenticarUsuario(Model model, @RequestParam String email, @RequestParam String senha, 
			@RequestParam(required = false) String destino, HttpServletRequest request, HttpSession session) {
		
		System.out.println("email: " + email);
		System.out.println("senha: " + senha);
		try {
			Usuario usuario = this.usuarioService.entrar(email, senha);

			// salva o usuário na sessão
			session.setAttribute("usuarioLogado", usuario);

			if (!Strings.isBlank(destino)) {
				System.out.println("Redirecionando para "+destino+"...");
				return "redirect:"+destino;
			} else {
				if (usuario.getTipoUsuario().equals(TipoUsuario.ALUNO))
					return "redirect:/home_user";
				else
					return "redirect:/home";
			}
		} catch (UsuarioInexistenteException e) {
			model.addAttribute("msgErro", e.getMessage());
		} catch (UsuarioInvalidoException e) {
			model.addAttribute("msgErro", e.getMessage());
		}

		return "user/login";
	}

	
	@GetMapping("/home_user")
    public String exibirHomeUser() {
		return "/aluno/home_user";
	}

	@GetMapping("/paginaTeste")
    public String exibirpaginaTeste() {
		return "/aluno/paginaTeste";
	}
	

	/*@GetMapping("/login")
	public ModelAndView login(HttpSession session) {
		ModelAndView mv = new ModelAndView("/login");
		mv.addObject("email", session.getAttribute("email"));
		return mv;
	}*/
	
	/*
	@GetMapping("/login")
	public String autenticarUsuario(Model model, @RequestParam String email, @RequestParam String senha, 
			@RequestParam(required = false) String destino, HttpServletRequest request, HttpSession session) {
		try {
			Usuario usuario = this.usuarioService.save(email, senha);

			// salva o usuário na sessão
			session.setAttribute("usuarioLogado", usuario);

			// salva um log de login no banco
			this.logs.save(new Log(usuario, TipoLog.LOGIN, LocalDateTime.now(), request.getRemoteAddr()));
			
			if (!Strings.isBlank(destino)) {
				System.out.println("Redirecionando para "+destino+"...");
				return "redirect:"+destino;
			} else {
				return "redirect:/home";
			}
		} catch (UsuarioInexistenteException e) {
			model.addAttribute("msgErro", e.getMessage());
		} catch (UsuarioInvalidoException e) {
			model.addAttribute("msgErro", e.getMessage());
			session.setAttribute("usuarioId", this.usuarioService.findByEmail(email).get().getId());
		} 

		return "save";
	}
*/
	
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
				usuario.setSenha(this.usuarioService.criptografarSenha(usuario.getSenha()));
				this.usuarioService.save(usuario);
				return "redirect:/login";
			} catch (Exception e) {
				ra.addFlashAttribute("msgErroAdd", "Não foi possivel cadastrar " + e.getMessage());
			}

		}
		return "redirect:/cadastroUsuario";
	}
	
	@GetMapping("/trilha_aluno")
	public ModelAndView listarTrilhasAluno() {
		ModelAndView mv = new ModelAndView("aluno/trilhaAluno");
        Iterable<Trilha> trilha = triService.list();
        mv.addObject("trilha", trilha);
        return mv;
	}
	
	@GetMapping("/aulas")
    public String exibirAulas() {
		return "/aluno/trilhas";
	}

	@GetMapping("/home")
    public String exibirHome() {
		return "/administrador/home";
	}

	@GetMapping("/cadastroTrilha")
	public String exibirCadastroTrilha() {
		return "/administrador/cadTrilha";
	}

	@GetMapping("/teste")
	public String pagTeste() {
		return "/aluno/teste";
	}
	
	@GetMapping("/sair")
	public String sair(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
}
