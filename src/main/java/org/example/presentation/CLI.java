package org.example.presentation;

import org.example.presentation.menu.Menu;

public class CLI {
    public void start() {
        System.out.println("//");
        Menu menu = new Menu();
        menu.printMenu();
    }
    
}
