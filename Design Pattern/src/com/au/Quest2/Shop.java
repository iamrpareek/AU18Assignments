package com.au.Quest2;

public class Shop {
	private static Products configureProducts() {
        Products app;
        Factory f;
        
        String s = "LARA".toLowerCase();
        if (s.contains("lara")) {
            f = new LaraFactory();
            app = new Products(f);
        } else {
            f = new CrisFactory();
            app = new Products(f);
        }
        return app;
    }

    public static void main(String[] args) {
        Products app = configureProducts();
        app.create();
    }

}
