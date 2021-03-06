package org.bbop.framework.dock;

import org.apache.log4j.*;

public class Perspective {

	//initialize logger
	protected final static Logger logger = Logger.getLogger(Perspective.class);
	protected String id;
	protected String name;
	protected boolean builtIn = false;
	
	public Perspective() {
	}
	
	public Perspective(String id, String name) {
		this(id, name, false);
	}
	
	public Perspective(String id, String name, boolean builtIn) {
		this.id = id;
		this.name = name;
		this.builtIn = builtIn;
	}
	
	public boolean getBuiltIn() {
		return builtIn;
	}
	
	public String getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setBuiltIn(boolean builtIn) {
		this.builtIn = builtIn;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Perspective) {
			return ((Perspective) o).getID().equals(id);
		} else
			return false;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	@Override
	public String toString() {
		return name;
	}
}
