package app.repository;

import java.util.List;

public interface Repository<T> {
	void save(T entity);

	T findById(Long aLong);

	List<T> findAll();

	void remove(Long id);
}
