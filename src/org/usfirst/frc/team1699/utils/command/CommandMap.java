/**
 * Map that is used to store commands
 * 
 * @author squirlemasster42
 */
package org.usfirst.frc.team1699.utils.command;

import java.util.HashMap;
import java.util.Map;

public class CommandMap {
	private Map<String, Command> cmds; //Stores Command to a String key
	
	/**
	 * Constructor
	 */
	public CommandMap(){
		cmds = new HashMap<String, Command>();
	}
	
	/**
	 * Returns map
	 * 
	 * @return Map of Commands
	 */
	public Map<String, Command> getCmds(){
		return cmds;
	}
	
	/**
	 * Returns a Command for a key
	 * 
	 * @param key
	 * @return Command for a key
	 */
	public Command getCommand(String key){
		return cmds.get(key);
	}
	
	/**
	 * Returns true is Map has the key
	 * 
	 * @param key
	 * @return true is Map has key
	 */
	public boolean hasKey(String key){
		return cmds.containsKey(key);
	}
	
	
	public void removeCmd(String key){
		cmds.remove(key);
	}
	
	public int size(){
		return cmds.size();
	}
	
	public void addEntry(String key, Command cmd){
		if(cmds.containsKey(key)){
			throw new NameUsedException();
		}
		
		cmds.put(key, cmd);
	}
}
