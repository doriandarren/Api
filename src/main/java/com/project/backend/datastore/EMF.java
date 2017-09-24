package com.project.backend.datastore;

import java.awt.image.RasterFormatException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public final class EMF {
	private static EntityManagerFactory emfInstance = Persistence
			.createEntityManagerFactory("transactions-optional");

	private EMF() {
		
	}
	
	public static EntityManagerFactory get() {
        if(emfInstance == null) {
            emfInstance = Persistence.createEntityManagerFactory("transactions-optional");
            checkEntityManagerFactory(emfInstance); 
        }
        return emfInstance;
    }

	private static void checkEntityManagerFactory(EntityManagerFactory emf) {
		if(emf==null)
			throw new RasterFormatException("It is no posible recover a EntityManagerFactory"); 
		
	}
	
}