package com.au.Quest3;


public abstract class House {

	public final void buildHouse(){
		DesignStructure();
	    DesignWalls();
	    DesignDoors();
	    DesignWindows();
	    DesignFurnishing();
		System.out.println("House built !");
	}

	private void DesignStructure() 
	{
		System.out.println("Structure designed... ");
	}

	private void DesignWindows() 
	{
		System.out.println("Windows built...");
	}	
	
	private void DesignDoors() 
	{
		System.out.println("Doors built...");
	}
	
	private void DesignFurnishing() 
	{
		System.out.println("Furnishings done...");
	}

	public abstract void DesignWalls();
}