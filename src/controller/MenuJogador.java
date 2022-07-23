package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Executar.Menu;
import model.Jogador;
import model.Moeda;
import service.JogadorService;

public class MenuJogador {

	private static Scanner sc = new Scanner(System.in);
	private JogadorService jogadorService = new JogadorService();

	public MenuJogador(JogadorService jogadorService) {
		this.jogadorService = jogadorService;
		init();
	}

	public void init() {
		try {
			System.out.println("============ Jogador ============\n" + "1- Adicionar\n"+"2- Adicionar Jogadores\n" + "3- remover\n" + "4- Listar\n"
					+ "5- Lista Aleatoria\n"
					+ "6- voltar");
			int opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				adicionar();
				break;
			case 2:
				adicionarJogadorConfig();
				break;	
			case 3:
				remover();
				break;
			case 4:
				lista();
				break;
			case 5:
				listaAleatoria();
				break;	
			case 6:
				Menu.init();
				break;
			default:
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("Ocorreu erro!");
			init();
		}
	}

	public void adicionar() {

		System.out.print("============ Adicionar Jogador ============\n" + "Nome: ");
		String nome = sc.next();

		Jogador jogador = new Jogador(nome, new ArrayList<Moeda>(), 0);
		this.jogadorService.Add(jogador);
		System.out.println("Adicionou com sucesso!");
		init();

	}

	public void remover() {
		System.out.print("============ Remover Jogador ============\n" + this.jogadorService.list() + "\n"
				+ "Insera a posicao que desejar remover?");
		int opcao = sc.nextInt();
		this.jogadorService.delete(opcao);
		System.out.println("Removou com sucesso!");
		init();
	}

	public void lista() {
		System.out.println(
				"============ Lista de Jogadores ============\n" + this.jogadorService.list());
		init();
	}
	
	
	public void listaAleatoria() {
		System.out.println(
				"============ Lista Aletoria de Jogadores ============\n" + this.jogadorService.listRandom());
		init();
	}
	
	
	public void adicionarJogadorConfig() {
		List<Moeda> moedas = new ArrayList<>();
		Jogador jogador = new Jogador("Joao", moedas, 0);
		this.jogadorService.Add(jogador);
		jogador = new Jogador("Antonio", moedas, 0);
		this.jogadorService.Add(jogador);

		jogador = new Jogador("Maria", moedas, 0);
		this.jogadorService.Add(jogador);
		jogador = new Jogador("Jose", moedas, 0);
		this.jogadorService.Add(jogador);
		
		lista();
		init();
	}
}
