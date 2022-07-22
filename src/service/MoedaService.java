package service;

import java.util.ArrayList;
import java.util.List;

import model.Moeda;

public class MoedaService implements IService<Moeda> {

	private List<Moeda> moedas = new ArrayList<>();
	
	@Override
	public void Add(Moeda t) {
		this.moedas.add(t);
	}

	@Override
	public void Update(Moeda t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Moeda delete(int posicao) {
		return this.moedas.remove(posicao-1);
	}

	@Override
	public Moeda findBy(int posicao) {
		return this.moedas.get(posicao);
	}

	@Override
	public List<Moeda> list() {
		return this.moedas;
	}

}
