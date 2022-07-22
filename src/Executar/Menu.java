package Executar;

import java.util.Scanner;

import controller.MenuJogador;
import controller.MenuJogar;
import controller.MenuMoeda;
import service.JogadorService;
import service.MoedaService;

public class Menu {

	private static Scanner sc = new Scanner(System.in);

	private static MoedaService moedaService = new MoedaService();
	private static JogadorService jogadoService = new JogadorService();

	public Menu() {
		
		init();
	}

	public static void init() {
		
		System.out
				.println("============ JOGO ============\n" + "1- Moeda\n" + "2- Jogador\n" + "3- Jogar\n" + "4- Sair");
		int opcao = sc.nextInt();

		switch (opcao) {
		case 1:
			new MenuMoeda(moedaService);
			break;
		case 2:
			new MenuJogador(jogadoService);
			break;
		case 3:
			new MenuJogar(moedaService, jogadoService);
			break;
		case 4:
			System.exit(0);
			break;
		default:
			System.exit(0);
		}
	}
	
	
}
