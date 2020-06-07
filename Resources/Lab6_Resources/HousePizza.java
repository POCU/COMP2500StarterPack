package com.pocurestaurant.menu;

import java.util.ArrayList;

public class HousePizza {
    private static final int PRICE = 20;
    private static final int MAX_MEAT_COUNT = 2;

    private int price;
    private ArrayList<Topping> toppings = new ArrayList<>();

    private int meatCount;

    protected HousePizza() {
        this.price = PRICE;
        this.toppings.add(Topping.BLACK_OLIVES);
        this.toppings.add(Topping.RED_ONIONS);
        this.toppings.add(Topping.GREEN_PEPPERS);
        this.toppings.add(Topping.MOZZARELLA_CHEESE);
    }

    public int getPrice() {
        return this.price;
    }

    public boolean isValid() {
        return this.meatCount == MAX_MEAT_COUNT;
    }

    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }

    public boolean addBacon() {
        if (this.meatCount >= MAX_MEAT_COUNT) {
            return false;
        }

        this.toppings.add(Topping.BACON);
        this.meatCount++;
        return true;
    }

    public boolean removeBacon() {
        boolean isRemoved = this.toppings.remove(Topping.BACON);

        if (isRemoved) {
            this.meatCount--;
        }

        return isRemoved;
    }

    public boolean addPeperoni() {
        if (this.meatCount >= MAX_MEAT_COUNT) {
            return false;
        }

        this.toppings.add(Topping.PEPERONI);
        this.meatCount++;
        return true;
    }

    public boolean removePeperoni() {
        boolean isRemoved = this.toppings.remove(Topping.PEPERONI);

        if (isRemoved) {
            this.meatCount--;
        }

        return isRemoved;
    }

    public boolean addSausages() {
        if (this.meatCount >= MAX_MEAT_COUNT) {
            return false;
        }

        this.toppings.add(Topping.SAUSAGES);
        this.meatCount++;
        return true;
    }

    public boolean removeSausages() {
        boolean isRemoved = this.toppings.remove(Topping.SAUSAGES);

        if (isRemoved) {
            this.meatCount--;
        }

        return isRemoved;
    }
}