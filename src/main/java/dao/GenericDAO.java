package dao;

import java.util.List;

import javax.persistence.EntityManager;




public abstract class GenericDAO<T> {
	private Class<T> klass;
	
	public GenericDAO (Class<T> t) {
		this.klass = t;
	}
	
	public void persist (T t) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.persist(t);
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public void persistList (List<T> tList) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		for (T t : tList) {
			em.persist(t);
		}
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public void update (T t) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.merge(t);
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public T find (Long id) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		T retour = em.find(klass, id);
		DatabaseHelper.commitTxAndClose(em);
		return retour;
	}
	
}
