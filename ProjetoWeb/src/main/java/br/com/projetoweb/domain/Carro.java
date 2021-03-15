package br.com.projetoweb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Carro extends GenericDomain{
	
	@Column(length=100, nullable=false)
	private String modelo;
	
	@Column(length=100, nullable=false)
	private String cor;
	
	@Column(length=100, nullable=false)
	private String ano;
	
	@Column(length=100, nullable=false)
	private String marca;
	
	@Column(length=100, nullable=false)
	private String chassi;
	
	@Column(length=100, nullable=false)
	private String proprietario;
	
	@Column(columnDefinition="integer", nullable=false)
	private int portas;

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public int getPortas() {
		return portas;
	}

	public void setPortas(int portas) {
		this.portas = portas;
	}
}
