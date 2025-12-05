package com.pluralsight.utilities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUtil {
    private static final Scanner keyboard = new Scanner(System.in);
    private static final int INVALID_INPUT = -1;

    public static int getIntInRange(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                String input = keyboard.nextLine().trim();
                int value = Integer.parseInt(input);

                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public static int getIntFromUser(String prompt){
        while (true) {
            System.out.print(prompt);
            try {
                int num = keyboard.nextInt();
                keyboard.nextLine();
                return num;
            } catch (InputMismatchException e) {
                keyboard.nextLine();
                return INVALID_INPUT;
            }
        }
    }

    public static String getNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = keyboard.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("Input cannot be empty. Please try again.");
            }
        }
    }

    public static void pressEnterToContinue() {
        System.out.print("\nPress Enter to continue...");
        keyboard.nextLine();
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // If clear doesn't work, just print blank lines
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

    public static void exitProgram() {
        System.out.println("Program shutting down...");
        keyboard.close();
        System.exit(0);
    }
}
