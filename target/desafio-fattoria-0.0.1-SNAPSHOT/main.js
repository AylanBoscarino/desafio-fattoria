
	$(function() {
		var $tabela = $("#tabela");
		var $nome = $("#nome");
		var $preco = $("#preco");
		var $quantidade = $("#quantidade");
		var $data = $("#data");
		var $lista = $("lista");
		var currentId = null;
		
		
		
		$.ajax({			
			type:'GET',
			url:"produtoDao", 
			dataType:'json',
			success:function(dados){
				
				$.each(dados, function(i, bracket){
					console.log(bracket);
					$tabela.append('<tr><th> Nome </th>'+
									'<th> Preço </th>'+
									'<th> Quantidade </th>'+
									'<th> Data de Cadastro </th>'+
									'</tr>');
					$.each(bracket, function(i, produto) {
						//$tabela.append();
						$tabela.append( "<tr id="+produto.id+" class=referencia>"+
										'<td>' + produto.nome + '</td>'  + 
										'<td>' + produto.preco + '</td>' + 
										'<td>' + produto.quantidade + '</td>' +
										'<td>' + produto.data + '</td>' +
										"<td> <button class='bitbutton editar' name=editar data-id="+produto.id+">E</button>" + "</td>"+
										"<td> <button class='bitbutton remove' name=remover data-id="+produto.id+">X</button></td></tr>");
						})
					
						
				})
				},
			error: function(){
				alert('deu ruim');
			}
		});
		function limparCampos(){
			$nome.val("");
			$preco.val("");
			$quantidade.val("");
			//$data.val("");
			$(".toggleButton").fadeOut();
			currentId = null;
		}
		$("#salvar").on("click", function(){
			if( $("#nome").valid() && $("#preco").valid() && $("#quantidade").valid() && $("#data").valid()){
				
			var produto = {
					nome: $nome.val(),
					preco: $preco.val(),
					quantidade: $quantidade.val(),
					data: $data.val(),
					id: currentId
			}
			limparCampos();
			location.reload(true);
			$.ajax ({
				type:"POST",
				url:"editServlet/0",
				data: produto,
				sucess:function(produtoSalvo){
					
				}
				
				
			})
			
		}
		});
		$("#limpar").on("click", function(){
			limparCampos();
		});
		$(".cadastrar").on('click', function(event){
			event.preventDefault();
			
			if( $("#nome").valid() && $("#preco").valid() && $("#quantidade").valid() && $("#data").valid()){
				
			
			
			var produto = {
					nome: $nome.val(),
					preco: $preco.val(),
					quantidade: $quantidade.val(),
					data: $data.val()
			}
			$.ajax({			
				type:"POST",
				url:"produtoDao",
				data: produto,
				success:function(newProduto){
					$tabela.append( '<tr id='+produto.id+' class=referencia>' +
									'<td>'+$nome.val() + '</td>' + 
									'<td>'+$preco.val() + '</td>' + 
									'<td>'+$quantidade.val() + '</td>' + 
									'<td>'+$data.val() + '</td>' +
									"<td> <button class='bitbutton editar' name=editar data-id="+newProduto.id+">E</button>" +"</td>"+
									"<td> <button class='bitbutton remove' name=remover data-id="+newProduto.id+">X</button></td></tr>");
					limparCampos();
				}	
			})
		}
		});
		$tabela.delegate('.remove', 'click', function(){
			var $tr = $(this).closest('.referencia');
			$tr.remove();
			$.ajax({
				type:'POST',
				url:'deleteDao',
				data:{"data-id" : $(this).attr('data-id')},
				sucess:function(){
					
				}
			})
			
		});
		$tabela.delegate('.editar', 'click', function(){
			$('.toggleButton').fadeIn();
			$.ajax ({
				type:'GET',
				url:'editServlet/'+ $(this).attr('data-id'),
				dataType:'json',
				success:function(dados){
					$.each(dados, function(i, bracket){
						$.each(bracket, function(i, produto){
							$nome.val(produto.nome),
							$preco.val(produto.preco),
							$quantidade.val(produto.quantidade),
							$data.val(produto.data),
							currentId = produto.id;
						})
						
						
					})
					
				}
			})
		});
		
		
		});
							
	