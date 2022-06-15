package com.example.plataforma_estudo.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.example.plataforma_estudo.models.TipoUsuario;
import com.example.plataforma_estudo.models.Usuario;

public class AutorizadorInterceptor implements HandlerInterceptor {

	private final boolean CONTROLAR_ACESSO = true;
	
	private final String PAGINA_ACESSO_NEGADO = "/acesso-negado";
	
	private final String[] PAGINAS_ESTATICAS = {"/homeCss/", "/icon/", "/imagCurso/", "/img/", "/js/", "/professorCss", "/useCss", "styleGlobal.css"};
	private final String[] PAGINAS_DESLOGADO = {"/", "/login", "/cadastroUsuario"};
	private final String[] PAGINAS_LOGADO = {"/home", "/home_user", "/trilha/", PAGINA_ACESSO_NEGADO};
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception 
	{
		String urlRequisitada = request.getServletPath();
		Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");
		boolean estaLogado = usuarioLogado != null ? true : false;
		
		if (!CONTROLAR_ACESSO) {
			return true;
		}
		
		if (urlRequisitada.contains("/trilha/")) {
			if (estaLogado) {
				if (usuarioLogado.getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR)) {
					return true;
				} else {
					response.sendRedirect("/home_user");
					return false;
				}
			} else {
				response.sendRedirect("/login?destino="+urlRequisitada);
				return false;
			}
		}
		for (String paginaLogado : PAGINAS_LOGADO) {
			if (urlRequisitada.contains(paginaLogado)) {
				if (estaLogado) {
					return true;
				} else {
					if (!urlRequisitada.equals("/home") && !urlRequisitada.equals("/sair")) {
						response.sendRedirect("/login?destino="+urlRequisitada);
						return false;
					} else {
						response.sendRedirect("/login");
						return false;
					}
				}
			}
		}
		for (String paginaDeslogado : PAGINAS_DESLOGADO) {
			if (urlRequisitada.equals(paginaDeslogado)) {
				if (!estaLogado) {
					return true;
				} else {
					response.sendRedirect("/home_user");
					return false;
				}
			}
		}
		for (String paginaEstatica : PAGINAS_ESTATICAS) {
			if (urlRequisitada.contains(paginaEstatica)) {
				return true;
			}
		}
		
		return true;
	}
	
}
