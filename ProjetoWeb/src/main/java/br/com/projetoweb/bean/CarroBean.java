package br.com.projetoweb.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import br.com.projetoweb.dao.CarroDAO;
import br.com.projetoweb.domain.Carro;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CarroBean implements Serializable{
	private Carro carro = new Carro();
	private ArrayList<Carro> carros;
	
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	public ArrayList<Carro> getCarros() {
		return carros;
	}
	public void setCarros(ArrayList<Carro> carros) {
		this.carros = carros;
	}
	
	@PostConstruct
	public void list() {
		try {
			CarroDAO carroDAO = new CarroDAO();
			carros = carroDAO.list();
		}catch(RuntimeException error) {
			error.printStackTrace();
		}
	}
	
	public void novo() {
		try {
			carro = new Carro();
		}catch(RuntimeException error) {
			error.printStackTrace();
		}
	}
	
	public void salvar()
	{
		try {
			CarroDAO pessoaDAO = new CarroDAO();
			pessoaDAO.salvar(carro);
			
			carro = new Carro();
			this.list();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Carro cadastrado com sucesso!", ""));
			
		}catch(RuntimeException error) {
			error.printStackTrace();
		}
	}
}
