package com.pocurestaurant.menu;

import java.util.ArrayList;

public class NoHeavyMeal {
    private static final int PRICE = 15;

    private int price;
    private boolean isValid;
    private ArrayList<Appetizer> appetizers = new ArrayList<>();
    private Dessert dessert = null;

    protected NoHeavyMeal() {
        this.price = PRICE;
    }

    public int getPrice() {
        return this.price;
    }

    public boolean isValid() {
        return this.appetizers.size() == 2 && this.dessert != null;
    }

    public ArrayList<Appetizer> getAppetizers() {
        return this.appetizers;
    }

    public Dessert getDessert() {
        assert (this.dessert != null) : "call isValid() first!";
        return this.dessert;
    }

    public void setAppetizers(Appetizer appetizer1, Appetizer appetizer2) {
        this.appetizers.clear();

        this.appetizers.add(appetizer1);
        this.appetizers.add(appetizer2);
    }

    public void setDessert(Dessert desert) {
        this.dessert = desert;
    }
}
