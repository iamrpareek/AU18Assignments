package com.au.Quest2;

public class CrisFactory implements Factory {
	@Override
    public Football createFootball() {
        return new CrisFootball();
    }

    @Override
    public Studs createStuds() {
        return new CrisStuds();
    }

}
