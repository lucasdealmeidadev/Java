package br.com.projetoweb.dao;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.projetoweb.util.HibernateUtil;

public class GenericDAO<Entidade> {
	
	private Class<Entidade> classe;
	
	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass()
				.getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	

	public void salvar(Entidade entidade) {
		Session session = HibernateUtil.getSessionsFactory().getCurrentSession();
		Transaction transacao = null;
		
		try {
			transacao = session.beginTransaction();
			session.merge(entidade);
			transacao.commit();
			
		}catch(RuntimeException error) {
			if(transacao != null) {
				transacao.rollback();
			}
			throw error;
		}finally{
			session.close();
		}
	}
	
	public ArrayList<Entidade> list(){
		Session session = HibernateUtil.getSessionsFactory().openSession();
		
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Entidade> query = builder.createQuery(classe);
			
			query.from(classe);
			
			ArrayList<Entidade> result = (ArrayList<Entidade>)session
					.createQuery(query)
					.getResultList();
			
			return result;
			
		}catch(RuntimeException error) {
			throw error;
		}finally{
			session.close();
		}
	}
}
