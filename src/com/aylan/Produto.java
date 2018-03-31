package com.aylan;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.persistence.SqlResultSetMapping;


@Entity
@Table(name="produto")
public class Produto implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id = null;
	
	
	@Column(name = "nome")
	private String nome = "";
	
	
	@Column(name = "preco")
	private BigDecimal preco = null;
	
	
	@Column(name = "quantidade")
	private int quantidade = 0;
	
	
	@Column(name = "data_cadastro")
	private Date data = null;
	
	@NotNull(message = "campo nome nao pode estar vazio")
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	@NotNull(message = "campo preco nao pode estar vazio")
	@Digits(fraction = 2, integer = 11, message = "maximo de duas casas decimais")
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	@NotNull(message = "campo quantidade nao pode estar vazio")
	@Digits(fraction = 0, integer = 11, message = "numeros inteiros apenas")
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	@NotNull(message = "campo data nao pode estar vazio")
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = (data);
	}
	public Long getId() {
		return this.id;
	}

}
