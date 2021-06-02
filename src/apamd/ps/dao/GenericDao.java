package apamd.ps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class GenericDao<T, ID> {

	private EntityManagerFactory factory;
	private EntityManager manager;
	private Class<T> persistedClass;

	public GenericDao(Class<T> persistedClass, String persistenceUnit) {
		this.persistedClass = persistedClass;
		factory = Persistence.createEntityManagerFactory(persistenceUnit);
	}

	public void cadastrar(T entity) {
		manager = factory.createEntityManager();

		EntityTransaction trasaction = manager.getTransaction();
		trasaction.begin();
		manager.persist(entity);
		manager.flush();
		trasaction.commit();

		manager.close();
	}

	public List<T> procurarTodos() {
		manager = factory.createEntityManager();

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(persistedClass);
		query.from(persistedClass);
		List<T> resultado = manager.createQuery(query).getResultList();

		manager.close();
		return resultado;
	}
	
	public void deletarPorId(ID id) {
		manager = factory.createEntityManager();
		
		EntityTransaction trasaction = manager.getTransaction();
		trasaction.begin();
		T entity = manager.find(persistedClass, id);
		manager.remove(entity);
		manager.flush();
		trasaction.commit();
		
		manager.close();
	}
	
	public void atualizar(T entity) {
		manager = factory.createEntityManager();
		
		EntityTransaction trasaction = manager.getTransaction();
		trasaction.begin();
		manager.merge(entity);
		manager.flush();
		trasaction.commit();
		
		manager.close();
	}
	
	public T procurarPorId(ID id) {
		manager = factory.createEntityManager();
		T entity = manager.find(persistedClass, id);
		manager.close();
		return entity;
	}

}
