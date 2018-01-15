package com.au.Quest3;

public class HomeType 
{
	public static void main(String[] args) 
	{	
		House h = new CementHouse();
		System.out.println("Cement-house");
		h.buildHouse();
		h = new GlassHouse();
		System.out.println("\nGlass-house");
		h.buildHouse();
	}

}
