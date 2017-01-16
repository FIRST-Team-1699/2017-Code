package org.usfirst.frc.team1699.utils.command;

import java.util.HashMap;
import java.util.Map;

public class CommandMap {
	private Map<String, Command> cmds;
	
	/**
	 * Constructor
	 */
	public CommandMap(){
		cmds = new HashMap<String, Command>();
	}
	
	/**
	 * Returns the map
	 * 
	 * @return cmds
	 */
	public Map<String, Command> getCmds(){
		return cmds;
	}
	
	/**
	 * Gets Command for a key
	 * 
	 * @param key
	 * @return Command
	 */
	public Command getCommand(String key){
		return cmds.get(key);
	}
	
	/**
	 * Returns true if map contains a key
	 * 
	 * @param key
	 * @return boolean
	 */
	public boolean hasKey(String key){
		return cmds.containsKey(key);
	}
	
	/**
	 * Removes command for a key
	 * 
	 * @param key
	 */
	public void removeCmd(String key){
		cmds.remove(key);
	}
	
	/**
	 * Returns the size of the Map
	 * 
	 * @return size
	 */
	public int size(){
		return cmds.size();
	}
	
	/**
	 * Adds command to the array
	 * 
	 * @param key
	 * @param cmd
	 */
	public void addEntry(String key, Command cmd){
		if(cmds.containsKey(key)){
			throw new NameUsedException();
		}
		
		cmds.put(key, cmd);
	}
}
