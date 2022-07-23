package controller;

import java.util.Scanner;

import Executar.Menu;
import model.Moeda;
import service.MoedaService;

public class MenuMoeda {

	private static Scanner sc = new Scanner(System.in);
	private MoedaService moedaService;

	public MenuMoeda(MoedaService moedaService) {
		this.moedaService = moedaService;
		init();
	}

	public void init() {
		try {
			System.out.println("============ Moeda ============\n" + "1- Adicionar\n"
					+ "2- Adicionar Moedas\n" + "3- remover\n" + "4- Listar\n" + "5- Lista Aleatoria\n" + "6- voltar");
			int opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				adicionar();
				break;
			case 2:
				adicionarMoedasConfig();
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
			/*
			 * System.out.println("Ocorreu erro!"); init();
			 */
			System.out.println(e);
		}
	}

	public void adicionar() {

		System.out.print("============ Adicionar Moeda ============\n" + "Tipo: ");
		String tipo = sc.next();

		System.out.print("Valor:");
		double valor = sc.nextDouble();

		System.out.print("Cambio: ");
		double cambio = sc.nextDouble();

		Moeda moeda = new Moeda(tipo, valor, cambio);
		this.moedaService.Add(moeda);
		System.out.println("Adicionou com sucesso!");
		init();

	}

	public void remover() {
		System.out.print("============ Remover Moeda ============\n" + this.moedaService.list() + "\n"
				+ "Insera a posicao que desejar remover?");
		int opcao = sc.nextInt();
		this.moedaService.delete(opcao);
		System.out.println("Removou com sucesso!");
		init();
	}

	public void lista() {
		System.out.println("============ Lista de Moedas ============\n" + this.moedaService.list());
		init();
	}
	
	public void listaAleatoria() {
		System.out.println("============ Lista Aletoria de Moedas ============\n" + this.moedaService.listRandom());
		init();
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

		lista();
		init();
	}

}
