<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta charset="utf-8">
	<title>Tela Inicial</title>
	<style>
	a.test{
		font-weight: bold;
	}
	th{
		text-align: left;
	}
	table {
		padding:10px;
		background-color: #ff66ff;
		color: #330033;
		width:700px;
		
	}
	form {
		padding:12px 20px;
		background-color: #ff66ff;
		color: #330033;
		width:700px;
		
	}
	button {
		background-color: 	 #660066;
    	border: none;
    	color: white;
    	padding: 15px 32px;
    	text-align: center;
    	text-decoration: none;
    	
    	font-size: 16px;
    	position: static;
    	left:300px;
    	top:150px;
	
	}
	.bitbutton{
     width: 20px;
    height: 20px;
    border: 0 none transparent;
    padding:0;
    margin:0;
	}
	
	input[type=text], select {
    width: 60%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
	}

	.formbutton {
   		width: 200px
    	background-color: #4CAF50;
    	color: white;
    	padding: 14px 20px;
    	margin: 8px 0;
    	border: none;
    	border-radius: 4px;
    	cursor: pointer;
	}
	</style>
	 
	<script
			  src="http://code.jquery.com/jquery-3.3.1.js"
			  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
			  crossorigin="anonymous"></script>
	
	
</head>
<body>
	
	
	
	
	
	
	<div>
	<button class="formbutton cadastrar">Cadastrar Produtos</button>
	<span><button id="limpar" class="formbutton" >Limpar Campos</button></span>
	<span><button class="toggleButton salvar formbutton" id="salvar" hidden>Salvar Alterações</button></span>
	
	<form id="formulario" method="POST" class="cmxform">
					
						
						
						
                    <br> <input type="text" id="nome" placeholder="Nome do Produto" required/><br />
                    <br> <input type="number" id="preco" placeholder="Preço do Produto" required/><br />
                    <br> <input type="digits" id="quantidade" placeholder="Quantidade a ser cadastrada" required/><br />
					<br> <input type="date" id="data" placeholder="Data de Cadastro" required/><br />
					</form>
	
	</div>

	<table id="tabela" style="width:740px"/>	
	
	<script src="webjars/jquery/3.2.1/jquery.js"></script>
	<script src="jquery.validate.js"></script>
	<script src="main.js"></script>	
	<script>
	$("#formulario").validate();
	</script>	
</body>
</html>


