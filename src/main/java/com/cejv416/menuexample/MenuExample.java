package com.cejv416.menuexample;

import java.util.Scanner;

/**
 * An example of a menu
 *
 * @author Ken Fogel
 */
public class MenuExample {

    private final Scanner sc;

    private final double MAX_CHEESE = 500.0;
    private final double MAX_POTATO = 1.0;
    private final double MAX_MOOSE = 25.0;

    /**
     * Constructor
     */
    public MenuExample() {
        sc = new Scanner(System.in);
    }

    /**
     * Method from which all other methods are called
     */
    public void perform() {
        char choice;
        double cost = 0.0;

        do {
            choice = menu();
            System.out.println("Choice = " + choice);
            switch (choice) {
                case 'A' -> {
                    loveCheese();
                    cost = retrieveValue("Cost of Cheese", MAX_CHEESE);
                }
                case 'B' -> {
                    lovePotato();
                    cost = retrieveValue("Cost of Potato", MAX_POTATO);
                }
                case 'C' -> {
                    loveMoose();
                    cost = retrieveValue("Cost of Moose", MAX_MOOSE);
                }
                case 'D' ->
                    System.out.println("Exiting");
                default ->
                    System.out.println("I should never see this");
            }
            if (cost > 0.0) {
                System.out.println("Value = " + cost);
            }
        } while (choice != 'D');
    }

    /**
     * Prompt for a value
     */
    private void promptValue(String category, double maximum) {
        System.out.println(category + ": Enter a value greater than zero and less than " + maximum);
    }

    /**
     * Get a double from the user
     *
     * @return value greater than zero and less than or equal maximum
     */
    private double retrieveValue(String category, double maximum) {

        // Negative number is invalid
        double value = -1;
        do {
            promptValue(category, maximum);
            if (sc.hasNextDouble()) {
                value = sc.nextDouble();
            } else {
                value = -1;
            }
            sc.nextLine();
        } while (value <= 0 || value > maximum);

        return value;
    }

    /**
     * Show the menu
     */
    private void displayMenuText() {
        System.out.println("Please enter the letter for one of the following:");

        System.out.println("A. Cheese");
        System.out.println("B. Potato");
        System.out.println("C. Moose");
        System.out.println("D. Exit");
    }

    /**
     * Routine to display a menu that accepts choices A to D
     *
     * @return the menu choice
     */
    public char menu() {

        char choice = 'z';

        do {
            displayMenuText();
            if (sc.hasNext("[a-dA-D]")) {
                choice = sc.next().toUpperCase().charAt(0);
            } else {
                choice = 'z';
            }
            sc.nextLine();
        } while (choice == 'z');
        return choice;
    }

    /**
     * The cheese method
     */
    private void loveCheese() {
        System.out.println("I love cheese!");
    }

    /**
     * The potato method
     */
    private void lovePotato() {
        System.out.println("I love potato!");
    }

    /**
     * The moose method
     */
    private void loveMoose() {
        System.out.println("I love moose!");
    }

    /**
     * Where it all begins
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new MenuExample().perform();
    }

}
