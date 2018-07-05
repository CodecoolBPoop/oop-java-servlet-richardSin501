package com.codecool.webshop;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ItemStore {

    public static List<Item> listOfItems = new LinkedList<>();
    public static List<Item> shoppingCart = new LinkedList<>();

    public static void addItem(Item newItem) {
        listOfItems.add(newItem);
    }

    public static void addToCart(int addId) {
        ListIterator<Item> iterator = listOfItems.listIterator();
        Item newItem = null;
        while (iterator.hasNext()) {
            Item current = iterator.next();
            if(current.getId() == addId) {
                newItem = current;
                break;
            }
        }
        if (newItem != null) shoppingCart.add(newItem);
    }

    public static void removeFromCart(int itemId) {
        shoppingCart.removeIf(item -> item.getId() == itemId);
    }
}
