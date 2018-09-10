package com.codenotfound.primefaces.model;

import java.io.Serializable;

public interface IEntity extends Serializable{
	
	public long getId();
	public String getName();
	public String getTableName();
	
	public void setId(long id);
	

}
