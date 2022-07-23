package service;

import java.util.List;

public interface IService<T> {

	
	public void Add(T t);
	public void Update(T t);
	public T delete(int posicao);
	public T findBy(int posicao);
	public List<T> list();
	public List<T> listRandom();
}
