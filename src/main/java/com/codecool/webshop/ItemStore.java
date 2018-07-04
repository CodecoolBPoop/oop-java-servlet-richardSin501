package com.codecool.webshop;

import java.util.ArrayList;
import java.util.List;

public class ItemStore {
    public static List<Item> listOfItems = new ArrayList<>();

    public static void addItem(Item newItem) {
        listOfItems.add(newItem);
    }

    public static void removeItem(int itemId) {
        listOfItems.remove(itemId);
    }
}
