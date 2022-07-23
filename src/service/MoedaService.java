package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
		return this.moedas.remove(posicao);
	}
	
	public void delete(Moeda posicao) {
		 this.moedas.remove(posicao);
	}

	@Override
	public Moeda findBy(int posicao) {
		return this.moedas.get(posicao);
	}

	@Override
	public List<Moeda> list() {
		return this.moedas;
	}

	@Override
	public List<Moeda> listRandom() {
		Random aleatorio = new Random();
		List<Moeda> listaAletoria = new ArrayList<>();
		while (listaAletoria.size() < this.moedas.size()) {
			int index = aleatorio.nextInt(this.moedas.size());
			Moeda moeda = this.moedas.get(index);
			if (!listaAletoria.contains(moeda)) {
				listaAletoria.add(moeda);
			}
		}
		return listaAletoria;
	}

}
