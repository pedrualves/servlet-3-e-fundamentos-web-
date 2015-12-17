<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>


	Bem Vindo ao nosso gerenciador de Empresa!
	
	<br>
	<br>
	
	<c:if 	test="${not empty usuarioLogado}">
	
		Logado como ${usuarioLogado.email}
	 </c:if>
	
	
	<br>
	<br>
	<form action="executa" method="post">
    <input type="hidden" name="tarefa" value="NovaEmpresa"/>
    	Nome: <input type="text" name="nome" />  	<input type="submit" value="Enviar" />
	</form>

	<form method="post" action="executa">
	<input type="hidden" name="tarefa" value="Login"/>
	E-mail: <input type="text" name="email" ></input> Senha:<input type="password" name="senha"></input>
	<input type="submit" value="Enviar" ></input>
	
	</form>
	
	<form method="post" action="executa">
	
	<input type="hidden" name="tarefa" value="Logout"/>
	<input type="submit" value="Sair" ></input>
	
	</form>
	
	
	
	

</body>

</html>
