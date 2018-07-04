package com.codecool.webshop;

public class Item {

    private static int NEXT_ID = 1;
    private int id;
    private String name = null;
    private double price = 0;


    public Item() {
        this.id = NEXT_ID;
        Item.NEXT_ID++;
    }

    public Item(String name, double price) {
        this();
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
