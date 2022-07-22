package model;

import java.util.ArrayList;
import java.util.List;

public class Jogador {

	private String nome;
	private List<Moeda> moedas=new ArrayList<>();
	private double valor;

	public Jogador(String nome, List<Moeda> moedas, double valor) {
		this.nome = nome;
		this.moedas = moedas;
		this.valor = valor;
	}
	
	public void add(Moeda moeda) {
		this.moedas.add(moeda);
	}
	
	public void calcularCambio(Moeda moeda) {
		this.valor+=(moeda.getValor()*moeda.getCambio());
	}

	@Override
	public String toString() {
		return "Nome: " + nome + ", Moedas: " + this.moedas + ", Valor: " + valor + "\n";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Moeda> getMoedas() {
		return moedas;
	}

	public void setMoedas(List<Moeda> moedas) {
		this.moedas = moedas;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	

}
