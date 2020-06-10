package io.neolab.internship.stringreverse;

import io.neolab.internship.stringreverse.handler.StringHandler;

import java.util.Scanner;

/**
 * Main class.
 */
public final class Main {

    /**
     * Main function where we test revertString function.
     *
     * @param args - command line arguments.
     */
    public static void main(final String[] args) {
        System.out.print("Input a string to revert: ");
        final Scanner scanner = new Scanner(System.in);

        String output = StringHandler.revertString(scanner.nextLine());
        System.out.println("Output: " + output);
    }

    private Main() {}
}
