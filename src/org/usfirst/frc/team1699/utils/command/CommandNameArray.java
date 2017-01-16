/**
 * A class that houses an array list and makes sure that each name is unique
 * 
 * @author squirlemaster42
 */
package org.usfirst.frc.team1699.utils.command;

import java.util.ArrayList;

public class CommandNameArray {
	private ArrayList<String> list;

	/**
	 * Constructor
	 */
	public CommandNameArray() {
		list = new ArrayList<String>();
	}

	/**
	 * Adds a name to the array
	 * 
	 * @param name
	 */
	public void addName(String name) {
		if(list.contains(name)){
			System.err.println("Id has already been used.");
			return;
		}
		list.add(name);
	}

	/**
	 * Returns the list
	 * 
	 * @return list
	 */
	public ArrayList<String> getList() {
		return list;
	}
}
