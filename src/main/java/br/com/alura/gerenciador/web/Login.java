package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;




public class Login implements Tarefa {
	

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		String pagina = "";
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		
		
		if(usuario == null) {
			
			pagina = "/WEB-INF/paginas/loginError.html";
			
		} else {
			HttpSession session = req.getSession();
			//o setAttribute funciona como um hasmap 
			session.setAttribute("usuarioLogado", usuario);
			pagina = "/WEB-INF/paginas/login.jsp";
			
		
		}
		
		return pagina;
	}

}
