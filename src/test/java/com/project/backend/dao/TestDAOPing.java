package com.project.backend.dao;

import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.project.backend.datastore.DAOPing;
import com.project.backend.model.Ping;

import junit.framework.TestCase;

public class TestDAOPing {
	
	private final LocalServiceTestHelper helper = 
			new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

	@Before
	public void setUp() {
		helper.setUp();
	}

	@After
	public void tearDown() {
		helper.tearDown();
	}

	@Test
	public void testCreate() {

		long time = System.currentTimeMillis();

		Ping debug = mosckPing("hola", time);

		DAOPing dao = new DAOPing();
		dao.create(debug);

		Assert.assertNotNull(debug.getKey());
		Assert.assertEquals("hola", debug.getData());
		Assert.assertEquals(time, debug.getTimestamp(), 0.1);

	}
	
	
	/*
	//@Test
	public void testUpdate() {	
				
		Ping debug = mosckPing("PingNuevo", System.currentTimeMillis());
		
		daoPing.connect();
		daoPing.getMgr().getTransaction().begin();
		daoPing.getMgr().persist(debug);
		daoPing.getMgr().getTransaction().commit();
		daoPing.close();
		
		
		daoPing.connect();
		Ping debugSearch = daoPing.getMgr().find(Ping.class, debug.getKey());
		daoPing.close();
		
		
		
		debugSearch.setData("PingUpdate");
		long time = System.currentTimeMillis();
		debugSearch.setTimestamp(time);
		
		daoPing.update(debugSearch);
		
		daoPing.connect();
		Ping debugUpdate = daoPing.getMgr().find(Ping.class, debug.getKey());
		daoPing.close();
		
		
		Assert.assertNotNull(debugUpdate.getKey());
		Assert.assertEquals("PingUpdate", debugUpdate.getData());
		Assert.assertEquals(time, debugUpdate.getTimestamp(), 0.1);
		
		
	}
	
	
	
	@Test
	public void testDelete() {
		
		Ping debug = mosckPing("PingNuevo", System.currentTimeMillis());
		
		daoPing.connect();
		daoPing.getMgr().getTransaction().begin();
		daoPing.getMgr().persist(debug);
		daoPing.getMgr().getTransaction().commit();
		daoPing.close();
		
		daoPing.delete(debug);
		
		daoPing.connect();
		Ping debugSearch = daoPing.getMgr().find(Ping.class, debug.getKey());
		daoPing.close();
		
		Assert.assertNull(debugSearch);
		
	}
	
	
	
	
	//@Test
	public void testFind() {
		Ping debug = mosckPing("PingNuevo", System.currentTimeMillis());
		
		daoPing.connect();
		daoPing.getMgr().getTransaction().begin();
		daoPing.getMgr().persist(debug);
		daoPing.getMgr().getTransaction().commit();
		daoPing.close();
		
		daoPing.connect();
		Ping debugSearch = daoPing.getMgr().find(Ping.class, debug.getKey());
		daoPing.close();
		
		Assert.assertNotNull(debugSearch.getKey());
		Assert.assertEquals("PingNuevo", debugSearch.getData());
		
	}
	
	
	
	//@Test
	public void testFindAll() {
		Ping debug1 = mosckPing("PingNuevo1", System.currentTimeMillis());
		Ping debug2 = mosckPing("PingNuevo2", System.currentTimeMillis());		
		Ping debug3 = mosckPing("PingNuevo3", System.currentTimeMillis());
		
		daoPing.connect();
		daoPing.getMgr().getTransaction().begin();
		daoPing.getMgr().persist(debug1);
		daoPing.getMgr().persist(debug2);
		daoPing.getMgr().persist(debug3);		
		daoPing.getMgr().getTransaction().commit();
		daoPing.close();
		
		
		Set<Ping> listPing = daoPing.findAll();
		
		
		Assert.assertEquals(3, listPing.size());
		Assert.assertNotNull(findPing(listPing,"PingNuevo1"));
		
	}
	*/
	
	
	

	private Ping findPing(Set<Ping> set, String data) {
		for(Ping ping: set) {
			if(ping.getData().equals(data))
				return ping;
		}
		return null;
	}

	private Ping mosckPing(String data, long currentTimeMillis) {
		Ping debug = new Ping();
		debug.setData(data);
		debug.setTimestamp(currentTimeMillis);
		return debug;
	}

}
