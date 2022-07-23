package controller;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import Executar.Menu;
import model.Jogador;
import model.Moeda;
import service.JogadorService;
import service.MoedaService;

public class MenuJogar {

	private static Scanner sc = new Scanner(System.in);
	private MoedaService moedaService;
	private JogadorService jogadorService;

	public MenuJogar(MoedaService moedaService, JogadorService jogadoService) {
		this.moedaService = moedaService;
		this.jogadorService = jogadoService;
		init();
	}

	public void init() {

		System.out.println("============ Jogar ============\n" + "1- Distribuir Moedas\n" + "2- voltar");
		int opcao = sc.nextInt();

		switch (opcao) {
		case 1:
			distribuirasMoedas();
			break;
		case 2:
			Menu.init();
			break;
		default:
			System.exit(0);
		}

	}

	public void distribuirasMoedas() {

		
		 Stack<Moeda> moedas = new Stack<>(); moedas.addAll(this.moedaService.list());
		  
		 Stack<Jogador> jogadores = new Stack<>();
		 jogadores.addAll(this.jogadorService.list());
		 
		try {
			boolean verficarJogador = verificarNumeroDeJogadores();
			boolean verficarMoeda = verficarMoedas();
			
			if (!verficarJogador) {
				System.out.println("Não sera possivel jogar! Verifique a numero de jogadores!");
				init();
			}

			if (!verficarMoeda) {
				System.out.println("Não sera possivel jogar! Verifique a quantidade de moedas!");
				init();
			}

			int contador = this.moedaService.list().size() / this.jogadorService.list().size();

			
				/*
				 * for (int j = 1; j <= this.moedaService.list().size(); j++) { Moeda moeda =
				 * this.moedaService.delete(j); if (jogador.getMoedas().size() < contador) {
				 * jogador.add(moeda); } }
				 */
				for (int i=0; i<this.moedaService.listRandom().size(); i++) {
					Moeda moeda = moedas.pop();
					for (Jogador jogador : this.jogadorService.listRandom()) {
					if (jogador.getMoedas().size() < contador) {
						jogador.add(moeda);
						jogador.setValor(calcularValorTotal(jogador.getMoedas()));
					}
				}
			}
			System.out.println(this.jogadorService.list().toString());

			init();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro!");
			init();
		}
	}

	public double calcularValorTotal(List<Moeda> moedas) {
		double valor = 0;
		for (Moeda moeda : moedas) {
			valor = valor + (moeda.getValor() * moeda.getCambio());
		}
		return valor;
	}

	public boolean verificarNumeroDeJogadores() {
		if (this.jogadorService.list().size() != 0 && this.jogadorService.list().size() % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verficarMoedas() {
		if (this.moedaService.list().size() != 0 && this.moedaService.list().size() % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
}
