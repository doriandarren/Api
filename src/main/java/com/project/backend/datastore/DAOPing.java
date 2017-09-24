package com.project.backend.datastore;

import javax.persistence.EntityManager;

import com.google.appengine.api.datastore.Key;
import com.project.backend.model.Ping;

public class DAOPing implements IntManagerDAO.IntCRUD<Ping> {

	
	@Override
	public void create(Ping ping) {	
		EntityManager mgr = DSCommons.getEntityManager();
		mgr.getTransaction().begin();
		mgr.persist(ping);
		mgr.getTransaction().commit();				
		mgr.close();
		
	}
	
	@Override
	public Ping read(Key key) {
		EntityManager mgr = DSCommons.getEntityManager();	
		mgr.getTransaction().begin();
		Ping ping = mgr.find(Ping.class, key);		
		mgr.getTransaction().commit(); 				
		mgr.close();		
		return ping;
	}


	@Override
	public void delete(Ping ping) {
		EntityManager mgr = DSCommons.getEntityManager();
		mgr.getTransaction().begin();
		Ping pingRemove = mgr.find(Ping.class, ping.getKey());
		mgr.remove(pingRemove);
		mgr.getTransaction().commit();				
		mgr.close();		
	}


	@Override
	public void update(Ping ping) {
		EntityManager mgr = DSCommons.getEntityManager();
		mgr.getTransaction().begin();		
		Ping pingSearch = mgr.find(Ping.class, ping.getKey());	
		pingSearch.setData(ping.getData());
		pingSearch.setTimestamp(ping.getTimestamp());		
		mgr.getTransaction().commit();				
		mgr.close();		
	}
	
	
}
