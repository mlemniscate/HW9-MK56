package ir.maktab.store.controler.menu;

import ir.maktab.util.input.InputInt;

/*
* Menu is an abstract class that help you to create your sub menus
* */
public class Menu {
    private String[] items;

    public Menu(String[] items) {
        this.items = items;
    }

    // This method for showing menu for user
    public void showMenu() {
        System.out.println("------------------------------------------");
        for (int i = 0; i < items.length; i++) {
            System.out.printf("[%d] - %s%n", (i+1), items[i]);
        }
        System.out.println("------------------------------------------");
    }

    // This method taking input from user
    public int getChosenItem() {
        return new InputInt("Enter an item number: ", items.length, 1, null)
                .getIntInput();
    }

    public String[] getItems() {
        return items;
    }
}
