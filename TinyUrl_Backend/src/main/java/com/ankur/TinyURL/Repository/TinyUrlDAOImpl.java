package com.ankur.TinyURL.Repository;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ankur.TinyURL.Entity.TinyUrlEntity;

@Repository
public class TinyUrlDAOImpl implements TinyUrlDAO {
	
	@PersistenceContext
	EntityManager e;
	
	public void saveUrl(TinyUrlEntity t) {
		e.persist(t);
		e.flush();
	}
	
	public String getUrl(int no) throws Exception {
		String sqlString = "select u from TinyUrlEntity u where u.id=?1";
		Query q = e.createQuery(sqlString, TinyUrlEntity.class);
		q.setParameter(1, no);
		Object t = q.getSingleResult();
		if(t==null) {
			throw new Exception("NOT_FOUND");
		}
		TinyUrlEntity t1 = (TinyUrlEntity)t;
		String url = t1.getOriginalUrl() ;
		return url;
	}

}
