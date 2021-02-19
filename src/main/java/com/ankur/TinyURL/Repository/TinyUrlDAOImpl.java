package com.ankur.TinyURL.Repository;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

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

		TinyUrlEntity t = e.find(TinyUrlEntity.class, no);
		if(t==null) {
			throw new Exception("NOT_FOUND");
		}
		String url = t.getOriginalUrl() ;
		return url;
	}

}
