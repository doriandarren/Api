package com.project.backend.api;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.project.backend.datastore.DAOPing;
import com.project.backend.model.Ping;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;

@Api(name = "debugendpoint", 
	namespace = @ApiNamespace(
			ownerDomain = "project.com", 
			ownerName = "project.com", 
			packagePath = "backend.model"))

public class DebugEndpoint {

	/**
	 * Servicio de prueba, retorna un objeto debug, con saludo y hora
	 * 
	 * @param name
	 * @return
	 * @throws IOException
	 */
	@ApiMethod(name = "pingNoAuth", path = "pinnoauth", httpMethod = HttpMethod.GET)
	public Ping pingNoAuth(@Named("message") String value_message) {
		Ping debug = new Ping();
		debug.setData("Pong api nosegura, el tiempo en mili-segundos es: " + System.currentTimeMillis() + " message:"
				+ value_message);

		// String id = String.valueOf(debug.getKey().getId());
		// debug.setCodeId(id);
		// debug.setKey(null);

		return debug;
	}

	/**
	 * Servicio de prueba, retorna un objeto debug, con saludo y hora
	 * 
	 * @param name
	 * @return
	 * @throws IOException
	 */
	//METODO POST
	@ApiMethod(name = "insert", path = "insert", httpMethod = HttpMethod.GET)
	public Ping insert(@Named("message") String value_message) {
		Ping debug = new Ping();

		debug.setData(value_message + ( (int) (Math.random() * 100)));
		debug.setTimestamp(System.currentTimeMillis());		
		
		DAOPing dao = new DAOPing();
		dao.create(debug);

		String id = String.valueOf(debug.getKey().getId());
		debug.setCodeId(id);
		debug.setKey(null);
		
		return debug;
	}

	//METODO PUT
	@ApiMethod(name = "update", path = "update", httpMethod = HttpMethod.POST)
	public Ping update(@NotNull Ping ping) {		
		DAOPing dao = new DAOPing();	
		Ping pingUpdate = dao.read(ping.getKey());
		pingUpdate.setData(ping.getData());
		pingUpdate.setTimestamp(ping.getTimestamp());
		dao.update(pingUpdate);		
		return pingUpdate;
	}
	
	//DELETE
	@ApiMethod(name = "delete", path = "delete", httpMethod = HttpMethod.POST)
	public Ping delete(@NotNull Ping ping) {		
		DAOPing dao = new DAOPing();	
		Ping pingDelete = dao.read(ping.getKey());		
		dao.delete(pingDelete);		
		return pingDelete;
	}
	
	//GET
	@ApiMethod(name = "findAll", path = "findAll", httpMethod = HttpMethod.GET)
	public Set<Ping> findAll(@Named("message") String value_message) {		
		DAOPing dao = new DAOPing();	
		//Set<Ping> list = new HashSet<Ping>(dao.findAll());	
		return null;
	}
	

}
