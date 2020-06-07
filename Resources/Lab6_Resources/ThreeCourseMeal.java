package com.pocurestaurant.menu;

public class ThreeCourseMeal {
    private static final int PRICE = 25;

    private int price;

    private Appetizer appetizer = null;
    private MainCourse mainCourse = null;
    private Dessert dessert = null;

    public ThreeCourseMeal() {
        this.price = PRICE;
    }

    public int getPrice() {
        return this.price;
    }

    public boolean isValid() {
        return this.appetizer != null && this.mainCourse != null && this.dessert != null;
    }

    public Appetizer getAppetizer() {
        assert (this.appetizer != null) : "call isValid() first!";
        return this.appetizer;
    }

    public MainCourse getMainCourse() {
        assert (this.mainCourse != null) : "call isValid() first!";
        return this.mainCourse;
    }

    public Dessert getDessert() {
        assert (this.dessert != null) : "call isValid() first!";
        return this.dessert;
    }

    public void setMainCourse(MainCourse mainCourse) {
        this.mainCourse = mainCourse;
    }

    public void setAppetizer(Appetizer appetizer) {
        this.appetizer = appetizer;
    }

    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }
}
