package com.au.Quest2;

public class LaraFactory implements Factory {
	@Override
    public LaraStuds createStuds() {
        return new LaraStuds();
    }

    @Override
    public LaraFootball createFootball() {
        return new LaraFootball();
    }

}
