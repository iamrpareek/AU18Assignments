package com.au.Quest2;

public class Products {
	private Football fball;
	private Studs s;

	public Products(Factory f) {
		s = f.createStuds();
		fball = f.createFootball();
	}

	public void create() {
		s.createStuds();
		fball.createFootball();
	}

}
