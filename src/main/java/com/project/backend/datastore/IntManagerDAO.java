package com.project.backend.datastore;

import java.util.ArrayList;

import com.google.appengine.api.datastore.Key;

public interface IntManagerDAO{	
	
	public interface IntCRUD<T>{
		public void create(T ping);	
		public T read(Key key);
		public void delete(T ping);	
		public void update(T ping);			
	}	
		
	public interface IntFindAll<T> {
		public <T> ArrayList<T> selectAll();	
	}
		
	public interface IntFindEqual<T> {
		public <T> ArrayList<T> selectEqual();	
	}
		
	public interface IntFindLike<T> {
		public <T> ArrayList<T> selectLike();	
	}
		
	public interface IntFindBt<T> {
		public <T> ArrayList<T> selectBt();		
	}
	
	
}