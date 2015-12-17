package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/executa")
public class Controller extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//qual tarefa
		String tarefa = req.getParameter("tarefa");

	
		if(tarefa==null) {
			new IllegalAccessException("Você esquece de passar a tarefa");
		} 
		//para onde vou	
		tarefa = "br.com.alura.gerenciador.web." + tarefa;
		
			try {
				Class<?> tipo = Class.forName(tarefa);
				Tarefa instancia = (Tarefa) tipo.newInstance();
				String pagina = instancia.executa(req, res);
				RequestDispatcher dispacher = req.getRequestDispatcher(pagina);
				dispacher.forward(req, res);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				
				throw new ServletException(e);
			} 
			
		
		
		
		
	}

	
	
	
}
