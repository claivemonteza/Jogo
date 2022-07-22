package model;

public class Moeda {

	private String tipo;
	private double valor;
	private double cambio;
	
	public Moeda(String tipo, double valor, double cambio) {
		this.tipo = tipo;
		this.valor = valor;
		this.cambio = cambio;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getCambio() {
		return cambio;
	}
	public void setCambio(double cambio) {
		this.cambio = cambio;
	}

	@Override
	public String toString() {
		return "Tipo: " + tipo + ", Valor: " + valor + ", Cambio: " + cambio + "\n";
	}	
	
}
