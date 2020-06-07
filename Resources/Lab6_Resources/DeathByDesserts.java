package com.pocurestaurant.menu;

import java.util.ArrayList;

public class DeathByDesserts {
    private static final int PRICE = 20;

    private int price;
    private boolean isValid;
    private ArrayList<Dessert> desserts = new ArrayList<>();

    protected DeathByDesserts() {
        this.price = PRICE;
    }

    public int getPrice() {
        return this.price;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public ArrayList<Dessert> getDesserts() {
        return this.desserts;
    }

    public void setDesserts(Dessert dessert1, Dessert dessert2, Dessert dessert3) {
        this.desserts.clear();

        this.desserts.add(dessert1);
        this.desserts.add(dessert2);
        this.desserts.add(dessert3);
        this.isValid = true;
    }
}
