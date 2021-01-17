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
	
	private Session getSession() {
        return e.unwrap(Session.class);
    }
	
	public int saveUrl(TinyUrlEntity t) {
		Session session = this.getSession();
		try {
			e.persist(t);
			int lastId = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).intValue();
		    return lastId;
		} finally {
		    session.close();
		}
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
