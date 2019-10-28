package clientServer_template.example;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

public class SerializableObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 627523243085992404L;
	
	protected String command = "";

	
	/**
	 * Default constructor
	 */
	public SerializableObject() {
	
	}
	
	public SerializableObject(String command) {
		this.command = command;

	}
	
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	 
}
