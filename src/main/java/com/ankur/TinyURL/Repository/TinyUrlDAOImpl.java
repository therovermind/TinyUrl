package com.ankur.TinyURL.Repository;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ankur.TinyURL.Entity.TinyUrlEntity;

@Repository
public class TinyUrlDAOImpl implements TinyUrlDAO {
	
	@PersistenceContext
	EntityManager e;
	
	@Autowired
	SessionFactory sessionFactory;
	
	public long saveUrl(TinyUrlEntity t) {
		Session session = sessionFactory.openSession();
		try {
			e.persist(t);
			Long lastId = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).longValue();
		    return lastId;
		} finally {
		    session.close();
		}
	}
	
	public String getUrl(long no) {

		TinyUrlEntity t = e.find(TinyUrlEntity.class, no);
		String url = t.getOriginalUrl() ;
		return url;
	}

}
