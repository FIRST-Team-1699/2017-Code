/**
 * A class that houses an array list and makes sure that each id is unique
 * 
 * @author squirlemaster42
 */
package org.usfirst.frc.team1699.utils.command;

import java.util.ArrayList;

public class CommandIdArray {
	private ArrayList<Integer> list;

	/**
	 * Constructor
	 */
	public CommandIdArray() {
		list = new ArrayList<Integer>();
	}

	/**
	 * Adds id to array
	 * 
	 * @param id
	 */
	public void addId(int id) {
		if (list.contains(id)) {
			System.err.println("Id has already been used.");
			return;
		}

		list.add(id);
	}

	/**
	 * Returns the array
	 * 
	 * @return list
	 */
	public ArrayList<Integer> getList() {
		return list;
	}
}
