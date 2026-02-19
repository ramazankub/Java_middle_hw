package org.example.homeWorks.hw3.components;

public class Main {
    public static void main(String[] args) {

        DeskFactory factory = new DeskFactory();

        Desk desk = factory.createCommonDesk();

        System.out.println(desk + " - " + desk.calculateTotalPrice());
    }
}
