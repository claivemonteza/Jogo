package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Jogador;

public class JogadorService implements IService<Jogador> {

	private List<Jogador> jogadores = new ArrayList<>();

	@Override
	public void Add(Jogador t) {
		this.jogadores.add(t);
	}

	@Override
	public void Update(Jogador t) {

	}

	@Override
	public Jogador delete(int posicao) {
		return this.jogadores.remove(posicao - 1);
	}

	@Override
	public List<Jogador> list() {
		return this.jogadores;
	}

	@Override
	public Jogador findBy(int posicao) {
		return this.jogadores.get(posicao);
	}

	@Override
	public List<Jogador> listRandom() {
		Random aleatorio = new Random();
		List<Jogador> listaAletoria = new ArrayList<>();
		while (listaAletoria.size() < this.jogadores.size()) {
			int index = aleatorio.nextInt(this.jogadores.size());
			Jogador jogador = this.jogadores.get(index);
			if (!listaAletoria.contains(jogador)) {
				listaAletoria.add(jogador);
			}
		}

		return listaAletoria;
	}

}
