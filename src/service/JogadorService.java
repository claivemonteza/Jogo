package service;

import java.util.ArrayList;
import java.util.List;

import model.Jogador;

public class JogadorService implements IService<Jogador>{

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
		return this.jogadores.remove(posicao-1);
	}

	@Override
	public List<Jogador> list() {
		return this.jogadores;
	}

	@Override
	public Jogador findBy(int posicao) {
		return this.jogadores.get(posicao);
	}

	
}
