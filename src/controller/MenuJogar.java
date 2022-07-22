package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import Executar.Menu;
import model.Jogador;
import model.Moeda;
import service.JogadorService;
import service.MoedaService;

public class MenuJogar {

	private static Scanner sc = new Scanner(System.in);
	private MoedaService moedaService;
	private JogadorService jogadoService;

	public MenuJogar(MoedaService moedaService, JogadorService jogadoService) {
		this.moedaService = moedaService;
		this.jogadoService = jogadoService;
		adicionarMoedasConfig();
		adicionarJogadorConfig();
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

		Stack<Moeda> moedas = new Stack<>();
		moedas.addAll(this.moedaService.list());
		

		boolean check = verificarTamanho();
		//System.out.println(this.moedaService.list());
		if (check) {
			int contador = Math.floorDiv(this.moedaService.list().size(), this.jogadoService.list().size());
			
				for (int i = 0; i < moedas.size(); i++) {
					for (Jogador jogador : this.jogadoService.list()) {
					Moeda moeda = moedas.pop();
					if (jogador.getMoedas().size() < contador) {
						jogador.add(moeda);
						jogador.setValor(i);
					}
				}
			}
		}

		System.out.println(this.jogadoService.list());
	}

	
	public boolean calcularValorTotal(List<Moeda> moedas){
		double valor=0;
		for (Moeda moeda : moedas) {
			moed
		}
	}
	
	public boolean verificarTamanho() {
		if (this.moedaService.list().size() % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void adicionarMoedasConfig() {
		Moeda moeda = new Moeda("MZN", 4, 1);
		this.moedaService.Add(moeda);
		moeda = new Moeda("MZN", 6, 1);
		this.moedaService.Add(moeda);
		moeda = new Moeda("MZN", 25, 1);
		this.moedaService.Add(moeda);
		moeda = new Moeda("MZN", 20, 1);
		this.moedaService.Add(moeda);

		moeda = new Moeda("EUR", 4, 71);
		this.moedaService.Add(moeda);
		moeda = new Moeda("EUR", 6, 71);
		this.moedaService.Add(moeda);
		moeda = new Moeda("EUR", 25, 71);
		this.moedaService.Add(moeda);
		moeda = new Moeda("EUR", 20, 71);
		this.moedaService.Add(moeda);

		moeda = new Moeda("ZAR", 4, 4);
		this.moedaService.Add(moeda);
		moeda = new Moeda("ZAR", 6, 4);
		this.moedaService.Add(moeda);
		moeda = new Moeda("ZAR", 25, 4);
		this.moedaService.Add(moeda);
		moeda = new Moeda("ZAR", 20, 4);
		this.moedaService.Add(moeda);

		moeda = new Moeda("USD", 4, 67);
		this.moedaService.Add(moeda);
		moeda = new Moeda("USD", 6, 67);
		this.moedaService.Add(moeda);
		moeda = new Moeda("USD", 25, 67);
		this.moedaService.Add(moeda);
		moeda = new Moeda("USD", 20, 67);
		this.moedaService.Add(moeda);

		moeda = new Moeda("GBP", 4, 84);
		this.moedaService.Add(moeda);
		moeda = new Moeda("GBP", 6, 84);
		this.moedaService.Add(moeda);
		moeda = new Moeda("GBP", 25, 84);
		this.moedaService.Add(moeda);
		moeda = new Moeda("GBP", 20, 84);
		this.moedaService.Add(moeda);

	}

	public void adicionarJogadorConfig() {
		List<Moeda> moedas = new ArrayList<>();
		Jogador jogador = new Jogador("Joao", moedas, 0);
		this.jogadoService.Add(jogador);
		jogador = new Jogador("Antonio", moedas, 0);
		this.jogadoService.Add(jogador);

		jogador = new Jogador("Maria", moedas, 0);
		this.jogadoService.Add(jogador);
		jogador = new Jogador("Jose", moedas, 0);
		this.jogadoService.Add(jogador);

	}
}
